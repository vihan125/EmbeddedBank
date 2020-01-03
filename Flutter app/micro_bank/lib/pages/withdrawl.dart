

import 'dart:convert';
import 'package:micro_bank/DataBase/model/balance.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart';
import 'package:micro_bank/DataBase/DatabaseHelper.dart';
import 'package:micro_bank/DataBase/model/MBA_accounts.dart';
import 'package:micro_bank/DataBase/model/transactions.dart';
import 'package:micro_bank/dataTransfer.dart';
import 'package:rflutter_alert/rflutter_alert.dart';
import 'package:sqflite/sqflite.dart';


class Withdraw extends StatefulWidget {
  @override
  _WithdrawState createState() => _WithdrawState();
}

class _WithdrawState extends State<Withdraw> {

  String amount;
  String date_time;
  Map acc_data = {};
  @override
  Widget build(BuildContext context) {

    acc_data= ModalRoute.of(context).settings.arguments;

    return Scaffold(
        backgroundColor: Colors.grey[800],
        appBar: AppBar(
          title: Text('Withdraw',
            style: TextStyle(
              fontSize: 30.0,
              fontFamily: 'fonts/Anton-Regular.ttf',
              fontWeight: FontWeight.bold,
              color: Colors.white,
            ),),
          centerTitle: true,
          backgroundColor: Colors.cyan,
        ),
        body: Padding(
            padding: const EdgeInsets.fromLTRB(30.0, 0.0 , 30.0, 0.0),
            child: SingleChildScrollView(
                child:Center(
                  child: Column(
                      children: <Widget>[
                        SizedBox(height: 100.0,),
                        Center(

                          child:TextField(
                            onChanged: (String input_2){
                              amount = input_2;
                            },
                            decoration: InputDecoration(
                              hintText: 'Amount',
                              border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(15.0),
                              ),
                              hintStyle: TextStyle(
                                color: Colors.black,
                                fontSize: 20.0,
                              ),
                              fillColor: Colors.grey[200],
                              filled: true,

                            ),
                          ),
                        ),
                        SizedBox(height: 70.0,),
                        RaisedButton(
                          onPressed: () async {
                            MBA_account ma = acc_data['account'];
                            String acc_id = ma.MBA_id.toString();
                            var balance = double.parse(ma.balance.toString());
                            var wAmount = double.parse(amount);
                            Response response = await get(
                                "http://worldtimeapi.org/api/timezone/Asia/Colombo");
                            Map data = jsonDecode(response.body);

                            String datetime = data['datetime'];
                            String date = datetime.substring(0, 10);
                            String time = datetime.substring(11, 19);
                            date_time = date + ' ' + time;

                            DataTransfer dt = new DataTransfer();


                            Database db = await DataBaseHelper.instance.db;
                            var Dbalance = await db.rawQuery('select * from balance');
                            Balance b = Balance.fromMap(Dbalance.first);
                            double DeviceBalance = double.parse(b.balance.toString());
                            if ( (amount == null)) {
                              Alert(context: context,
                                  title: 'Provided fields cannot be Empty !')
                                  .show();
                            } else {
                                if(wAmount<DeviceBalance){
                                    var last_id = await db.rawQuery('select * from transactions order by transaction_id DESC limit 1');
                                    if (last_id.isEmpty) {

                                           if (wAmount < ma.balance) {
                                                await db.execute(
                                                    'insert into transactions (account_id,date_time,amount,type)'
                                                     'values("$acc_id","$date_time","$amount","Withdrawl")');
                                                var new_id = await db.rawQuery(
                                                   'select * from transactions order by transaction_id DESC limit 1');

                                                     if (new_id.isNotEmpty) {
                                                           Transactions t = Transactions.fromMap(
                                                                               new_id.first);
                                                           String new_t = t.transaction_id.toString();
                                                           await db.execute('insert into makes values("$acc_id","$new_t")');
                                                           String new_balance = (balance-wAmount).toString();
                                                           String new_Dalance = (DeviceBalance-wAmount).toString();
                                                           await db.rawQuery('update MBA_accounts set balance = "$new_balance" where MBA_id = "$acc_id"');
                                                           await db.rawQuery('update balance set balance = "$new_Dalance" where agent_id = "123"');
                                                           Navigator.pushReplacementNamed(context, '/success');
                                                    } else {
                                                        Alert(context: context,
                                                        title: 'Transaction Incomplete..Please check the account ID')
                                                        .show();
                                                   }
                                          } else {
                                               Alert(context: context, title: 'Your account balance is not enought to proceed this transaction')
                                              .show();
                                          }
                                  } else {

                                          if (wAmount < ma.balance) {
                                              Transactions t1 = Transactions.fromMap(
                                                                last_id.first);
                                              await db.execute('insert into transactions (account_id,date_time,amount,type)'
                                                                'values("$acc_id","$date_time","$amount","Withdrawl")');
                                              var new_id = await db.rawQuery(
                                                  'select * from transactions order by transaction_id DESC limit 1');
                                              Transactions t2 = Transactions.fromMap(
                                                        new_id.first);

                                                if (t1.transaction_id + 1 ==t2.transaction_id) {
                                                      String new_t = t2.transaction_id.toString();
                                                      await db.execute('insert into makes values("$acc_id","$new_t")');
                                                      String new_balance = (balance-wAmount).toString();
                                                      String new_Dalance = (DeviceBalance-wAmount).toString();
                                                      await db.rawQuery('update MBA_accounts set balance = "$new_balance" where MBA_id = "$acc_id"');
                                                      await db.rawQuery('update balance set balance = "$new_Dalance" where agent_id = "123"');
                                                      var trans =  await db.rawQuery(
                                                          'select * from transactions');

                                                      if(trans.length >= 5){
                                                        for(int i = 0 ; i<5;i++){
                                                          Transactions t = Transactions.fromMap(trans[i]);
                                                          dt.sendData(t);
                                                        }

                                                       /* Future.delayed(const Duration(milliseconds: 30000),()
                                                        {*/
                                                          db.execute('delete from transactions');
                                                          db.execute('delete from makes');
                                                       /* });*/
                                                      }


                                                      Navigator.pushReplacementNamed(context, '/success');
                                                } else {
                                                    Alert(context: context,
                                                    title: 'Transaction Incomplete..Please check the account ID')
                                                     .show();
                                                    }
                                          }else{
                                               Alert(context: context,
                                                   title: 'Your account balance is not enought to proceed this transaction')
                                                  .show();
                                          }
                                        }
                                    }else{
                                         Alert(context: context,
                                             title: 'Device balance is not enought to proceed this transaction')
                                            .show();
                              }
                            }
                          },
                          shape: new RoundedRectangleBorder(
                              borderRadius: new BorderRadius.circular(30.0),
                              side: BorderSide(color: Colors.green)),
                          color: Colors.green,
                          child: Padding(
                            padding: const EdgeInsets.all(10.0),
                            child: Text('Make Transaction',
                              style: TextStyle(
                                  fontSize: 25.0,
                                  fontWeight: FontWeight.bold,
                                  letterSpacing: 1.0,
                                  color: Colors.white
                              ),),
                          ),

                        )
                      ]
                  ),
                )
            )
        )

    );
  }
}

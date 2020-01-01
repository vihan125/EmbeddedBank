
import 'package:flutter/material.dart';
import 'package:micro_bank/DataBase/DatabaseHelper.dart';
import 'package:micro_bank/DataBase/model/balance.dart';
import 'package:rflutter_alert/rflutter_alert.dart';
import 'package:sqflite/sqflite.dart';

class update extends StatefulWidget {
  @override
  _updateState createState() => _updateState();
}

class _updateState extends State<update> {
  String amount;
  Map data = {};
  @override
  Widget build(BuildContext context) {

    data= ModalRoute.of(context).settings.arguments;

    return Scaffold(
        backgroundColor: Colors.grey[800],
        appBar: AppBar(
          title: Text('Updates',
            style: TextStyle(
              fontSize: 30.0,
              fontFamily: 'fonts/Anton-Regular.ttf',
              fontWeight: FontWeight.bold,
              color: Colors.white,
            ),),
          centerTitle: true,
          backgroundColor: Colors.green,
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

                            String uAmount = amount.toString();
                            Balance acc = data['acc'];
                            String acc_id = acc.agent_id.toString();
                            var dAmount = double.parse(amount);



                            Database db = await DataBaseHelper.instance.db;
                            if ((amount == null)) {
                              Alert(context: context,
                                  title: 'Provided fields cannot be Empty !')
                                  .show();
                            } else {
                              await db.rawQuery('update balance set balance = "$uAmount" where agent_id = "$acc_id"');
                              Navigator.pushReplacementNamed(context, '/success');


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

                        ),
                      ]
                  ),
                )
            )
        )

    );
  }
}

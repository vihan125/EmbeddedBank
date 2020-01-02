
import 'package:flutter/material.dart';
import 'package:micro_bank/DataBase/DatabaseHelper.dart';
import 'package:sqflite/sqflite.dart';

class Success extends StatefulWidget {
  @override
  _SuccessState createState() => _SuccessState();
}

class _SuccessState extends State<Success> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.redAccent,
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Center(
          child: Column(
            children: <Widget>[
              SizedBox(height: 50.0,),
              Text('Transaction',
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 40.0,
                  fontFamily: 'fonts/Anton-Regular.ttf',
                  color: Colors.white,
                ),),
              Text('Successful',
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 50.0,
                  fontFamily: 'fonts/Anton-Regular.ttf',
                  color: Colors.white,
                ),),
              SizedBox(height: 30.0,),

              Icon(Icons.check_circle,
              color: Colors.white,
              size: 50.0,),
              SizedBox(height: 30.0,),
              RaisedButton(
                onPressed: ()async{
                  Database db = await DataBaseHelper.instance.db;
                  //db.execute('delete from transactions');
                  //db.rawQuery('update MBA_accounts set balance = "10000" where MBA_id = "12345"');
                  Navigator.pushReplacementNamed(context, '/home');
                },
                shape: new RoundedRectangleBorder(
                    borderRadius: new BorderRadius.circular(10.0),
                    side: BorderSide(color: Colors.red)),
                color: Colors.white,
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Text('Back',
                    style: TextStyle(
                        fontSize: 20.0,
                        fontWeight: FontWeight.bold,
                        fontFamily:'fonts/Anton-Regular.ttf',
                        letterSpacing: 1.0,
                        color: Colors.black
                    ),),
                ),
              ),
            ],
          ),
        ),
      )
    );
  }
}

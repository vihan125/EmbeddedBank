
import 'package:flutter/material.dart';
import 'package:micro_bank/DataBase/DatabaseHelper.dart';
import 'package:micro_bank/DataBase/model/balance.dart';
import 'package:rflutter_alert/rflutter_alert.dart';
import 'package:sqflite/sqflite.dart';

class agent extends StatefulWidget {
  @override
  _agentState createState() => _agentState();
}

class _agentState extends State<agent> {
  String username;
  String password;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.grey[200],
        appBar: AppBar(
          title:
          Text('Micro Bank',
            style: TextStyle(
              fontFamily: 'fonts/Anton-Regular.ttf',
              fontSize: 40.0,
              fontWeight: FontWeight.bold,
              letterSpacing: 1.0,
              color: Colors.white,
            ),
          ),
          centerTitle: true,
          backgroundColor: Colors.cyan,
          elevation: 0.0,
        ),

        body:
        Padding(
          padding: const EdgeInsets.fromLTRB(30.0, 0.0 , 30.0, 0.0),
          child: SingleChildScrollView(
              child:Column(
                  children: <Widget>[
                    SizedBox(height: 70.0,),
                    Text('HELLO AGENT',
                      style: TextStyle(
                        fontSize: 50.0,
                        fontFamily: 'fonts/Girassol-Regulat.ttf',
                        fontWeight: FontWeight.bold,
                        color: Colors.cyan,
                        letterSpacing: 2.0,
                      ),),
                    SizedBox(height: 10.0,),
                    Text('Please log in to continue',
                      style: TextStyle(
                        fontSize: 20.0,
                        fontFamily:'fonts/Anton-Regular.ttf',
                        color: Colors.cyan,
                      ),),

                    SizedBox(height: 30.0,),
                    Center(

                      child:TextField(
                        onChanged: (String input_1){
                          username = input_1;
                        },
                        decoration: InputDecoration(
                            hintText: 'Username',
                            border: OutlineInputBorder(
                              borderRadius: BorderRadius.circular(10.0),
                            ),
                            hintStyle: TextStyle(
                              color: Colors.black,
                              fontSize: 20.0,
                            ),
                            fillColor: Colors.grey[200],
                            filled: true,
                            suffixIcon: Icon(Icons.account_circle,
                              color: Colors.black87,)
                        ),
                      ),
                    ),
                    SizedBox(height: 30.0,),
                    Center(

                      child:TextField(
                        onChanged: (String input_2){
                          password = input_2;
                        },
                        decoration: InputDecoration(
                            hintText: 'Password',
                            border: OutlineInputBorder(
                              borderRadius: BorderRadius.circular(10.0),

                            ),
                            hintStyle: TextStyle(
                              color: Colors.black,
                              fontSize: 20.0,
                            ),
                            fillColor: Colors.grey[200],
                            filled: true,
                            suffixIcon: Icon(Icons.lock_outline,
                              color: Colors.black87,)

                        ),
                        obscureText: true,
                      ),
                    ),
                    SizedBox(height: 30.0,),
                    RaisedButton(
                      onPressed: () async{
                        Database db = await DataBaseHelper.instance.db;
                        var result = await db.query('balance', where: 'username = ?', whereArgs:[username]);
                        if(result.isNotEmpty){
                          Balance acc = Balance.fromMap(result.first);
                          if (acc.password == password){
                            Navigator.pushReplacementNamed(context, '/update',arguments: {'acc':acc});
                          }
                          else{
                            Alert(context: context,title: 'Password is incorrect !').show();
                          }
                        }
                        else{
                          Alert(context: context,title: 'Username entered does not exist ! ').show();
                        }
                      },
                      shape: new RoundedRectangleBorder(
                          borderRadius: new BorderRadius.circular(18.0),
                          side: BorderSide(color: Colors.cyan)),
                      color: Colors.cyan,
                      child: Padding(
                        padding: const EdgeInsets.all(10.0),
                        child: Text('Log in',
                          style: TextStyle(
                              fontSize: 20.0,
                              fontWeight: FontWeight.bold,
                              letterSpacing: 1.0,
                              color: Colors.white
                          ),),
                      ),

                    ),

                  ]

              )),
        )
    );
  }
}

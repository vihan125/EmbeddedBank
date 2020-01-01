
import 'package:flutter/material.dart';

class home extends StatefulWidget {
  @override
  _homeState createState() => _homeState();
}

class _homeState extends State<home> {
  @override
  Widget build(BuildContext context) {
    return  Scaffold(
        backgroundColor: Colors.redAccent,
        body: Padding(
          padding: const EdgeInsets.all(10.0),
          child: Center(
            child: Column(
              children: <Widget>[
                SizedBox(height: 50.0,),
                Text('WELCOME TO',
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 40.0,
                    fontFamily: 'fonts/Anton-Regular.ttf',
                    color: Colors.white,
                  ),),
                Text('MICRO BANK',
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 60.0,
                    fontFamily: 'fonts/Anton-Regular.ttf',
                    color: Colors.white,
                  ),),
                SizedBox(height: 60.0,),

                RaisedButton(
                  onPressed: ()async{

                    Navigator.pushNamed(context, '/login');
                  },
                  shape: new RoundedRectangleBorder(
                      borderRadius: new BorderRadius.circular(10.0),
                      side: BorderSide(color: Colors.red)),
                  color: Colors.white,
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text('Customer log in',
                      style: TextStyle(
                          fontSize: 25.0,
                          fontWeight: FontWeight.bold,
                          fontFamily:'fonts/Anton-Regular.ttf',
                          letterSpacing: 1.0,
                          color: Colors.black
                      ),),
                  ),
                ),
                SizedBox(height: 50.0,),
                RaisedButton(
                  onPressed: ()async{

                    Navigator.pushNamed(context, '/agent');
                  },
                  shape: new RoundedRectangleBorder(
                      borderRadius: new BorderRadius.circular(10.0),
                      side: BorderSide(color: Colors.red)),
                  color: Colors.white,
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text('Agent updates',
                      style: TextStyle(
                          fontSize: 25.0,
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

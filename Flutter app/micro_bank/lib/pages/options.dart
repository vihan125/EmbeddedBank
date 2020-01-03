import 'package:flutter/material.dart';
import 'package:micro_bank/DataBase/model/MBA_accounts.dart';

class options extends StatefulWidget {
  @override
  _optionsState createState() => _optionsState();
}

class _optionsState extends State<options> {

  Map data ={};

  @override

  Widget build(BuildContext context) {

    data = ModalRoute.of(context).settings.arguments;
    MBA_account acc = data['acc'];
    String balance = acc.balance.toString();

    return Scaffold(
      backgroundColor: Colors.grey[200],
      appBar: AppBar(
        title: Padding(
          padding: const EdgeInsets.all(10.0),
          child: Text('Select an Option',
          style: TextStyle(
            fontWeight: FontWeight.bold,
            fontSize: 30.0,
            fontFamily: 'fonts/Anton-Regular.ttf',
            color: Colors.white,
            letterSpacing: 0.0,
          ),),
        ),
        centerTitle: true,
        elevation: 0.0,
        backgroundColor: Colors.red,
      ),

        body:
        Padding(
        padding: const EdgeInsets.fromLTRB(30.0, 0.0 , 30.0, 0.0),
          child: SingleChildScrollView(
            child:Center(
              child: Column(
                 children: <Widget>[
                      SizedBox(height: 90.0,),
                     RaisedButton(
                       onPressed: (){
                         Navigator.pushNamed(context, '/deposit',arguments: {'account':data['acc']});
                       },
                       shape: new RoundedRectangleBorder(
                           borderRadius: new BorderRadius.circular(18.0),
                           side: BorderSide(color: Colors.red)),
                       color: Colors.red,
                       child: Padding(
                         padding: const EdgeInsets.all(10.0),
                         child: Text('DEPOSIT MONEY',
                           style: TextStyle(
                               fontSize: 24.0,
                               fontWeight: FontWeight.bold,
                               fontFamily:'fonts/Anton-Regular.ttf',
                               letterSpacing: 1.0,
                               color: Colors.white
                           ),),
                       ),
                     ),
                   SizedBox(height: 50.0,),
                   RaisedButton(
                     onPressed: (){
                       Navigator.pushNamed(context, '/withdraw',arguments: {'account':data['acc']});
                     },
                     shape: new RoundedRectangleBorder(
                         borderRadius: new BorderRadius.circular(18.0),
                         side: BorderSide(color: Colors.red)),
                     color: Colors.red,
                     child: Padding(
                       padding: const EdgeInsets.all(10.0),
                       child: Text('WITHDRAW MONEY',
                         style: TextStyle(
                             fontSize: 24.0,
                             fontWeight: FontWeight.bold,
                             fontFamily:'fonts/Anton-Regular.ttf',
                             letterSpacing: 1.0,
                             color: Colors.white
                         ),),
                     ),
                   ),
                   SizedBox(height: 50.0,),
                   RaisedButton(
                     onPressed: (){
                       Navigator.pushReplacementNamed(context, '/login');
                     },
                     shape: new RoundedRectangleBorder(
                         borderRadius: new BorderRadius.circular(10.0),
                         side: BorderSide(color: Colors.blueAccent)),
                     color: Colors.blueAccent,
                     child: Padding(
                       padding: const EdgeInsets.all(15.0),
                       child: Text('Go back',
                         style: TextStyle(
                             fontSize: 20.0,
                             fontWeight: FontWeight.bold,
                             fontFamily:'fonts/Anton-Regular.ttf',
                             letterSpacing: 1.0,
                             color: Colors.white
                         ),),
                     ),
                   ),
                   SizedBox(height: 50.0,),
                   Text('Available balance :',
                   style: TextStyle(
                     fontSize: 30.0,
                     fontWeight: FontWeight.bold,
                     fontFamily: 'fonts/Girassol-Regular.ttf',
                     letterSpacing: 1.0,
                     color: Colors.redAccent,
                   ),
                   ),
                      SizedBox(height: 20.0,),
                   Text('$balance ',
                     style: TextStyle(
                       fontSize: 50.0,
                       fontWeight: FontWeight.bold,
                       fontFamily: 'fonts/Girassol-Regular.ttf',
                       letterSpacing: 1.0,
                       color: Colors.black,
                     ),
                   )]
                     ),
            )
                 )
        )
    );
  }
}

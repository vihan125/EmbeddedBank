



import 'dart:async';

import 'package:flutter/material.dart';
import 'package:micro_bank/dataTransfer.dart';
import 'package:micro_bank/pages/agent.dart';
import 'package:micro_bank/pages/login.dart';
import 'package:micro_bank/pages/options.dart';
import 'package:micro_bank/pages/update.dart';
import 'package:micro_bank/pages/withdrawl.dart';
import 'package:micro_bank/pages/deposit.dart';
import 'package:micro_bank/pages/successful.dart';
import 'package:micro_bank/pages/home.dart';
import 'package:sqflite/sqflite.dart';

import 'DataBase/DatabaseHelper.dart';
import 'DataBase/model/transactions.dart';


void main() {
  runApp(MaterialApp(
    initialRoute: '/home',
    routes: {
      '/login': (context) => logIn(),
      '/options': (context) => options(),
      '/deposit': (context) => deposit(),
      '/success': (context) => Success(),
      '/withdraw': (context) => Withdraw(),
      '/home': (context) => home(),
      '/agent': (context) => agent(),
      '/update': (context) => update(),
    },
  )
  );

  Timer.periodic(new Duration(minutes: 2), (timer) async {
    Database db = await DataBaseHelper.instance.db;
    DataTransfer dt = new DataTransfer();
    var trans =  await db.rawQuery('select * from transactions');
    int length = trans.length;
    if (length >0) {
      for (int i = 0; i < length; i++) {
        Transactions t = Transactions.fromMap(trans[i]);
        dt.sendData(t);
      }

      Future.delayed(const Duration(milliseconds: 5), () {
        db.execute(
            'delete from transactions');
        db.execute(
            'delete from makes');
      });
    }
  });

}









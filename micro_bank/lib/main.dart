



import 'package:flutter/material.dart';
import 'package:micro_bank/pages/agent.dart';
import 'package:micro_bank/pages/login.dart';
import 'package:micro_bank/pages/options.dart';
import 'package:micro_bank/pages/update.dart';
import 'package:micro_bank/pages/withdrawl.dart';
import 'package:micro_bank/pages/deposit.dart';
import 'package:micro_bank/pages/successful.dart';
import 'package:micro_bank/pages/home.dart';


void main() => runApp(MaterialApp(
  initialRoute: '/success',
  routes: {
    '/login':(context) => logIn(),
    '/options':(context) => options(),
    '/deposit':(context) => deposit(),
    '/success':(context) => Success(),
    '/withdraw':(context) => Withdraw(),
    '/home':(context) => home(),
    '/agent':(context) => agent(),
    '/update':(context) => update(),
  },


));









import 'dart:convert';

import 'package:http/http.dart';
import 'package:sqflite/sqflite.dart';

import 'DataBase/DatabaseHelper.dart';
import 'DataBase/model/transactions.dart';

class DataTransfer {



  sendData(Transactions t) async {
    Database db = await DataBaseHelper.instance.db;

    Response response_auth = await post('http://192.168.43.168:6973/auth',
        headers: {'Content-Type': 'application/json', 'MBA_ID': '2','password':'Tharaka'});
    Map data_1 = jsonDecode(response_auth.body);
    print(data_1['privateKey']);
    if (t.type == 'Deposit') {
      String privateKey = data_1["privateKey"];
      String amount = t.amount.toString();
      String account_id = t.account_id.toString();

      Response response_depo = await post('http://192.168.43.168:6973/mDeposit',
          headers: {
            'Content-Type': 'application/json',
            'privatekey': privateKey,
            'amount': amount,
            'account_ID': account_id,
            'MU_id': '1'
          });
      Map data_2 = jsonDecode(response_depo.body);
      if (data_2['report'] == 'successful transaction') {
        String new_balance = data_2['balance'];
        String acc_id = data_2['account_ID'];
        await db.rawQuery(
            'update MBA_accounts set balance = "$new_balance" where MBA_id = "$acc_id"');
        print('database updated');
        print(t.account_id);
      } else {
        print('unable to update database');
      }
    } else if (t.type == 'Withdrawl') {
      String privateKey = data_1["privateKey"];
      String amount = t.amount.toString();
      String account_id = t.account_id.toString();

      Response response_depo = await post('http://192.168.43.168:6973/mDeposit',
          headers: {
            'Content-Type': 'application/json',
            'privatekey': privateKey,
            'amount': amount,
            'account_ID': account_id,
            'MU_id': '1'
          });
      Map data_2 = jsonDecode(response_depo.body);
      if (data_2['report'] == 'successful transaction') {
        String new_balance = data_2['balance'];
        String acc_id = data_2['account_ID'];
        await db.rawQuery(
            'update MBA_accounts set balance = "$new_balance" where MBA_id = "$acc_id"');
        print('database updated');
        print(t.account_id);
      }
    }
  }
}

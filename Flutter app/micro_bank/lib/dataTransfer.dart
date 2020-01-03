import 'dart:convert';

import 'package:http/http.dart';
import 'package:micro_bank/DataBase/model/MBA_accounts.dart';
import 'package:sqflite/sqflite.dart';

import 'DataBase/DatabaseHelper.dart';
import 'DataBase/model/transactions.dart';

class DataTransfer {




  sendData(Transactions t) async {
    Database db = await DataBaseHelper.instance.db;

    Response response_auth = await post('http://192.168.43.224:6973/auth',
        headers: {'Content-Type': 'application/json', 'MU_ID': '1','password':'agent123'});
    Map data_1 = jsonDecode(response_auth.body);
    print(data_1['privateKey']);
    if (t.type == 'Deposit') {
      String privateKey = data_1["privateKey"];
      String amount = t.amount.toString();
      String account_id = t.account_id.toString();

      Response response_depo = await post('http://192.168.43.224:6973/mDeposit',
          headers: {
            'Content-Type': 'application/json',
            'privatekey': privateKey,
            'amount': amount,
            'account_ID': account_id,
            'MU_ID': '1'
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

      Response response_depo = await post('http://192.168.43.224:6973/mWithdrawal',
          headers: {
            'Content-Type': 'application/json',
            'privatekey': privateKey,
            'amount': amount,
            'account_ID': account_id,
            'MU_ID': '1'
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

  updateUsers(MBA_account m) async {
    Database db = await DataBaseHelper.instance.db;
    String account_id = m.MBA_id.toString();

    Response response_auth = await post('http://192.168.43.224:6973/auth',
        headers: {'Content-Type': 'application/json', 'MU_ID': '1','password':'agent123'});
        Map data_1 = jsonDecode(response_auth.body);
        print(data_1['privateKey']);

    Response response_update = await post('http://192.168.43.224:6973/mobileRefresh',
        headers: {
          'Content-Type': 'application/json',
          'privatekey': data_1["privateKey"],
          'account_ID': account_id,
        });
    Map data_3 = jsonDecode(response_update.body);

    String new_balance = data_3['balance'];
    await db.rawQuery(
        'update MBA_accounts set balance = "$new_balance" where MBA_id = "$account_id"');

    print('database updated');





  }
}

import 'package:sqflite/sqflite.dart';
import 'dart:io' as io;
import 'package:path/path.dart';
import 'package:path_provider/path_provider.dart';

class DataBaseHelper {


  DataBaseHelper._privateConstructor();
  static final DataBaseHelper instance = DataBaseHelper._privateConstructor();

  static Database _db;

  Future<Database> get db async {
    if (_db != null) {
      return _db;
    }
    _db = await initDatabase();
    return _db;
  }

  initDatabase() async {
    io.Directory documentDirectory = await getApplicationDocumentsDirectory();
    String path = join(documentDirectory.path, 'FDDB1.db');
    var db = await openDatabase(path, version: 1, onCreate: _onCreate);
    return db;
  }

  _onCreate(Database db, int version) async {
    await db.
    execute('CREATE TABLE balance('
        'agent_id integer(10) PRIMARY KEY,'
        'balance numeric(10,2) not null,'
        'username TEXT not null,'
        'password TEXT not null)');
    await db
        .execute('CREATE TABLE MBA_accounts '
        '(MBA_id integer(10)PRIMARY KEY, '
        'username TEXT not null,'
        'password TEXT not null,'
        'acc_type TEXT not null,'
        'balance numeric(10,2) not null)');
    await db
        .execute('CREATE TABLE transactions('
        'transaction_id integer PRIMARY KEY AUTOINCREMENT,'
        'account_id integer(10),'
        'date_time TEXT,'
        'amount numeric(10,2),'
        'type TEXT)');
    await db
        .execute('CREATE TABLE makes ('
        'MBA_id integer(10) not null, '
        'transaction_id integer(10) not null,'
        'PRIMARY KEY(MBA_id,transaction_id),'
        'FOREIGN KEY(MBA_id) REFERENCES MBA_accounts(MBA_id),'
        'FOREIGN KEY(transaction_id) REFERENCES transactions(transaction_id))');

    await db
      .execute('insert into MBA_accounts values ("1","vihan","vihan123","teen","120000.00")');

    await db
        .execute('insert into MBA_accounts values ("2","tharaka","tharaka123","children","120000.00")');

    await db
        .execute('insert into balance values("345","50000","agent1","agent123")');
  }

}
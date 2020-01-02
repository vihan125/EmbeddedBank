class Transactions{

  int transaction_id;
  int account_id;
  String date_time;
  var amount;
  String type;

  Transactions({this.transaction_id,this.account_id,this.date_time,this.amount,this.type});

  Transactions.fromMap(Map<String, dynamic> map) {
    transaction_id =  map['transaction_id'];
    account_id =  map['account_id'];
    date_time =  map['date_time'];
    amount =  map['amount'];
    type =  map['type'];
  }

  Map<String, dynamic> toMap(){
    var map = <String, dynamic>{
      'tranaction_id': transaction_id,
      'account_id' :account_id,
          'date_time': date_time,
          'amount': amount,
          'type':type,
    };
    return map;
  }
}
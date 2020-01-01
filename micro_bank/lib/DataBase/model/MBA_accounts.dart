

class MBA_account{
  int MBA_id;
  String username;
  String password;
  String acc_type;
  var balance;

  MBA_account({this.MBA_id,this.username,this.password,this.acc_type,this.balance});

  MBA_account.fromMap(Map<String, dynamic> map) {
    MBA_id = map['MBA_id'];
    username =  map['username'];
    password = map['password'];
    acc_type = map['acc_type'];
    balance = map['balance'];
  }

  Map<String, dynamic> toMap(){
    var map = <String, dynamic>{
      'MBA_id': MBA_id,
      'username': username,
      'password' : password,
      'acc_type':acc_type,
      'balance':balance,
    };
    return map;
  }


}
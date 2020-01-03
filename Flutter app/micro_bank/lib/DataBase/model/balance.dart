class Balance {

  var balance;
  int agent_id;
  String username;
  String password;

  Balance({this.balance});

  Balance.fromMap(Map<String, dynamic> map) {
    balance = map['balance'];
    agent_id = map['agent_id'];
    username = map['username'];
    password = map['password'];

  }

  Map<String, dynamic> toMap(){
    var map = <String, dynamic>{
      'balance': balance,
      'agent_id' : agent_id,
      'username' : username,
      'password' : password,
    };
    return map;
  }
}
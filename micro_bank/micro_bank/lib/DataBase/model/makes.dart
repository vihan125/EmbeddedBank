class Makes {

  int MBA_id;
  int transaction_id;

  Makes({this.MBA_id,this.transaction_id,});

  Makes.fromMap(Map<String, dynamic> map) {
    MBA_id = map['MBA_id'];
    transaction_id =  map['transaction_id'];
  }

  Map<String, dynamic> toMap(){
    var map = <String, dynamic>{
      'MBA_id': MBA_id,
      'tranaction_id': transaction_id,
    };
    return map;
  }
}
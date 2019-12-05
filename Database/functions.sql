DELIMITER //

CREATE FUNCTION getAccount(MBA_ID_arg int(9),password_arg varchar(40)) RETURNS int(9)
BEGIN
 DECLARE customerID int(9);
  Select customer_ID from mobile_banking_account where MBA_ID=MBA_ID_arg and password= password_arg into customerID;
  RETURN customerID;
END 

//

DELIMITER ;
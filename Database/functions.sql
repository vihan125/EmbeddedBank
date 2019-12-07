DELIMITER //

CREATE FUNCTION getAccount(MBA_ID_arg int(9),password_arg varchar(40)) RETURNS int(9)
BEGIN
 DECLARE customerID int(9);
  Select customer_ID from mobile_banking_account where MBA_ID=MBA_ID_arg and password= password_arg into customerID;
  RETURN customerID;
END 

//

DELIMITER ;




/*
 *  
 * Make deposits procedure 
 * 
 * 
 * */

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `makeDeposit`(IN `account_ID_arg` INT(9), IN `amount_arg` DECIMAL(12,2), IN `date_of_deposit_arg` DATE)
    MODIFIES SQL DATA
BEGIN
 DECLARE balance_arg decimal(12,2);
 DECLARE deposit_ID_arg int(9);

/* BEGIN TRAN */

 START TRANSACTION; 
/* get the current balance from the account to balance_arg variable */
 SELECT balance INTO balance_arg from account where account_ID = account_ID_arg;
 
 /* update the value */
 SELECT balance_arg + amount_arg into balance_arg ;
 
 /* update the table to new value */
 UPDATE account set balance = balance_arg where account_ID = account_ID_arg;
 
 /* insert the data to deposits table */
 INSERT into deposits(date_of_deposit,amount) values(date_of_deposit_arg, amount_arg);
 
 /* get the primary key from deposits table to deposit_ID_arg*/
 SET deposit_ID_arg = LAST_INSERT_ID();
 
 /* insert account_Id and deposit_ID_arg to the make deposits table */
 INSERT into makes_deposit values(account_ID_arg, deposit_ID_arg);
 COMMIT;

END$$
DELIMITER ;



/*
 *  
 * Make withdrawal procedure 
 * 
 * 
 * */

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `makeWithdrawal`(IN `account_ID_arg` INT(9), IN `amount_arg` DECIMAL(12,2), IN `date_of_withdrawl_arg` DATE)
    MODIFIES SQL DATA
BEGIN
 DECLARE balance_arg decimal(12,2);
 DECLARE withdrawl_ID_arg int(9);

/* BEGIN TRAN */

 START TRANSACTION; 
/* get the current balance from the account to balance_arg variable */
 SELECT balance INTO balance_arg from account where account_ID = account_ID_arg;
 
 /* update the value */
 SELECT balance_arg - amount_arg into balance_arg ;
 

 /* proceed only if value can be redeemed*/
 IF balance_arg >=0 THEN
 
 /* update the table to new value */
 UPDATE account set balance = balance_arg where account_ID = account_ID_arg;
 
 /* insert the data to withdrawal table */
 INSERT into withdrawls(date_of_withdrawl,amount) values(date_of_withdrawl_arg, amount_arg);
 
 /* get the primary key from withdrawal table to withdrawl_ID_arg*/
 SET withdrawl_ID_arg = LAST_INSERT_ID();
 
 /* insert account_Id and withdrawl_ID_arg to the make withdrawal table */
 INSERT into makes_withdrawl values(account_ID_arg, withdrawl_ID_arg);
 COMMIT;

END IF;
END$$
DELIMITER ;





/*
 *  
 * Add user function
 * 
 * 
 * */

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUser`(Email varchar(100), date_of_birth date,first_name varchar(30),last_name varchar(30))
    MODIFIES SQL DATA
BEGIN



 START TRANSACTION; 
 	Insert into users(Email,date_of_birth,first_name,last_name) values (Email,date_of_birth,first_name,last_name);
 COMMIT;


END$$
DELIMITER ;



/*
 *  
 * Add account function
 * It simultaneously add account
 * update deposits table
 * update own by table
 * update makes_deposits table
 * 
 * */

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addAccount`(IN `user_ID_arg` INT(9), IN `account_type` INT(2), IN `initial_deposit` DECIMAL(12,2), IN `date_created` DATE)
    MODIFIES SQL DATA
BEGIN
 DECLARE deposit_ID_arg int(9);
 DECLARE account_ID_arg int(9);	
    
/* BEGIN TRAN */

 START TRANSACTION; 
	
    
insert into account(acc_type_ID,balance) values (account_type,initial_deposit);
SET account_ID_arg = LAST_INSERT_ID();
    
 /* insert the data to deposits table */
 INSERT into deposits(date_of_deposit,amount) values(date_created, initial_deposit);
 
 /* get the primary key from deposits table to deposit_ID_arg*/
 SET deposit_ID_arg = LAST_INSERT_ID();
 
 /* insert account_Id and deposit_ID_arg to the make deposits table */
 INSERT into makes_deposit values(account_ID_arg, deposit_ID_arg);
 
 /* update own by table */
 INSERT INTO own_by VALUES (account_ID_arg,user_ID_arg);

 COMMIT;

END$$
DELIMITER ;



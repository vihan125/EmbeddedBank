/*
 *  
 * Make withdrawal for mobile account procedure 
 * 
 * 
 * */
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `makeMobileWithdrawal`(IN `account_ID_arg` INT(9), IN `amount_arg` DECIMAL(12,2), IN `date_of_withdrawl_arg` DATE, in `agent_ID_arg` int(9), IN `MU_ID_arg` INT(9))
    MODIFIES SQL DATA
BEGIN
 DECLARE balance_arg decimal(12,2);
 DECLARE withdrawl_ID_arg int(9);
 DECLARE balance_of_device_arg decimal(12,2);
/* BEGIN TRAN */

 START TRANSACTION; 
/* get the current balance from the account to balance_arg variable */
 SELECT balance INTO balance_arg from account where account_ID = account_ID_arg;
 
 /* update the value */
 SELECT balance_arg - amount_arg into balance_arg ;
 
 /* update the table to new value */
 UPDATE account set balance = balance_arg where account_ID = account_ID_arg;
 
 /* insert the data to deposits table */
 INSERT into mobilet(date_of_mobileT,amount,agent_ID,dep_with) values(date_of_withdrawl_arg, amount_arg,agent_ID_arg, "W");
 
 /* get the primary key from deposits table to deposit_ID_arg*/
 SET withdrawl_ID_arg = LAST_INSERT_ID();
 
 /* insert account_Id and deposit_ID_arg to the make deposits table */
 INSERT into makes_mobilet values(account_ID_arg, withdrawl_ID_arg);
 
 
 /* get the current balance from the mobile unit to balance_arg variable */
 SELECT balance INTO balance_arg from mobile_unit where MU_ID = MU_ID_arg;
 
 /* update the value */
 SELECT balance_arg - amount_arg into balance_arg ;
 
 /* update the table to new value */
 UPDATE mobile_unit set balance = balance_arg where MU_ID = MU_ID_arg;
 
 COMMIT;


END$$
DELIMITER ;





/*
 *  
 * Make deposits for mobile account procedure 
 * 
 * 
 * */

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `makeMobileDeposit`(IN `account_ID_arg` INT(9), IN `amount_arg` DECIMAL(12,2), IN `date_of_deposit_arg` DATE, IN `agent_ID_arg` INT(9), IN `MU_ID_arg` INT(9))
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
 INSERT into mobilet(date_of_mobileT,amount,agent_ID,dep_with) values(date_of_deposit_arg, amount_arg,agent_ID_arg, "D");
 
 /* get the primary key from deposits table to deposit_ID_arg*/
 SET deposit_ID_arg = LAST_INSERT_ID();
 
 /* insert account_Id and deposit_ID_arg to the make deposits table */
 INSERT into makes_mobilet values(account_ID_arg, deposit_ID_arg);
 
 
 /* get the current balance from the mobile unit to balance_arg variable */
 SELECT balance INTO balance_arg from mobile_unit where MU_ID = MU_ID_arg;
 
 /* update the value */
 SELECT balance_arg + amount_arg into balance_arg ;
 
 /* update the table to new value */
 UPDATE mobile_unit set balance = balance_arg where MU_ID = MU_ID_arg;
 
 
 
 COMMIT;

END$$
DELIMITER ;



/* 
 * add new mobile Account 
 * 
 * This function is created to retrieve data using Mobile banking account id and password 
 * 
 */

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addMA`(`customer_ID_arg` INT(9), MU_ID_arg int(9),`password_arg` VARCHAR(40))
BEGIN

	INSERT INTO mobile_banking_account VALUES (customer_ID_arg,MU_ID_arg,password_arg);
 
END$$
DELIMITER ;



/* 
 * get Mobile Account function
 * 
 * This function is created to retrieve data using Mobile banking account id and password 
 * 
 */
DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getMA`(`customer_ID_arg` INT(9), `password_arg` VARCHAR(40)) RETURNS int(9)
BEGIN
 DECLARE customerID int(9);
  Select customer_ID from mobile_banking_account where customer_ID=customer_ID_arg and password= password_arg into customerID;
  RETURN customerID;
END$$
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
	
 /* insert the data to account table */   
 insert into account(acc_type_ID,balance) values (account_type,initial_deposit);
 
 /* get the account_ID. we have to use this method since the ID is auto generated*/
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



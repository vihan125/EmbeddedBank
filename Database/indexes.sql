/*
 *   Account table is indexed using two columns
 *   1. account_ID
 * 	 2. acc_type_ID
 * 
 * */
CREATE INDEX account_index ON account(account_ID,acc_type_ID);


/*
 *   Makes_deposit table is indexed using two columns
 *   1. account_ID
 * 	 2. deposit_ID
 * 
 * */
CREATE INDEX deposit_index ON makes_deposit(account_ID,deposit_ID);


/*
 *   Makes_withdrawal table is indexed using two columns
 *   1. account_ID
 * 	 2. withdrawl_ID
 * 
 * */
CREATE INDEX withdrawl_index ON makes_withdrawl(account_ID,withdrawl_ID);


/*
 *   Makes_mobilet table is indexed using two columns
 *   1. account_ID
 * 	 2. mobileT_ID
 * 
 * */
CREATE INDEX mobilet_index ON makes_mobilet(account_ID,mobileT_ID);
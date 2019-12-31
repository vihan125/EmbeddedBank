CALL addUser('vihan97@gmail.com','1997-12-05','vihan','melaka');
CALL addUser('tharaka.17@cse.mrt.ac.lk','2001-10-28','tharaka','rathnayeka');
CALL addUser('sumanapala@gmail.com','1965-04-18','sumanapala','carolis');
CALL addUser('krishi@yahoo.com','1997-06-17','krishi','kanna');
CALL addUser('ranuli@gmail.com','2010-08-05','ranuli','pehara');

insert into contact_no values (1,'0775688616');
insert into contact_no values (1,'0716411123');
insert into contact_no values (3,'0776789123');
insert into contact_no values (5,'0778897862');
insert into contact_no values (5,'0112897826');
insert into contact_no values (4,'0718267703');
insert into contact_no values (1,'0775789245');

insert into fd_type(interest_rate,name) values ('3','6 months');
insert into fd_type(interest_rate,name) values ('2','1 year');
insert into fd_type(interest_rate,name) values ('1','5 year');

insert into account_type(interest_rate,minimum_balance,name) values ('12','0.0','children');
insert into account_type(interest_rate,minimum_balance,name) values ('11','500.00','teen');
insert into account_type(interest_rate,minimum_balance,name) values ('10','1000.00','adult');
insert into account_type(interest_rate,minimum_balance,name) values ('13','1000.00','senior');
insert into account_type(interest_rate,minimum_balance,name) values ('7','5000.00','joint');

CALL addAccount('1','2','120000', current_date);
CALL addAccount('2','1','120000.00', current_date);
CALL addAccount('3','3','3950.50', current_date);
CALL addAccount('4','4','60450.00', current_date);
CALL addAccount('5','5','6100.00', current_date);

/*
 * call makeDeposit(account_ID_arg,amount_arg,date_of_deposit_arg);
 * 
 */

call makeDeposit(1,'2000','2019-03-21');
call makeDeposit(2,'3000','2019-07-21');
call makeDeposit(3,'4000','2019-04-21');
call makeDeposit(4,'5000','2019-06-21');
call makeDeposit(5,'6000','2019-08-21');

/*
 * call makeDeposit(account_ID_arg,amount_arg,date_of_withdrawal_arg);
 * 
 */
call makeWithdrawal(1,'6000','2019-08-21');
call makeWithdrawal(2,'6000','2019-08-21');
call makeWithdrawal(3,'6000','2019-08-21');
call makeWithdrawal(4,'6000','2019-08-21');
call makeWithdrawal(5,'6000','2019-08-21');


insert into mobile_unit(agent_ID,balance) values ('123','50000');
insert into mobile_unit(agent_ID,balance) values ('678','60000');
insert into mobile_unit(agent_ID,balance) values ('456','80000');

/*
insert into mobileT(date_of_mobileT,amount,agent_ID) values ('2018-02-04','17000.00','123');
insert into mobileT(date_of_mobileT,amount,agent_ID) values ('2019-12-31','200.00','678');


insert into makes_mobileT values (1,'1');
insert into makes_mobileT values (2,'2');
*/

call makeMobileWithdrawal(1, 200, CURRENT_DATE, 123, 1);
call makeMobileDeposit(1, 300, CURRENT_DATE, 123, 1);

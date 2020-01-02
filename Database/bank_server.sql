
-- to view account details
select * from users natural join own_by natural join account;


-- to view transactions of a users
select deposit_ID,date_of_deposit,amount,balance 
from account natural join makes_deposit natural join deposits where account_ID=1;


-- Make deposits through bank 
call makeDeposit(?,?,?);

-- Make withdrawals through bank
call makeWithdrawal(?,?,?);

-- Make Fixed deposits


-- Add User through ui
CALL addUser('ranuli@gmail.com','2010-08-05','ranuli','pehara');


-- Add account through ui
CALL addAccount('1','2','120000', current_date);



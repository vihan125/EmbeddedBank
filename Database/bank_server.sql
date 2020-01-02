
-- to view account details
select * from users natural join own_by natural join account;


-- to view transactions of a users
select deposit_ID,date_of_deposit,amount,balance 
from account natural join makes_deposit natural join deposits where account_ID=1;


-- Make deposits through bank 


-- Make withdrawals through bank


-- Make Fixed deposits





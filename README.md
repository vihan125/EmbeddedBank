# EmbeddedBank

The mobile devices contains only lightweight databases and can only handle deposit and
withdraw functionalities. To make the transactions efficient and less costly, mobile device
update the central server only after a particular number of transactions, as a batch processing
or after a certain time period depending on which comes first. An account holder is only allowed
to withdraw money from one mobile banking agent to avoid withdrawing money more than he
actually has deposited. However any account holder can make a special request and get the
facility to withdraw money from any mobile agent with a additional service cost per each
transaction. These type of withdrawal transactions are called critical transactions and they
immediately update the central server. These mobile agents provide service to joint account
holders as well and those accounts are given the multiple agent withdrawal facility by default.
All the interest calculating process are handled only by the central server. Interest rates and
minimum required balance for Savings account vary on the plan. 

Plans are briefly listed below,
<br>
<li>Children</li>
<li>Teen</li>
<li>Adult</li>
<li>Senior</li>
<li>Joint</li>
<br>
Apart from these, customer could start a Fixed Deposit (FD) with the bank by going to their
main station. For a FB to function, a customer must have a Savings account. The FD plans
are as follows,
<br>
<li>6 months</li>
<li>1 year</li>
<li>3 years</li>
<br>

# ERD Diagram Central Database
<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/central%20database.png width="90%" height="90%" align="middle">


# ERD Diagram Embedded Database

<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20database.png width="90%" height="90%" align="middle">


# Mobile login
Successful login
Required parameters 
<li>MBA_ID</li>
<li>password</li>



![](https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20auth%20successful.PNG)

<br>
unsuccessful login will return following


![](https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20auth%20unsuccessful.PNG)

# Mobile deposit

<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20deposit.PNG width="90%" height="90%" align="middle">


# Mobile withdrawal


<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20withdrawal.PNG width="90%" height="90%" align="middle">


# ADD new user to the system


<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/add%20new%20user.PNG width="90%" height="90%" align="middle">

# ADD new account to a user


<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/add%20new%20account%20to%20user.PNG width="90%" height="90%" align="middle">


# Withdrawal through web UI

<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/UI%20withdrawal.PNG width="90%" height="90%" align="middle">

# Deposit through web UI

<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/UI%20deposit.PNG width="90%" height="90%" align="middle">

# Deposit through web UI

<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/UI%20deposit.PNG width="90%" height="90%" align="middle">

# Add a fixed deposit through web UI

<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/UI%20add%20new%20fixed%20deposit.PNG width="90%" height="90%" align="middle">

# View Customer info through web UI

<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/customer%20info%20view.PNG width="90%" height="90%" align="middle">

# View Customer info through web UI

<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/customer%20info%20view.PNG width="90%" height="90%" align="middle">

# Get latest balance of an account

<img src=https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20refresh%20balance.PNG width="90%" height="90%" align="middle">



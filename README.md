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
![](https://github.com/tharaka27/EmbeddedBank/blob/master/images/central%20database.png)

# ERD Diagram Embedded Database
![](https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20database.png)


# Mobile login
Successful login
Required parameters 
<li>MBA_ID</li>
<li>password</li>

```
POST /auth HTTP/1.1
Host: localhost:6973
MBA_ID: 2
password: Tharaka
Cache-Control: no-cache
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
```


![](https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20auth%20successful.PNG)

<br>
unsuccessful login will return following
![](https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20auth%20unsuccessful.PNG)

# Mobile deposit
```
POST /mDeposit HTTP/1.1
Host: localhost:6973
agent_ID: 123
privatekey: "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUaGFyYWthIiwiZXhwIjoxNTc3ODUzODAzfQ.-ld0neya6a1rNzVOtMLQcVImy2kbbrhUPJ67EU8K3Ms"
amount: 3000
account_ID: 1
MU_ID: 1
Cache-Control: no-cache
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
```
![](https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20deposit.PNG)

# Mobile withdrawal

```
POST /mWithdrawal HTTP/1.1
Host: localhost:6973
agent_ID: 123
privatekey: "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUaGFyYWthIiwiZXhwIjoxNTc3ODUzODAzfQ.-ld0neya6a1rNzVOtMLQcVImy2kbbrhUPJ67EU8K3Ms"
amount: 3000
account_ID: 1
MU_ID: 1
Cache-Control: no-cache
Postman-Token: 2df7bc2c-ba92-64cb-4610-6d9e971ec7b2
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
```

![](https://github.com/tharaka27/EmbeddedBank/blob/master/images/mobile%20withdrawal.PNG)

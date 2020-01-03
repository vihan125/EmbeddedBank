# MICRO BANK APP

## Project description

This is a mobile interface developed using flutter and also an embedded database developed using dart and sqlite libraries. 
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

## Implementation
This embedded device has a embedded database created using sqlite and the ER diagram is given below.
<p align="center">
  <image src = https://github.com/vihan125/Micro-bank-App-/blob/master/images/ER.jpeg width="90%" height="90%">
</p>
  
  Other than these three tables there is a table called balance to maintain balance that agents have with the device.
  All the transactions are recordded in the transactions table and the makes table is used to map each transaction with the customer.
  Each cutomer has their own device assigned to them and details about customers are embedded in the device database and each device has a unique ID as well.
  
  
  When five transactions are recorded in the database app will push that details to the central database and the makes table and transaction tables will be cleared. Else if five transactions do not happen with in 2 minutes it will push the available details in the database and tables will be cleared.(you can change this time by changing the value in the timer function in main.dart file)So there will be no extra use of memory and the system will function efficiently.
  
  communication with the main server was done using REST API and full project is available in Embedded bank repository.
  
  


## App interfaces
### Home interface
First interface that will be displayed to the user. There are two types of users as customer and agent. Agent is the owner of the embedded device and user is the bank customer. User can login to their account using  customer login and if agent wants to do changes in the balance of the account they can use the agent updates option.
<p align="center">
  <image src = https://github.com/vihan125/Micro-bank-App-/blob/master/images/Screenshot_1577949022.png width="30%" height="30%">
</p>

### User login interface
This is the interface that customers use to login to their accounts. If the user the username or password is incorrect it will generate a error message.
<p align="center">
  <image src = https://github.com/vihan125/Micro-bank-App-/blob/master/images/Screenshot_1577949030.png width="30%" height="30%">
</p>

### Options interface
After loging into their accounts customers have two options as deposit money or to withdraw money. the balance of their account will be shown at the bottom this balance is taken from the main server.
<p align="center">
  <image src = https://github.com/vihan125/Micro-bank-App-/blob/master/images/Screenshot_1577949044.png width="30%" height="30%">
</p>
  
  ### User deposits interface
  This interface is used to do deposit transactions. After a transaction is made that details will be saved in the transactions table and the makes table.
<p align="center">
  <image src = https://github.com/vihan125/Micro-bank-App-/blob/master/images/Screenshot_1577949050.png width="30%" height="30%">
</p>
  
### User withdrawl interface
This interface is used to do withdrawl transactions. After a transaction is made that details will be saved in the transactions table and the makes table.
<p align="center">
  <image src = https://github.com/vihan125/Micro-bank-App-/blob/master/images/Screenshot_1577949055.png width="30%" height="30%">
</p>
  
### Agent login interface
This is the interface used by the agent to login to their account to do updates in the device.
<p align="center">
  <image src = https://github.com/vihan125/Micro-bank-App-/blob/master/images/Screenshot_1577949063.png width="30%" height="30%">
</p>
  
### Agent update interface
This interface is used to do updates in the device and the balance table will get update according to the value entered. this is the available balance in the device. customers cannot withdraw more than this balance.
<p align="center">
  <image src = https://github.com/vihan125/Micro-bank-App-/blob/master/images/Screenshot_1577949082.png width="30%" height="30%">
</p>
  
### Transaction successful interface
This indicates that a transaction has successfully completed.
<p align="center">
  <image src = https://github.com/vihan125/Micro-bank-App-/blob/master/images/Screenshot_1577948982.png width="30%" height="30%">
</p>



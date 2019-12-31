create table users(
	customer_ID int(9) auto_increment,
    Email varchar(100),
    date_of_birth date NOT NULL,
    first_name varchar(30) NOT NULL,
    last_name varchar(30) NOT NULL,
    PRIMARY KEY(customer_ID)
);

create table mobile_unit(
	MU_ID int(9) auto_increment,
    agent_ID int(9) NOT NULL,
    balance numeric(12,2),
    PRIMARY KEY(MU_ID)
);

create table FD_type(
	FD_type_ID int(2) auto_increment,
    interest_rate numeric(5,2) NOT NULL,
    name varchar(20),
    PRIMARY KEY(FD_type_ID)
);

create table account_type(
	acc_type_ID int(2) auto_increment,
    interest_rate numeric(5,2) NOT NULL,
    minimum_balance numeric(6,2) NOT NULL,
    name varchar(20),
    PRIMARY KEY(acc_type_ID)
);

create table deposits(
	deposit_ID int(9) auto_increment,
    date_of_deposit date NOT NULL,
    amount numeric(12,2) NOT NULL,
    PRIMARY KEY(deposit_ID)
);

create table withdrawls(
	withdrawl_ID int(9) auto_increment,
    date_of_withdrawl date NOT NULL,
    amount numeric(12,2) NOT NULL,
    PRIMARY KEY(withdrawl_ID)
);

create table mobileT(
	mobileT_ID int(9) auto_increment,
    date_of_mobileT date NOT NULL,
    amount numeric(12,2) NOT NULL,
    agent_ID int(9) NOT NULL,
    dep_with char(1) NOT NULL, -- deposit or withdrawl
    PRIMARY KEY(mobileT_ID)
);




create table account(
	account_ID int(9) auto_increment,
    acc_type_ID int(2),
    balance numeric(12,2),
    PRIMARY KEY(account_ID),
    FOREIGN KEY (acc_type_ID) REFERENCES account_type(acc_type_ID) ON DELETE CASCADE
);

create table own_by(
	account_ID int(9) ,
    customer_ID int(9) ,
    PRIMARY KEY(account_ID,customer_ID),
    FOREIGN KEY(account_ID) REFERENCES account(account_ID) ON DELETE CASCADE,
    FOREIGN KEY(customer_ID) REFERENCES users(customer_ID) ON DELETE CASCADE
);

create table mobile_banking_account(
	MBA_ID int(9) auto_increment,
    customer_ID int(9),
    MU_ID int(9),
    password varchar(40) NOT NULL ,
    PRIMARY KEY(MBA_ID),
    FOREIGN KEY(MU_ID) REFERENCES mobile_unit(MU_ID) ON DELETE CASCADE,
    FOREIGN KEY(customer_ID) REFERENCES users(customer_ID) ON DELETE CASCADE
);

create table fixed_deposit(
	FD_ID int(9) auto_increment,
    account_ID int(9),
    FD_type_ID int(2),
    PRIMARY KEY(FD_ID),
    FOREIGN KEY(account_ID) REFERENCES account(account_ID) ON DELETE CASCADE,
    FOREIGN KEY(FD_type_ID) REFERENCES FD_type(FD_type_ID) ON DELETE CASCADE
);

create table makes_deposit(
	account_ID int(9),
    deposit_ID int(9),
    PRIMARY KEY(account_ID,deposit_ID),
    FOREIGN KEY(account_ID) REFERENCES account(account_ID) ON DELETE CASCADE,
    FOREIGN KEY(deposit_ID) REFERENCES deposits(deposit_ID) ON DELETE CASCADE
);

create table makes_withdrawl(
	account_ID int(9),
    withdrawl_ID int(9),
    PRIMARY KEY(account_ID,withdrawl_ID),
    FOREIGN KEY(account_ID) REFERENCES account(account_ID) ON DELETE CASCADE,
    FOREIGN KEY(withdrawl_ID) REFERENCES withdrawls(withdrawl_ID) ON DELETE CASCADE
);

create table makes_mobileT(
	account_ID int(9),
    mobileT_ID int(9),
    PRIMARY KEY(account_ID,mobileT_ID),
    FOREIGN KEY(account_ID) REFERENCES account(account_ID) ON DELETE CASCADE,
    FOREIGN KEY(mobileT_ID) REFERENCES mobileT(mobileT_ID) ON DELETE CASCADE
);

create table contact_no(
	customer_ID int(9),
    mobile_no int(10) NOT NULL,
    PRIMARY KEY(customer_ID,mobile_no),
    FOREIGN KEY(customer_ID) REFERENCES users(customer_ID) ON DELETE CASCADE
);


CREATE TABLE bank_account(
	bank_account_id SERIAL NOT NULL PRIMARY KEY,
	amount NUMERIC, 
	blocked BOOLEAN
);

CREATE TABLE account_role(
	role_id SERIAL NOT NULL PRIMARY KEY,
	role_name VARCHAR(200)
);


CREATE TABLE card_user(
	card_user_id SERIAL NOT NULL PRIMARY KEY,
	user_name VARCHAR(200), 
	user_login VARCHAR(200),
	card_user_password VARCHAR(200),
	account_role_id SERIAL REFERENCES account_role(role_id)
);

CREATE TABLE card(
	card_id SERIAL NOT NULL PRIMARY KEY,
	card_number VARCHAR(16),
	cvv VARCHAR(3), 
	expires DATE,
	bank_account_id SERIAL REFERENCES bank_account(bank_account_id),
	pin VARCHAR(4),
	owner_id SERIAL REFERENCES card_user(card_user_id)
);


CREATE TABLE card_transaction(
	transaction_id SERIAL NOT NULL PRIMARY KEY,
	transaction_date TIMESTAMP NOT NULL,
	sum NUMERIC NOT NULL, 
	card_id SERIAL REFERENCES card(card_id)
)	

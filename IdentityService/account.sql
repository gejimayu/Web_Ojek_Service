DROP TABLE IF EXISTS userdata;
DROP TABLE IF EXISTS accesstoken;

CREATE TABLE userdata (
	id_user int NOT NULL AUTO_INCREMENT,
	name varchar(50),
	username varchar(20),
	email varchar(100),
	password varchar(50),
	phone_number varchar(20),
	driver_status varchar(10),
	PRIMARY KEY (id_user)
);

INSERT INTO userdata(name, username, email, password, phone_number, driver_status) 
VALUES 	("Pika1", "pikapika",  "cobacoba@gmail.com", "asdbc", "085723289999", "true"),
		("Pika2", "pikapika2",  "cobacoba@gmail.com", "asdbc", "085723289999", "true"),
		("Pika3", "pikapika3", "cobacoba3@gmail.com", "asdbc", "085723289999", "true"),
		("Pika4", "pikapika4", "cobacoba4@gmail.com", "asdbc", "08239293929", "true"),
		("Pika5", "pikapika5", "cobacoba5@gmail.com", "asdbc", "08239293929", "true"),
		("Pika6", "pikapika6",  "cobacoba6@gmail.com", "asdbc", "08239293929", "true"),
		("Pika7", "pikapika7", "cobacoba@gmail.com", "asdbc", "085723289999", "false"),
		("Pika8", "pikapika8", "cobacoba3@gmail.com", "asdbc", "085723289999", "false"),
		("kuningan", "pika", "tes@asd.ib", "asdbc", "123412341234", "true"),
		("asem", "pikalol", "asd@gmx.s", "asdbc", "12341234", "true");

CREATE TABLE accesstoken (
	id_user int NOT NULL,
	token varchar(100),
	expiretime DATE
);

INSERT INTO accesstoken
VALUES  (1, "9be9a0968eb941e391f505523d8a8a49", '2017-10-07 23:52:10'),
		(2, "23c41f6f92d642e490eaf5e5797e57bb", '2017-10-07 22:51:55');

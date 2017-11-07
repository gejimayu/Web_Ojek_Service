DROP TABLE IF EXISTS userdata;
DROP TABLE IF EXISTS accesstoken;

CREATE TABLE userdata (
	id_user int NOT NULL AUTO_INCREMENT,
	username varchar(20),
	password varchar(50),
	PRIMARY KEY (id_user)
);

INSERT INTO userdata(username, password)
VALUES 	("pikapika", "asdbc"),
		("pikapika2", "asdbc"),
		("pikapika3","asdbc"),
		("pikapika4","asdbc"),
		("pikapika5","asdbc"),
		("pikapika6", "asdbc"),
		("pikapika7","asdbc"),
		("pikapika8","asdbc"),
		("pika", "asdbc"),
		("pikalol", "asdbc");

CREATE TABLE accesstoken (
	id_user int NOT NULL,
	token varchar(100),
	expiretime DATE
);

INSERT INTO accesstoken
VALUES  (1, "9be9a0968eb941e391f505523d8a8a49", '2017-10-07 23:52:10'),
		(2, "23c41f6f92d642e490eaf5e5797e57bb", '2017-10-07 22:51:55');

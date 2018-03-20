DROP DATABASE contraderOBD;

CREATE DATABASE contraderOBD;

create table contraderOBD.users(
username varchar(50)  NOT NULL,
password varchar(50),
firstname varchar(50),
lastname varchar(50),
role varchar(50)
);

insert into contraderOBD.users (username, password, firstname, lastname, role)
value("admin","admin","mario","saponara","admin");

insert into contraderOBD.users (username, password, firstname, lastname, role)
value("user","user","luca","rossi","user");
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Lewis
 * Created: 19/04/2021
 */
create table users (
"userid" int not null primary key,
"email" varchar(30),
"password" varchar(30)
);


create table customers(
"customerid" int not null primary key,
"userid" int,
"firstname" varchar(30),
"Lastname" varchar(30),
"othernames" varchar(30),
"address" varchar(50),
"phone" int,
"payment" int
);

create table staff(
"staffid" int not null primary key,
"userid" int,
"firstname" varchar(30),
"lastname" varchar(30),
"othernames"  varchar(30),
"role" varchar(30),
"email" varchar(30)
);
insert into users ("userid", "email", "password")
values(0, 'sysadmin@iotbay.com', 'asdf');

insert into staff("staffid", "userid", "firstname", "lastname", "othernames", "role", "email")
values(0, 0, 'sysadmin','', '','sysadmin','sysadmin@iotbay.com');
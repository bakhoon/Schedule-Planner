# Schedule-Planner

This project is created wiht NetBeans IDE 8.2.

In order to activate Database, you must create tables through query. 

create table Plan(
pid int primary key generated always as identity,
ptitle varchar(100),
pdate varchar(20),
pdescription varchar(1000),
pdue varchar(20),
pcategory varchar(20),
plocation varchar(50),
pmandatory integer,
pcomplete boolean);

create table course(
cabbr varchar(10) not null primary key,
cname varchar(50),
croom varchar(50),
prof varchar(50),
poffice varchar(50),
phour varchar(50),
cdays varchar(10),
ctime1 varchar(12),
ctime2 varchar(12),
clevel integer,
csem integer);

Create table note(
nid int primary key generated always as identity,
ntitle varchar(400),
note varchar(10000),
ncreated varchar(50),
nmodified varchar(50));



DROP DATABASE IF EXISTS student_management_ex;
create database if not exists student_management_ex;
use student_management_ex;

create table student ( id int primary key auto_increment,
`name` varchar(50) not null,
age int null,
country varchar(50));

create table class (id int primary key auto_increment,
`name` varchar(50));

create table teacher (id int primary key auto_increment,
`name` varchar(50) not null,
age int null,
country varchar(50));

insert into student (name,age,country) value("Sang",27,"Đà Nẵng");

insert into student (name,country) value("Bảo","Đà Nẵng");

insert into student (name,age) value("Huy",26);

insert into class (name) value("C0722G1"),("C0822G1"),("C0922G1");

insert into teacher (name,age,country) value("Công Nguyễn",31,"Đà Nẵng");

insert into teacher (name,age) value("Chánh Trần",38);

insert into teacher (name,country) value("Quang Nguyễn","Đà Nẵng");


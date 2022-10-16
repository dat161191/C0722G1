create database if not exists student_management;
use student_management;

create table student ( id int primary key auto_increment,
`name` varchar(50) not null,
age int null,
country varchar(50));

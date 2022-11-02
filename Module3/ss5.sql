DROP DATABASE IF EXISTS c0722g1;
create database if not exists c0722g1;
use c0722g1;
CREATE TABLE class (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20)
);
CREATE TABLE room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20),
    class_id INT,
    FOREIGN KEY (class_id)
        REFERENCES class (id)
);
CREATE TABLE jame (
    username VARCHAR(50) PRIMARY KEY,
    `password` VARCHAR(50)
);
CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    birthday DATE,
    gender BOOLEAN,
    email VARCHAR(50),
    point FLOAT,
    username VARCHAR(50) UNIQUE,
    class_id INT,
    FOREIGN KEY (username)
        REFERENCES jame (username),
    FOREIGN KEY (class_id)
        REFERENCES class (id)
);
CREATE TABLE instructor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    birthday DATE,
    salary FLOAT
);
CREATE TABLE instructor_class (
    instructor_id INT,
    class_id INT,
    PRIMARY KEY (instructor_id , class_id),
    FOREIGN KEY (instructor_id)
        REFERENCES instructor (id),
    FOREIGN KEY (class_id)
        REFERENCES class (id),
    start_time DATE,
    end_time DATE
);

insert into class (name) values ('c1121g1'), ('c1221g1'),('a0821i1'),('a0921i1');
insert into room(name,class_id) values ('Ken',1), ('Jame',1),('Ada',2),('Andy',2);

insert into jame(`username`,`password`)
 values('cunn','12345'),('chunglh','12345'),('hoanhh','12345'),('dungd','12345'),('huynhtd','12345'),
 ('hainm','12345'),('namtv','12345'),('hieuvm','12345'),('kynx','12345'),('vulm','12345');

insert into jame(`username`,`password`)
 values('chau','12345');
 
insert into instructor(`name`,birthday, salary)
 values('tran van chanh','1985-02-03',100),('tran minh chien','1985-02-03',200),('vu thanh tien','1985-02-03',300);
insert into instructor(`name`,birthday, salary)
 values('tran van nam','1989-12-12',100);
 
 insert into student(`name`,birthday, gender,`point`, class_id,`username`) 
 values ('nguyen ngoc cu','1981-12-12',1,8,1,'cunn'),('le hai chung','1981-12-12',1,5,1,'chunglh'),
 ('hoang huu hoan','1990-12-12',1,6,2,'hoanhh'),('dau dung','1987-12-12',1,8,1,'dungd'),
 ('ta dinh huynh','1981-12-12',1,7,2,'huynhtd'),('nguyen minh hai','1987-12-12',1,9,1,'hainm'),
 ('tran van nam','1989-12-12',1,4,2,'namtv'),('vo minh hieu','1981-12-12',1,3,1,'hieuvm'),
 ('le xuan ky','1981-12-12',1,7,2,'kynx'),('le minh vu','1981-12-12',1,7,1,'vulm');
 
  insert into student(`name`,birthday, gender,`point`, class_id,`username`) 
 values ('nguyen minh hai chau','1981-12-12',1,8,null,'chau');
 
 insert into instructor_class(class_id,instructor_id) values (1,1),(1,2),(2,1),(2,2),(3,1),(3,2);

SELECT 
    *
FROM
    room;
SELECT 
    *
FROM
    class;
SELECT 
    *
FROM
    student;
SELECT 
    *
FROM
    jame;
DELETE FROM student;
SELECT 
    *
FROM
    instructor;
SELECT 
    *
FROM
    instructor_class;


SELECT 
    s.*, c.name AS class_name
FROM
    student s
        JOIN
    class c ON s.class_id = c.id;
    
#thông tin các học viên, và cho biết các học viên đang theo học lớp nào 
-- và cả các bạn đã đăng ký nhưng chưa có lớp học.

 select s.* ,c.name  as class_name
  from student s left join class c on s.class_id=c.id; 

-- join 3 bảng lấy thêm thông tin tên loại lớp

select * from room;
select s.id, s.name, s.birthday, c.name as class_name, r.name as room_name
from student s
left join class c on s.class_id = c.id
left join room r on r.class_id=c.id;

-- 3. Lấy thông tin của các học viên tên 'nguyen minh hai'.
select * from student where name like '% hai';
select * from student where name = 'nguyen minh hai';

-- 4. Lấy ra học viên có họ là “nguyen”
select * from student where name like 'nguyen %';

-- 5. Lấy thông tin của các học viên tên 'hai' hoặc 'huynh’.

select * from student where name like '% hai' or name like '% huynh';

-- 6. Lấy ra các học viên có điểm lớn hơn 5 .
select * from student where point >5;

-- 7. lấy ra thông tin các học viên có điểm 4,6,8

select * from student where point = 4 or point = 6 or point =8;
select * from student where point in (4,6,8);
-- RegexP : tìm hiểu thêm

-- 8. Thông kế số lượng học sinh theo từng loại điểm.
 select s.point, count(s.point) as so_luong 
 from student s 
 group by s.point;
 
  select * from student;
-- 9 . Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 5

 select s.point, count(s.point) as so_luong 
 from student s 
 where s.point>5
 group by s.point;

-- 10. Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2
 select s.point, count(s.point) as so_luong 
 from student s 
 where s.point>5
 group by s.point
 having so_luong>2;
-- 11. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp  học viên theo point giảm dần,
-- nếu point bằng nhau thì sắp xếp theo tên tăng dần.

select s.name, s.point, c.name as class_name 
from student s
join class c on s.class_id=c.id 
where c.name ='c1121g1'
order by s. point desc, s.name desc ;


#=============================== bài 4: sử dụng các hàm thông dụng====================================
select* from class;
select* from student;
-- 1.1	Hiện thị danh sách các lớp có học viên theo học và số lượng học viên của mỗi lớp
select c.name as class_name, count(s.class_id) as so_luong from
student s join
class c on s.class_id= c.id
group by c.name;


-- 1.2.	 Tính điểm lớn nhất của mỗi các lớp
select c.name as class_name, max(s.point) as diem_lon_nhat from
student s join
class c on s.class_id= c.id
group by c.name;

-- 1.3	 Tình điểm trung bình  của từng lớp
select c.name as class_name, avg(s.point) as diem_tb from
student s join
class c on s.class_id= c.id
group by c.name;

select * from
class c join room r on r.class_id=c.id
group by c.name;

 -- 2 Lấy ra toàn bộ tên và ngày sinh các instructor và student ở CodeGym.
select s.name, s.birthday 
from student s
union
select i.name, i.birthday
from instructor i;

select * from
student s left join
class c on s.class_id= c.id
union 
select * from
student s  right join
class c on s.class_id= c.id;

-- 4 Lấy ra top 3 học viên có điểm cao nhất của trung tâm.

SELECT 
    *
FROM
    student
ORDER BY `point` DESC , name
LIMIT 0 , 3;
select * from student
where point =(select max(point) from student);

select * from student
group by name
having point = max(student.point);

-- sử dụng group_concate lấy thông tin lớp học có những phòng học nào (cần sử dụng câu truy vấn con)
-- fix bug ý tưởng hồi sáng
select temp.class_name, group_concat(temp.room_name)  from
(select  c.name as class_name, r.name  as room_name from
class c join room r on r.class_id=c.id
group by r.name) as temp
group by temp.class_name;

#======================================= ss5: index, view, sp, function, trigger==========================================
#================== 1. index===================
select * from student where gender like 1;
explain select * from student where gender like 1;
select count(*) from student where gender like 1;
select * from student;
select count(*) from student;
explain select * from student;
-- cách 1
create index i_gender on student(gender);
drop index i_gender on student;
-- cách 2
alter table student add index i_gender(gender);
alter table student drop index i_gender;


 -- 2.view (tạo view lấy thông tin của học viên)
 create view w_student as
select s.id, s.name as student_name, c.name as class_name
from student s join class c on s.class_id = c.id;
 -- sử dụng view
select* from w_student;

-- 3.1  tạo một SP không tham số  để lấy danh sách student
delimiter //
CREATE PROCEDURE sp_get_all_student()
begin
select s.id, s.name as student_name, c.name as class_name
from student s join class c on s.class_id = c.id;
end //
delimiter ;
-- goi sp
call sp_get_all_student();
-- 3.2 sp có tham số in để lấy ra học viên có tham số id
delimiter //
CREATE PROCEDURE sp_get_student_by_id(IN p_id int)
begin
select * from student where id = p_id;
end //
delimiter ;
call sp_get_student_by_id(3);

-- 3.3 sp đếm số lượng học viên của trung tâm sử dụng OUT param

-- gọi sp


select * from student;

-- 4 viêt 1 function xếp loại học lưc theo point

-- sử dụng function


   select *, f_xep_loai(point) as xep_loai from student ;
-- 5 tạo trigger tự động tạo tài khoản jame trước khi thêm mới một học viên
 select * from student;
 select * from jame;

insert into student(`name`,birthday, email, gender,`point`, class_id,`username`) 
 values ('Bùi minh tiến','1990-12-12','tienb@gmail.com',1,8,1,'tienb@gmail.com')

DELIMITER //
CREATE TRIGGER tr_auto_create_jame 
BEFORE INSERT ON student
FOR EACH ROW
BEGIN
insert into jame(`username`, `password`) values ( new.email, '123');
END //
DELIMITER ;
drop trigger tr_auto_create_jame;

-- tạo trigger để ghi lại lich sử thây đổi thông tin bảng student
DELIMITER //
CREATE TRIGGER tr_history 
AFTER UPDATE ON student
FOR EACH ROW
BEGIN
insert into `history`(`name`, old_point, new_point, update_day) 
values ( old.`name`, old.`point`,new.`point`,now());
END //
DELIMITER ;

select * from history;
select * from student;

-- tạo bảng để ghi log
create table `history`(
id int auto_increment primary key,
name varchar(50),
old_point int,
new_point int,
update_day date
);

-- ss5: index, view, sp, function, trigger
-- 1. index
select * from customers;
explain select * from customers where city like 'lyon';
 select count(*) from customers where city= 'lyon';
explain select * from customers;
create index i_city on customers(city);

drop index i_city on customers;

 -- 2.view (tạo view lấy thông tin của học viên)
 create view w_student as 
select s.id, s.name, s.point, c.name as class_name from student s
join class c on s.class_id=c.id;
 -- sử dụng view
select * from w_student;

-- 3.1  tạo một sp không tham số  để lấy danh sách student
delimiter //
create procedure sp_get_all_student()
begin
select * from student;
end //
delimiter ;

#===================goi sp
call sp_get_all_student();

#==================== 3.2 sp có tham số in để lấy ra học viên có tham số id
delimiter //
create procedure sp_get_student_by_id(in p_id int)
begin
select * from student where id =p_id;
end //
delimiter ;

call sp_get_student_by_id(1);

delimiter //
create procedure delete_cl(in cl_id int)
begin
DELETE from class where class.id = cl_id;
end //
delimiter ;
 CALL delete_cl(4);


#================= 3.3 sp đếm số lượng học viên của trung tâm sử dụng OUT param
delimiter //
create procedure count_student(out p_count int)
begin
select count(*) into p_count from student;
end //
delimiter ;
-- gọi sp
call count_student(@sl);
select @sl;

select * from student;

-- 4 viêt 1 function xếp loại học lưc theo point
delimiter //
create function f_xep_loai(diem int)
returns varchar(50)
deterministic
begin
declare loai varchar(50);
if diem>=8 then
set loai ='giỏi';
elseif diem>=7 then
set loai='khá';
else
set loai='trung bình';
end if;
return loai;
end //
delimiter ;
-- sử dụng function
select f_xep_loai(9);

select *, f_xep_loai(point) as xep_loai from student ;
-- 5 tạo trigger tự động tạo tài khoản jame trước khi thêm mới một học viên
 select * from student;
 select * from jame;

insert into student(`name`,birthday, email, gender,`point`, class_id,`account`) 
 values ('Bùi minh tiến','1990-12-12','tienb@gmail.com',1,8,1,'tienb@gmail.com')

DELIMITER //
CREATE TRIGGER tr_auto_create_jame 
BEFORE INSERT ON student
FOR EACH ROW
BEGIN
insert into jame(`account`, `password`) values ( new.email, '123');
END //
DELIMITER ;
drop trigger tr_auto_create_jame;

-- tạo trigger để ghi lại lich sử thây đổi thông tin bảng student
DELIMITER //
CREATE TRIGGER tr_history 
AFTER UPDATE ON student
FOR EACH ROW
BEGIN
insert into `history`(`name`, old_point, new_point, update_day) 
values ( old.`name`, old.`point`,new.`point`,now());
END //
DELIMITER ;

select * from history;
select * from student;

-- tạo bảng để ghi log
create table `history`(
id int auto_increment primary key,
name varchar(50),
old_point int,
new_point int,
update_day date
);

















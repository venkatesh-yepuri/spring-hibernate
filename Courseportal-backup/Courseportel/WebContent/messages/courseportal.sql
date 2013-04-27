create database courseportal;
use courseportal;

create table user(username varchar(50) primary key,password varchar(50),confpassword varchar(50),firstnamename varchar(50),address varchar(50),
email varchar(50),phone varchar(12),mobile varchar(12),
fax varchar(12),qualification varchar(50),
role varchar(50),skillexpsummary varchar(50),status varchar(50));



insert into user values('dhanum','danu','dhanumjayrao','aspt','dhanum.j1213@gmail.com',255204,9848,536714,'btech','student','2yrs','ok');
create table course(course_id int,title varchar(30),description varchar(40),faculty varchar(30),creation_date Date,technology varchar(30));
insert into course values(2,'.Net','this is dyanamic lang','devi priya','2010-03-09','visual studio'); 
select * from user;
select * from course;
desc course;
desc user;
create table course_student(cs_id int AUTO_INCREMENT primary key ,course_id int,user_name varchar(30),creation_date date,status varchar(30));
create table course_material(cm_id int AUTO_INCREMENT primary key,course_id int,title varchar(50),description varchar(200),location varchar(100),creation_date date);
create table course_assignment(ca_id  int AUTO_INCREMENT primary key,course_id int,title varchar(50),description varchar(200),location varchar(100),creation_date date);
create table query(q_id int primary key auto_increment,username varchar(40),course_id varchar(30),question varchar(30),subject varchar(30),creation_date date);
create table queryanswer(qa_id int AUTO_INCREMENT primary key,q_id int,user_name varchar(30),answer varchar(30),creation_date date);

create table admin(userid varchar(30),password varchar(30));

insert into admin values('admin','admin');
SHOW TABLES;
SHOW DATABASES;

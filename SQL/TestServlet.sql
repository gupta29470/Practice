create database fun;
use fun;
create table student(id int auto_increment primary key, 
firstName varchar(50), 
lastName varchar(50), 
email varchar(50)
); 
insert into student(firstName, lastName, email) values ("Aakash", "Gupta", "gupta@gmail.com");
insert into student(firstName, lastName, email) values ("Amit", "Yadav", "yadav@gmail.com");
insert into student(firstName, lastName, email) values ("Durgesh", "Singh", "singh@gmail.com");
insert into student(firstName, lastName, email) values ("Babu", "Ghosh", "ghosh@gmail.com");
insert into student(firstName, lastName, email) values ("Kaanu", "Choudhary", "choudhary@gmail.com");


select * from student;
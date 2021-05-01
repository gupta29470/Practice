create database Fun_University;
use Fun_University;
create table Fun_Student(id int auto_increment primary key, 
firstName varchar(50), 
lastName varchar(50), 
email varchar(50), 
entryDate datetime default now()
); 
insert into Fun_Student(firstName, lastName, email) values ("Aakash", "Gupta", "gupta@gmail.com");
insert into Fun_Student(firstName, lastName, email) values ("Tony", "Stark", "ironman@pepper.com");
insert into Fun_Student(firstName, lastName, email) values ("Steve", "Rogers", "captain@peggy.com");
insert into Fun_Student(firstName, lastName, email) values ("Bruce", "Banner", "hulk@natasha.com");
insert into Fun_Student(firstName, lastName, email) values ("T'Challa", "Shuri", "blackpanther@wakandaforever.com");
select * from Fun_Student;

SET SQL_SAFE_UPDATES = 0;
delete from Fun_Student where lastName = "Aalam";
select * from Fun_Student;
delete from Fun_Student;

select now();
alter table Fun_Student add entryTime datetime default now();

select id, firstName, lastName, email, date_format(entryTime, '%d-%m-%Y %h:%m:%s') as entryTime from Fun_Student 
order by YEAR(entryTime) DESC, MONTH(entryTime) DESC, DAY(entryTime) desc,
HOUR(entryTime) desc, MINUTE(entryTime) desc, SECOND(entryTime) desc;

insert into Fun_Student(firstName, lastName, email) values ("Otis", "Milburn", "milburn@gmail.com");

select id, firstName, lastName, email, concat(day(entryTime),' ', monthname(entryTime),' ', year(entryTime)) as entryTime from Fun_Student 
order by YEAR(entryTime) DESC, MONTH(entryTime) DESC, DAY(entryTime) desc,
HOUR(entryTime) desc, MINUTE(entryTime) desc, SECOND(entryTime) desc;
update Fun_Student set firstName = "Hello" , entryTime = now() where id = 30;

drop table Fun_Student;


create table counter(id int auto_increment primary key, 
addCounter int, 
updateCounter int, 
deleteCounter int);

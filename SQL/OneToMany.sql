use book;
create table customer(id int auto_increment primary key, 
firstName varchar(50), 
lastName varchar(50), 
email varchar(50)
); 

create table orders(id int auto_increment primary key,
orderDate date,
amount decimal(8,2),
customer_id int,
foreign key(customer_id) references customer(id)
); 

insert into customer(firstName, lastName, email) values ("Aakash", "Gupta", "gupta@gmail.com");
insert into customer(firstName, lastName, email) values ("Amit", "Yadav", "yadav@gmail.com");
insert into customer(firstName, lastName, email) values ("Durgesh", "Singh", "singh@gmail.com");
insert into customer(firstName, lastName, email) values ("Babu", "Ghosh", "ghosh@gmail.com");
insert into customer(firstName, lastName, email) values ("Kaanu", "Choudhary", "choudhary@gmail.com");
select * from customer;

insert into orders(orderDate, amount, customer_id) values("1998/12/05", 2947.00, 1);
insert into orders(orderDate, amount, customer_id) values("1999/02/22", 2750.92, 2);
insert into orders(orderDate, amount, customer_id) values("1999/08/14", 2947.65, 1);
insert into orders(orderDate, amount, customer_id) values("1999/08/19", 1800.55, 5);
insert into orders(orderDate, amount, customer_id) values("1999/09/10", 1947.27, 3);
select * from orders;



select * from orders where customer_id = (select id from customer where lastName = "Yadav");
select * from customer where id = (select id from orders where id = 3);

-- Cross Join (useless basically) 
select * from customer, orders;


-- Implicit Inner join
select * from customer, orders where customer.id = orders.customer_id; 
select firstName, LastName, orderDate from customer, orders where customer.id = orders.customer_id; 



-- Explicit Inner Join
select * from customer join orders on customer.id = orders.customer_id;
select firstName, lastName, amount from customer join orders on customer.id = orders.id;
select * from customer inner join  orders on customer.id = orders.customer_id;


-- Clause using Inner Join
select * from customer join orders on customer.id = orders.customer_id order by orders.amount;
select * from customer join orders on customer.id = orders.customer_id order by amount;

select firstName, lastName, sum(amount) as "totalSpent" from customer 
join orders on customer.id = orders.id group by orders.customer_id;


select firstName, lastName, sum(amount) as "totalSpent" from customer 
join orders on customer.id = orders.id group by orders.customer_id;


select firstName, lastName, sum(amount) as "totalSpent" from customer
join orders on customer.id = orders.id group by orders.customer_id 
order by amount desc;


-- Left Join
select * from customer left join orders on customer.id = orders.customer_id;

select firstName, lastName, amount, orderDate from customer left join orders 
on customer.id = orders.customer_id;

select firstName, lastName, avg(amount), orderDate from customer left join orders 
on customer.id = orders.customer_id group by customer.id;

 
-- Amount can't be null make it 0
select firstName, lastName, ifnull(sum(amount), 0) as totalSpent, orderDate 
from customer left join orders on 
customer.id = orders.customer_id group by customer.id order by totalSpent;



-- Right Join
select * from orders right join customer  on customer.id = orders.customer_id ;



-- Exercise
create table StudentsTab(Student_Id int auto_increment primary key,
	Student_Name varchar(25));

insert into StudentsTab(Student_Name) values("Aakash"),("Amit"),("Durgesh"),("Lala"),("Kaanu");
select * from StudentsTab;


create table Papers (Id int auto_increment primary key,
Student_Id int ,
foreign key(Student_Id) references StudentsTab(Student_Id),
	Title varchar(200),Grade int);

insert into Papers(Student_Id, Title, Grade) values
(1, 'My First Book Report', 60),
(1, 'My Second Book Report', 75),
(2, 'Russian Lit Through The Ages', 94),
(2, 'De Montaigne and The Art of The Essay', 98),
(4, 'Borges and Magical Realism', 89);

select * from Papers;

select Student_Name, Title, Grade from StudentsTab
join Papers on StudentsTab.Student_Id = Papers.Student_Id 
order by Grade desc;

select Student_Name, Title, Grade from StudentsTab
left join Papers on StudentsTab.Student_Id = Papers.Student_Id;

select Student_Name, ifnull(Title, "Missing"), ifnull(Grade, 0) from StudentsTab
left join Papers on StudentsTab.Student_Id = Papers.Student_Id;

select Student_Name, avg(Grade) from StudentsTab
left join Papers on StudentsTab.Student_Id = Papers.Student_Id
group by Student_Name;


select Student_Name, ifnull(avg(Grade), 0),
	case
		when avg(Grade) >= 75 then "Pass"
		else "Fail"
	end as PassingStatus
from StudentsTab 
left join Papers on 
StudentsTab.Student_Id = Papers.Student_Id
group by Student_Name;
    
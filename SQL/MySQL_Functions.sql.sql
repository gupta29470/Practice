CREATE TABLE books 
	(
		book_id INT NOT NULL AUTO_INCREMENT,
		title VARCHAR(100),
		author_fname VARCHAR(100),
		author_lname VARCHAR(100),
		released_year INT,
		stock_quantity INT,
		pages INT,
		PRIMARY KEY(book_id)
	);

INSERT INTO books (title, author_fname, author_lname, released_year, stock_quantity, pages)
VALUES
('The Namesake', 'Jhumpa', 'Lahiri', 2003, 32, 291),
('Norse Mythology', 'Neil', 'Gaiman',2016, 43, 304),
('American Gods', 'Neil', 'Gaiman', 2001, 12, 465),
('Interpreter of Maladies', 'Jhumpa', 'Lahiri', 1996, 97, 198),
('A Hologram for the King: A Novel', 'Dave', 'Eggers', 2012, 154, 352),
('The Circle', 'Dave', 'Eggers', 2013, 26, 504),
('The Amazing Adventures of Kavalier & Clay', 'Michael', 'Chabon', 2000, 68, 634),
('Just Kids', 'Patti', 'Smith', 2010, 55, 304),
('A Heartbreaking Work of Staggering Genius', 'Dave', 'Eggers', 2001, 104, 437),
('Coraline', 'Neil', 'Gaiman', 2003, 100, 208),
('What We Talk About When We Talk About Love: Stories', 'Raymond', 'Carver', 1981, 23, 176),
("Where I'm Calling From: Selected Stories", 'Raymond', 'Carver', 1989, 12, 526),
('White Noise', 'Don', 'DeLillo', 1985, 49, 320),
('Cannery Row', 'John', 'Steinbeck', 1945, 95, 181),
('Oblivion: Stories', 'David', 'Foster Wallace', 2004, 172, 329),
('Consider the Lobster', 'David', 'Foster Wallace', 2005, 92, 343);
select * from books;
desc books;

-- Concat
select concat('Hello','...','World');
select concat(author_fname,'  ',author_lname) as 'Full Name' from books;
select author_fname as 'First Name' , author_lname as 'Last Name' ,concat(author_fname,' ', author_lname) as 'Full Name' from books;
select concat_ws('-',author_fname,author_lname,title) from books;


-- Substring
show databases;
use book;
select substring('Hello World',1,7);
select substring('Hello World',5);
select substring('Hello World',-5);
select substring("What We Talk About When We Talk About Love: Stories",1,10);
select substring(title,1,10) as 'Short Title' from books;
select concat(substring(title,1,10),'...') as 'Short Title' from books;

-- Replace
select replace('Hello' ,'l',7);
select replace('HeLl','l',7); -- Case sesnsitive
select replace('cheese bread egg',' ', ' and ');
select replace(title , 'e' , '3') from books;
select substring(replace(title , 'e' , '3') ,1,10) as 'Replace and Substring' from books; 


-- Reverse
select reverse('Hello World');
select reverse(author_fname) as 'Reverse First Name' from books;
select concat(author_fname,' ',reverse(author_lname)) as 'Reverse and Concat' from books;

-- char length
select char_length('Hello');
select author_lname as'Author Last Name',char_length(author_lname) as 'Length' from books;
select concat(author_lname, ' is ', char_length(author_lname), ' characters long') as 'Desc'from books;


-- Upper and Lower
select upper('hello world');
select lower('HELLO WORLD');
select upper(title) from books;
select concat("My favorite book is ",upper(title)) from books;
select concat("My favorite book is ",lower(title)) from books;

-- Exercise
select reverse(upper("Why does my cat look at me with such hatred")) as 'Reverse and Upper';
select replace(concat('I',' ','Like',' ','Cats'), ' ','_');
select replace(concat(title),' ','->') as 'Title' from books;
select author_lname as'Forward',reverse(author_lname) as'Backwards' from books;
select upper(concat(author_fname,' ',author_lname)) as'Full Name in Caps'  from books;
select concat(title,' was released in ',released_year) as 'Title and Released Year' from books;
select title as 'Title',char_length(title) as 'Character Count' from books;
select substring(title,1,10) as'Short Title',concat(author_fname,',',author_lname)as 'Author',concat(stock_quantity,' in stock') from books;


-- Distinct give unique values avoid duplicates
select distinct(author_lname)from books;
select distinct(released_year) from books;
select distinct(concat(author_fname,' ', author_lname)) from books; 
select distinct author_fname,author_lname from books;


-- Order By
select author_lname from books order by author_lname; -- Ascending by default
select author_lname from books order by author_lname desc;
select title from books order by title desc;
select released_year from books order by released_year desc;
select title,released_year,pages from books order by released_year;
select title,pages from books order by released_year;
select title,author_fname,author_lname from books order by 2; -- 2 indicates 2nd select column(author_fname)
select title,author_fname,author_lname from books order by 3; -- 2 indicates 3rd select column(author_lname)
select title,author_fname,author_lname from books order by 3,2,1; -- 2 indicates 3rd select column(author_lname)
-- Retrieve second highest pages
select * from books order by pages desc limit 1,1; -- start from last to second last

-- Limit
select title from books limit 2; 
-- 5 recently released book
select title, released_year from books order by released_year desc limit 5;
select title, released_year from books order by released_year desc limit 0,5; -- same thing from above  0 is starting and 5 is how many rows to print


-- Like
select author_fname from books where author_fname like '%da%' ;
select author_fname from books where author_fname like 'R%';
select author_lname from books where author_lname like 'F%' ;
select title,author_lname from books where author_lname like 'F%' ;
select title from books where title like '%the%' ;

select title,stock_quantity from books where stock_quantity like '___'; -- 3 underscore means 3 digits/characters.
select title,stock_quantity from books where stock_quantity like '__'; -- 2 underscore means 3 digits/characters.

-- title contains % or _
select title,stock_quantity from books where stock_quantity like '%\_%'; -- 3 underscore means 3 digits/characters.
select title,stock_quantity from books where stock_quantity like '%\%%'; -- 3 underscore means 3 digits/characters.
select title from books where title like '%stories%'; -- Title contains stories
select title,max(pages) from books ; -- Max page book
select title ,released_year from books order by released_year desc limit 3; -- 3 recent books
select title,author_lname from books where author_lname like '% %'; -- Lname contains space
select title,released_year,stock_quantity from books order by stock_quantity limit 3; -- 3 Mininum stocks
select title ,author_lname from books order by author_lname; -- Sort by lname
select title ,author_lname from books order by title; -- Sort by title
select concat("My Faviourite author is ",author_fname," ",author_lname) as "Faviourite Author" from books order by author_lname; 


-- Count
select count(*) from books;
select count(author_fname) from books;
select count(distinct(author_fname)) from books;
select count(distinct(title)) from books;
select count(*) from books where title like '%the%';


-- Group by
use book;
select title,released_year from books;
select title, count(*) from books group by released_year;
select author_fname,count(*) from books group by author_fname;
select author_lname,count(*) from books group by author_lname;
select concat('In ', released_year,' ', count(*),' book(s) released') as'Number of book(s) released in each year'from books group by released_year;


-- Min ,Max, Subquery
select min(released_year) from books;
select min(pages) from books;
select max(pages) from books;
select * from books where pages=(select min(pages) from books);
select title as "Title", pages as "Pages"from books where pages=(select min(pages) from books);
select title as "Title", pages as "Pages"from books where pages=(select max(pages) from books);
 -- Upper query take more time  for larger dataset
 -- Another Solution
 
 -- Min and Max using order by
 select title as "Title", pages as "Pages"from books order by pages asc limit 1;
  select title as "Title", pages as "Pages"from books order by pages desc limit 1;
  
  -- Min and Max using group by
  select author_lname,author_fname,min(released_year) from books group by author_lname,author_fname;
  select concat(author_lname,' ' ,author_fname)as "Author" ,max(pages) as"Max Pages" from books group by author_lname,author_fname;
  
  -- Sum
  select sum(pages) from books;
  select author_fname,author_lname ,sum(pages) from books group by author_fname,author_lname; 
  
  -- Avg
select avg(pages) from books;
select author_fname,author_lname ,avg(pages) from books group by author_fname,author_lname; 
select avg(released_year) from books;
select released_year,avg(stock_quantity) from books group by released_year;

-- Exercise
use book;
select count(title) from books; -- Count number of books
select count(title),released_year from books group by released_year; -- how many books released by year
select sum(stock_quantity) from books; -- sum of stock
select avg(released_year) from books group by author_lname,author_fname; -- avg released year of books by authors
select author_lname, author_fname from books where pages=(Select max(pages) from books); -- Author full name of max pages
SELECT CONCAT(author_fname, ' ', author_lname) FROM books ORDER BY pages DESC LIMIT 1;
select released_year as 'Year',count(title) as 'Books',avg(pages) as 'AVGPages' from books group by released_year;


-- Time Date
create table people(Name varchar(100), BirthDate date, BirthTime time, BirthDateTime datetime); 
insert into people values('Aakash','1998-12-5','12:04:01','1998-12-5 12:04:01');
select * from people;
select current_time();
select current_date();
select now(); -- now and timestamp is same
select current_timestamp() as 'TimeStamp',current_date() as 'Date',current_time() as'Time',current_user() as'User';
select curdate(),curtime(),now(),dayname();
select dayofmonth('1998-12-5');
select day('1998-12-5');
select dayname('1998-12-5');
select dayofweek('1998-12-5');
select month('1998-12-5');
select monthname('1998-12-5');
select dayofyear('1998-12-5');

-- day
select day(BirthDate) from people;
select dayname(BirthDate) from people;
select dayofweek(BirthDate) from people;
 
-- month and year
select month(BirthDate) from people;
select monthname(BirthDate) from people;
select dayofyear(BirthDate) from people;
select year(BirthDate) from people;


-- date format
select date_format(BirthDate,'%d/%m/%y') from people; -- day/month/year
select date_format(BirthDate,'%d-%m-%y') from people; -- day-month-year
select date_format(BirthDate,'%m-%d-%y') from people; -- month-day-year
select concat(Name,' born on ' ,date_format(BirthDate,'%m/%d/%y  at  %h:%m:%s')) as 'Date Format' from people;


-- date math
select datediff('1998-12-5','1998-12-31'); -- diff between 2 dates
select Name,BirthDate,datediff(now(),BirthDate) as 'Diff' from people;
select date_sub('1998-12-5',INTERVAL 15 DAY); -- past 15 day(date)
select date_add(now(),interval 10 day) as 'Adding 10 days' ;
select date_add(now(),interval 10 month) as 'Adding 10 month' ;
select date_add(now(),interval 10 week) as 'Adding 10 week' ;
select date_add(now(),interval 10 year) as 'Adding 10 year' ;
select date_add(now(),interval 3 quarter) as 'Adding 3 quarter' ; -- adding 9 months

-- Another way
select (now()+interval 10 day) as 'Add 10 day'; 
select (now()-interval 10 day) as 'Subtract 10 day';
-- Doing multiple things
select (now()+interval 1 month+interval 10 day) as 'Adding 1 month and 10 day';
select (now()-interval 1 month+interval 10 day) as 'Adding 1 month and 10 day';
select (now()-interval 1 month+interval 10 day+interval 10 hour) as 'Subtract 1 month , 10 day and 10 hour';
select (now()-interval 1 month+interval 10 day+interval 10 hour) as 'Subtract 1 month , 10 day and 10 hour';
select (now()+interval 1 month+interval 10 day+interval 10 minute) as 'Adding 1 month , 10 day and 10 minute';

-- Time stamps
-- Diff between date time and time stamps: They both do same things both show date and time
-- But there is difference in range.
-- Datetime shows date and time between:'1000-01-01 00:00:00:' to '9999-12-31 23:59:59'
-- Timestamp shows date and time between :'1970-01-01 00:00:01' UTC to '2038-01-19 03:14:07' UTC
select timestamp(now());
create table comments(content varchar(26),created_on timestamp default now() );
insert into comments(content) values('Nice');
select * from comments;
insert into comments(content) values('Beautiful');
insert into comments(content) values('Jhakas');

select * from comments order by created_on desc;

-- Exercise
select dayofweek(curdate());
select curtime();
select curdate();
select date_format(curdate(),'%m-%d-%y');
select date_format(now(),'%d-%m-%yat %h:%m%:%s');


-- Not equal
use book;
select title,released_year from books where released_year!=2000; 
select title, author_lname from books where author_lname!="Harris";

-- Not Like
select title,author_lname from books where title not like '%N%';

-- Greater than equals to
select * from books where released_year>2000 order by released_year;
select * from books where stock_quantity>=100;
select 99>1; -- Boolean value 1=true 0=false;
select 'A'>='a'; -- 1
select 'h'>'p'; -- 0

-- Less Than equals to
select * from books where released_year<2000 order by released_year;
select * from books where stock_quantity<=100 order by stock_quantity;
select 3<-10; -- 0
select -10<-9; -- 1
select 'h'<'p'; -- 1
select 'Q'<'p'; -- 0

-- Logical AND
select * from books where author_fname='David' and released_year>2000;
select * from books where author_fname='David' && released_year>2000;
select * from books where author_lname="Eggers" and released_year>2000 and title like '%novel%';
select -10>-20 && 0<=0;



-- Between and
select title from books where released_year between 2004 and 2015;
select title from books where released_year not between 2004 and 2015;


-- In and Not In
select title from books where author_lname in('Carver', 'Eggers');
select title from books where released_year in (2000,2002,2004);
select title from books where author_lname not in('Carver', 'Eggers');
select title from books where released_year not in (2000,2002,2004);


-- Case
select title, released_year,
	case
    when released_year > 2000 then 'modern lit'
    else '20th century'
    end as genre
from books;

select title, stock_quantity,
	case
		when stock_quantity > 100 then 'Stock is available'
        else 'Order books'
        end as 'Displaying Stock Status'
from books;
select title, stock_quantity,
	case
		when stock_quantity between 0 and 50 then '*'
        when stock_quantity between 51 and 100 then '**'
        else '***'
        end as 'Displaying Stock Status'
from books;




-- Exercise
select title, released_year from books where released_year < 1980;
select title, author_lname from books where author_lname in('Eggers', 'Chabon');
select title, author_lname,released_year from books where author_lname  = 'Lahiri' and released_year > 2000;
select title, pages from books where pages between 100 and 200;
select title, author_lname  from books where author_lname like 'C%' or  author_lname like 'S%';

select title,author_lname,
	case
		when title like '%stories%' then 'ShortStories'
        when title like 'Just Kids' or title like 'A Heartbreaking Work%' then 'Memoir'
        else 'Novel'
	end as TYPESS
from books;

select title, author_lname, count(title) from books group by author_lname;
select author_fname, author_lname,
	case
		when count(*) = 1 then '1 Book'
        else concat(count(*), ' books')
	end as COUNT
from books
group by author_lname, author_fname;



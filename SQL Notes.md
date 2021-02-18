#SQL
- Structured Query Language
- Most popular programming language for dealing with databases
- Been around for 50 years
	- Very well established
	- Bunch of different dialects of SQL
		- OracleSQL
		- MySQL
		- MariaDB
		- postGres
		- SQL server
- SQL is a scripting language
	- a scripting language is a programming language that tells a machine what to do
	- a script is a series of actions you want the machine to take
		- these actions can lead to permanent changes on the machine

		
#Database
- Database is a way to persist information
	- data persistence means to physically save the data in the world
	- You can turn off the power to a database and your data still exists
	- Data is no longer ephemeral
- Types of databases
	- NoSQL
		- usually use documents and JSON trees to store info
	- Graph based databases
		- use complicated connections between nodes to store info
	- Relational Databases
		- most popular type of database
		- All relational databases use SQL

#Relational Database
- Tables are used to store information
	- columns/attributes 
	- rows/records
- tables reference each other to better store information and avoid being redundant
	- done using foreign keys


```SQL
-- USE FOR SDLIntroDB

create table person(first_name varchar(50), last_name varchar(50));
drop table person;

-- tables should be named in the singular
-- the name of the table is what a single record of the table represents
-- a lot of SQL is written in all caps
drop table employee;
create table employee(
	employee_id int primary key generated always as identity, -- primary key is constraint. It means unique and not null
	first_name varchar(50), 
	last_name varchar(50), 
	salary int);

select * from employee;

insert into employee(first_name, last_name, salary) values('Noah', 'Gilf', 200000);
insert into employee(first_name, last_name, salary) values('Noah', 'Gilf', 200000);
insert into employee(first_name, last_name, salary) values('Noah', 'Gilf', 200000);
insert into employee(first_name, last_name, salary) values('Noah', 'Gilf', 200000);

-- any good database each record should be unique
-- this unique identifier for a record is called primary key


-- DQL (Data Query Language) - any statement that starts with 'select'
-- select {columns you want} from {table} where {filters records}
select * from employee where first_name = 'Noah';
select last_name, salary from employee  where first_name = 'Noah';
select first_name from employee where salary > 40000;

-- DML (Data manipulation language)
-- SQL statements that add remove or modify data in your table
insert into employee (first_name, last_name, salary) values ('Jim', 'Snow', 10000000);

delete from employee; -- really important to have where, or everything will be deleted
delete from employee where employee_id = 7;
-- will empty the table

-- update and set to modify data
update employee set last_name = 'stark' where employee_id = 10;
-- be careful of the 'where' clause
```

```SQL
-- USE FOR basketballDB

-- Tasked with making a database for a startup basketball league
-- coaches and teams and players

-- DDL (Data definithion language) CREAT or DROP or ALTER
-- changes the tables themselves
drop table player;
drop table team;
create table team(
	team_id int primary key generated always as identity,
	team_name varchar(100),
	hometown varchar(100),
	mascot varchar(100)
);

-- drop table team;

insert into team(team_name, hometown, mascot) values('Grand Dunk Railroad', 'LA', 'Woodchuck');
insert into team(team_name, hometown, mascot) values('Muttonchop Mountaineers', 'Morgantown', 'Rangers');
insert into team(team_name, hometown, mascot) values('Hawks', 'Atlanta', 'Hawk');
insert into team(team_name, hometown, mascot) values('Heat', 'Miami', 'Fire');

select * from team;
-- in a relatioal database, tables contain information related to other tables
-- the tables are RELATED
-- nature of this relationship can be 
	-- 1 to many(many to 1)
	-- many to mnay
	-- 1 to 1 (debatable if your database even needs this)
-- All of these relationships are done by using foreign keys
-- Foreign key is a column that refernces a primary key on another table
-- The foreign key goes on the child table and references the parent
-- The Parent must exist before you can create the child
-- Foreign key is NOT unique, but what it references IS

-- 1 team, many players
create table player(
	player_id int primary key generated always as identity,
	first_name varchar(50),
	last_name varchar(50),
	salary int,
	team_id int, 
	constraint fk_player_team foreign key (team_id) references team(team_id)
	-- this creates foreign key connecting the 2 tables
);

select * from team;
select * from player;

insert into player (first_name, last_name, salary, team_id) values ('Tom','Wan',100000,1);
insert into player (first_name, last_name, salary, team_id) values ('Lebron','James',100000,4);
insert into player (first_name, last_name, salary, team_id) values ('Doctor','Jay',100000,1);
insert into player (first_name, last_name, salary, team_id) values ('Clyde','Somebody',100000,3);
insert into player (first_name, last_name, salary, team_id) values ('Fox','Falco',100000,3);


-- does not work, violates foreign key constraint
-- no team with id 5
-- huge reason we have foreign keys is to prevent ORPHAN records
	-- orphan record is record with no valid foreign key
-- maintain referential integrity
-- prevents data from being disconnected and not relatable
--insert into player (first_name, last_name, salary, team_id) values ('Tom','Tom',100000,5);

delete from team where team_id = 2; -- this works
delete from team where team_id = 1; 
-- foreign keys with team 1 are preventing this from being deleted
-- to delete team1, will need to delete all team1 players first

-- what is the hometown of Clyde?
-- There is not a SINGLE table that can answer that
-- will need to combine 2+ tables to get the answer

-- many queries require us to join tables together to answer question/get info
-- a join generates a new temp table for you to query
-- this table is often called virtual table or view (not physically stored in database

select hometown from player inner join team on player.team_id = team.team_id where first_name = 'Clyde';
```

#Normalization
- The process by which we eliminate redundancy
- There are 7 normalized forms
	1. 1nf 
		- all records in a table must be uniquely identifiable (have a primary key)
		- all columns must be *atomic*
			- the data in it can not be broken down into something more meaningful
			- name is not atomic -> can be broken to first/last
			- address is not atomic -> can be broken down to local address/state/zip
		- 
	2. 2nf
		- You are in 1nf
		- you have no functional dependencies
			- You cannot calculate one field or column using the value of other columns
			- counter-example
			- shots taken, shots made, shooting percentage 
			- percentage is calculated from shots taken and made, it is a functional dependency
	3. 3nf
		- You are in 2nf
		- You have no transitive dependencies
			- counter example
			- if player table had a field saying who head coach is
				- transitive bc you can look at team, and coaches for the team. it is already there somewhere else
			- if you can find dataa anywhere else, that is a transitive dependency
	4. 4nf
		- 
	5. 5nf
		- 
	6. 6nf
		- 
	7. 7nf
		- 
- normalization does not necessarily mean better
	- highly normalized is not always preferable
	- highly normalized databases tend to be difficult to analyze and query
	- OLTP (transactioal databases)
		- highly normalized 
		- lots of updates and insertions
	- OLAP (analytical databases)
		- denormalized
		- very read heavy
- A join is a denormalization of your data
	- left join
		- all records on left table plus matching from right
	- right join
		- all records on right table plus matching from left
	- inner join
		- only matching records
	- cross join
		- every record matched with every record
	- outer join?
		- 
- 

REM   Script: ACTIVITY3
REM   Activity3

create table salesman(salesman_id int, salesman_name varchar2(20),salesman_city varchar2(20),commission int);

Describe salesman


insert into salesman VALUES(5001,'James Hoog','New York',15);

insert into salesman VALUES(5002,'Nail knite','Paris',13);

insert into salesman VALUES(5005,'Pit Alex','London',11);

insert into salesman VALUES(5006,'Mclyon','Paris',14);

insert into salesman VALUES(5007,'Paul Adam','Rome',13);

insert into salesman VALUES(5003,'Lauson Hen','San Jose',12);

select * from salesman;

select salesman_id,salesman_city from salesman;

select * from salesman where salesman_city='paris';

select * from salesman where salesman_city='Paris';

select salesman_id, commission from salesman where salesman_name='Paul Adam';


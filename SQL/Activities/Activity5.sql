REM   Script: ACTIVITY5
REM   Activity5

create table salesman(salesman_id int, salesman_name varchar2(20),salesman_city varchar2(20),commission int);

Describe salesman


insert into salesman VALUES(5001,'James Hoog','New York',15);

insert into salesman VALUES(5002,'Nail knite','Paris',13);

insert into salesman VALUES(5005,'Pit Alex','London',11);

insert into salesman VALUES(5006,'Mclyon','Paris',14);

insert into salesman VALUES(5007,'Paul Adam','Rome',13);

insert into salesman VALUES(5003,'Lauson Hen','San Jose',12);

update salesman set grade=200 where salesman_city='Rome';

update salesman set grade=300 where salesman_name='James Hoog';

update salesman set grade=300 where salesman_name='James Hoog';

update salesman set salesman_name='Pierre' where salesman_name='Mclyon';

select * from salesman;


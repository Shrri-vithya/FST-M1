REM   Script: ACTIVITY 8
REM   Activity 8

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

select DISTINCT salesman_id from orders;

select order_no,purchase_amount from orders order by purchase_amount DESC;

select * from orders where purchase_amount < 500;

select * from orders where purchase_amount BETWEEN 1000 AND 2000;

create table emp(empid int,empname varchar(20), deptid int);

create table dept(deptid int,depname varchar(20));

insert all into emp values(1,'shrri',10) 
into emp values(2,'sanjay',20) 
into emp values(3,'surya'10) 
into emp values(4,'aravindh',20) 
select 1 from dual;

insert all into emp values(1,'shrri',10), 
into emp values(2,'sanjay',20) 
into emp values(3,'surya',10) 
into emp values(4,'aravindh',20) 
select 1 from dual;

create table bricks(brick_id int,brick_shape varchar2(20), brick_color varchar2(10));

create table toys(toy_id int,toy_name varchar2(20), toy_color varchar2(10));

insert All into toys values(1,'tom','pink') 
into toys values(2,'jerry','blue') 
into toys values(3,'turtle','green') 
select 1 from dual;

insert All into bricks values(2,'cube','green') 
into toys values(3,'cube','blue') 
into toys values(4,'pyramid','green') 
select 1 from dual;

select * from toys;

insert All into bricks values(2,'cube','green') 
into bricks values(3,'cube','blue') 
into bricks values(4,'pyramid','green') 
select 1 from dual;

select * from toys;

delete from toys where toy_name='cube' and toy_name='pyramid';

delete from toys where toy_name='cube';

delete from toys where toy_name='pyramid';

select * from toys;

select * from bricks;

delete from bricks where brick_shape='cube';

select * from bricks;

insert All into bricks values(2,'cube','green') 
into bricks values(3,'cube','blue') 
select 1 from dual;

select * from bricks;

select toy_id, toy_name from toys inner join bricks on toy_id=brick_id;

select * from toys right outer join brick on toy_id=brick_id and brick_color='green';

select * from toys right outer join bricks on toy_id=brick_id and brick_color='green';

select * from toys left outer join bricks on toy_id=brick_id and brick_color='green';

select * from toys full join bricks on toy_id=brick_id;

select toy_id, toy_name from toys inner join bricks on toy_id=brick_id;

select * from toys UNION select * from bricks;

select * from orders;

select * from orders;

select order_no, max(purchase_amount) as high_purc_amount from orders group by purchse_amount order by customer_id;

select order_no, max(purchase_amount) as high_purc_amount from orders group by purchase_amount order by customer_id;

select order_no, max(purchase_amount) as high_purc_amount from orders group by customer_id;

select customer_id, MAX(purchase_amount) as "highest amount" from orders group by customer_id;

select * from orders;

select salesman_id, MAX(purchase_amount) as "highest amount" from orders  
    where ORDER_DAte='2012-08-17' group by salesman_id;

select salesman_id, MAX(purchase_amount) as "highest amount" from orders  
    where ORDER_DATE=('2012-08-17','YYYY-MM-DD)' group by salesman_id;

select salesman_id, MAX(purchase_amount) as "highest amount" from orders  
    where ORDER_DATE=TO_DATE('2012-08-17','YYYY-MM-DD') group by salesman_id;

select salesman_id, Order_date, MAX(purchase_amount) as "highest amount" from orders  
    where ORDER_DATE=TO_DATE('2012-08-17','YYYY-MM-DD') group by salesman_id;

select salesman_id, Order_date, MAX(purchase_amount) as "highest amount" from orders  
    where ORDER_DATE=TO_DATE('2012-08-17','YYYY-MM-DD') group by salesman_id;

select salesman_id, MAX(purchase_amount) as "highest amount" from orders  
    where ORDER_DATE=TO_DATE('2012-08-17','YYYY-MM-DD') group by salesman_id, Order_date;

select salesman_id, MAX(purchase_amount) as "highest amount" from orders  
    where ORDER_DATE=TO_DATE('2012-08-17','YYYY-MM-DD') group by salesman_id;

select customer_id,order_date, MAX(purchase_amount) as "highest amount" from orders  
     group by customer_id having max(purchase_amount) IN(2030,3450,5760,6000);

select customer_id,order_date, MAX(purchase_amount) as "highest amount" from orders  
     group by customer_id having MAX(purchase_amount) IN(2030,3450,5760,6000);

select customer_id,order_date, MAX(purchase_amount) as "highest amount" from orders  
     group by customer_id, order_date 
    having MAX(purchase_amount) IN(2030,3450,5760,6000);


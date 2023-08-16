REM   Script: ACTIVITY10
REM   Activity10

select * from orders where salesman_id= (select DISTINCT salesman_id from customers where customer_id='3007');

select * from orders;

select * from orders where salesman_id=(select salesman_id from salesman where salesman_city='New York');

select count(*) from customers where grade >(select Avg(grade) from salesman where salesman_city='New York');

select grade, count(customer_id) from customers group by grade HAving grade >(select Avg(grade) from customers where city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));


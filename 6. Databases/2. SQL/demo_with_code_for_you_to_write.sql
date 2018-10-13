use northwind;

/*SELECT*/

-- select all employees


-- select all employee names; use alias


-- select all job titles; get them uniquely


-- select all employees that work as coordinators


-- select all employees that do not work as coordinators


-- select all order details that have quantity bigger than 50; select just quantity and distinct it


-- select employees with notes / without notes


-- select all unique categories from the products


-- select all sauces from the products


-- select all beverages from products that have minimum reorder quantity


-- select all beverages from products that have minimum reorder quantity or target level above 60


-- select products with price between 20 and 100


-- select products with product name between names


-- select employees that are either from Seattle or Redmond


-- select all products that were purchased


-- add several order by-s

/*GROUP BY*/

-- aggregate functions


-- find the cheapest and most expensive products. What is the average price of a product?



-- find how many products are purchased at all



-- find also the product names

 -- how many customers are from Seattle?

 
-- what are the cities with more then 2 customers?


/*JOIN*/

-- inner join   customer_id, c.first_name, c.company, c.city, o.id as order_id, o.order_date, o.shipped_date 


-- left join 


-- right join 


-- select all products that were purchased with name, quantity, cost and date - show join



-- find out which employees have what priviledges; test left and right joins


-- find customers that are from USA and are not from USA

-- list the employees that have registered more than 10 orders - join + aggregation



/*INSERT, UPDATE, DELETE*/

-- add new privilege


-- insert new customers from suppliers


-- update new customers' company


-- update customers with id between 30 and 36 with note that tey're contrasctors.


-- remove customers without city




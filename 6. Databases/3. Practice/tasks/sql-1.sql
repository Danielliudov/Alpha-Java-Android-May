-- 1
select * 
from departments

-- 2
select name 
from departments

-- 3
select FirstName, LastName, Salary 
from employees

-- 4
select CONCAT(FirstName, ' ', IFNULL(MiddleName, ''), ' ', LastName) 
from employees

select concat_ws(' ' , e.FirstName, e.middlename, e.LastName) as full_name
from employees e

-- 5
select CONCAT(FirstName, '.', LastName, '@telerik.com') as `Full Email Address` 
from employees

-- 6
select distinct salary 
from employees

-- 7
select * 
from employees
where JobTitle = 'Sales Representative'

-- 8
select FirstName
from employees
where FirstName like 'sa%'

-- 9
select FirstName, LastName
from employees
where LastName like '%ei%'

select e.firstname, e.lastname
from employees e
where locate('ei', e.lastname)

-- 10
select FirstName, LastName
from employees
where Salary between 20000 and 30000

-- 11
select FirstName, LastName
from employees
where Salary in (25000, 14000, 12500, 23600)

-- 12
select FirstName, LastName
from employees
where ManagerID is null

-- 13
select FirstName, LastName, Salary
from employees
where Salary > 50000
order by Salary desc

-- 14
select FirstName, LastName, Salary
from employees
order by Salary desc
limit 5

-- 15
select e.FirstName, e.LastName, a.AddressText
from employees e
join addresses a on a.AddressID = e.AddressID

select e.firstname, e.lastname, e.salary, a.addresstext, t.name
from employees e
join addresses a on a.addressid = e.addressid
join towns t on t.townid = a.townid

-- 16
select e.FirstName, e.LastName, m.FirstName as ManagerFirstName, m.LastName as ManagerLastName
from employees e
join employees m on m.EmployeeID = e.ManagerID

-- 17
select 
	e.FirstName, 
	e.LastName, 
	a.AddressText, 
	m.FirstName as ManagerFirstName, 
	m.LastName as ManagerLastName
from employees e
join employees m on m.EmployeeID = e.ManagerID
join addresses a on a.AddressID = e.AddressID

select concat_ws(' ',e.firstname, e.lastname) as employee, concat_ws(' ',m.firstname, m.lastname) as manager
, a.addresstext as employee_address
, a1.addresstext as manager_address
from employees e
join employees as m on m.employeeid = e.managerid
join addresses a on a.addressid = e.addressid
join addresses a1 on a1.addressid = m.addressid

-- 18
select name from departments
union
select name from towns

-- 19
select e.FirstName, e.LastName, IFNULL(m.FirstName, 'n/a'), IFNULL(m.LastName, 'n/a')
from employees e
left join employees m on m.EmployeeID = e.ManagerID

-- 20
select e.FirstName, e.LastName, d.Name, e.HireDate
from employees e
join departments d on d.DepartmentID = e.DepartmentID
where d.Name in ('Sales', 'Finance') and 
	(YEAR(e.HireDate) between 2002 and 2004)
    
    
select *
from employees
where DepartmentID in 
(
	select DepartmentID from departments
    where departments.Name in ("Sales", "Finance")
) and
hiredate between '1995-01-01' and '2005-12-31'

select e.firstname, e.hiredate, t.name
from employees e
join (
select departmentid, name from departments
where name in ('Finance', 'Sales')
) t on t.departmentid = e.departmentid
where year(e.hiredate) between 1995 and 2005
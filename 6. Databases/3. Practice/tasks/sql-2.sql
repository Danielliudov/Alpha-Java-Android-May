-- 1
select FirstName, LastName, Salary
from employees
where Salary = (select min(Salary) from employees);

-- 2
select FirstName, LastName, Salary
from employees
where Salary < (select 1.1 * min(Salary) from employees);

-- 3
select e.FirstName, e.LastName, e.DepartmentID, e.Salary
from employees e
where e.Salary = 
	(select min(Salary) 
	 from employees
	 where DepartmentID = e.DepartmentID
	 group by DepartmentID)
order by DepartmentID;

-- with name

select e.firstname, e.salary, d.name from employees e 
join departments d on d.departmentid = e.departmentid
join (
	select min(salary) as salary, DepartmentID
	from employees
	group by departmentid) t 
on t.departmentid = e.departmentid and t.salary = e.salary;


-- 4
select e.DepartmentID, avg(e.Salary)
from employees e
group by e.DepartmentID
having e.DepartmentID = 1;

-- 5
select e.DepartmentID, avg(e.Salary)
from employees e
join departments d on d.DepartmentID = e.DepartmentID
where d.Name = 'Sales'
group by e.DepartmentID

select d.name, avg(e.Salary)
from employees e
join departments d on d.departmentid = e.departmentid
group by d.name
having d.name = 'Sales';

-- 6
select d.Name, count(e.EmployeeID)
from employees e
join departments d on d.DepartmentID = e.DepartmentID
where d.Name = 'Sales';

select count(SalesTable.employeeID) from
(select * from employees 
	where departmentid = (select departmentid from departments where name like "Sa%")) as SalesTable; 

-- 7
select count(*)
from employees e
where e.ManagerID is not null;

-- 8
select count(*)
from employees e
where e.ManagerID is null;

-- 9
-- okay if name is unique
select d.Name, avg(e.Salary)
from employees e
join departments d on d.DepartmentID = e.DepartmentID
group by d.Name;

select t.salary, d.name
from
(select departmentid, avg(salary) salary
from employees
group by departmentid) t
join departments d on d.departmentid = t.departmentid;

-- 10
select t.Name, d.Name, count(e.EmployeeID) as emplyees_num
from employees e
join departments d on d.DepartmentID = e.DepartmentID
join addresses a on a.AddressID = e.AddressID
join towns t on t.TownID = a.TownID
group by d.Name, t.Name
order by t.Name

-- 11
select m.FirstName, m.LastName
from employees e
join employees m on m.EmployeeID = e.ManagerID
group by e.ManagerID
having count(e.EmployeeID) = 5;

select concat (FirstName, ' ', ifnull(MiddleName, ''), ' ', LastName) as fullname
from employees
where employeeid in
(
	select employeeid
    from employees
    group by managerid
    having count(employeeid) = 5
);

select *
from 
(select count(e.employeeid) as num_employees, e.ManagerID
from employees e
group by e.managerid
having num_employees = 5) t 
join employees m on m.employeeid = t.managerid;

-- 12
select e.FirstName, e.LastName, IFNULL(m.FirstName, 'no manager'), IFNULL(m.LastName, 'no manager')
from employees e
left join employees m on m.EmployeeID = e.ManagerID;

-- 13
select FirstName, LastName
from employees
where LENGTH(LastName) = 5;

-- 14
select DATE_FORMAT(NOW(), '%e.%m.%Y %H:%i:%s:%f');

-- 15
select d.Name as Department, e.JobTitle, avg(e.Salary) as AverageSalary
from employees e
join departments d on d.DepartmentID = e.DepartmentID
group by d.Name, e.JobTitle;

-- 16

-- List all
select e.FirstName, e.LastName, d.Name, e.JobTitle, e.Salary
from employees e
join departments d on d.DepartmentID = e.DepartmentID
where e.Salary = (
	select min(Salary) 
	from employees e2
	where e2.DepartmentID = e.DepartmentID and e2.JobTitle = e.JobTitle)
order by d.Name, e.JobTitle;

select t.salary, t.jobtitle, d.name
from
(select avg(e.salary) salary, e.departmentid, e.JobTitle
from employees e
group by e.departmentid, e.JobTitle) t
join departments d on d.departmentid = t.departmentid;

-- 17
select tt.name, sortedtable.EmployeesCount
from
(
	select t.townid, count(e.EmployeeID) as EmployeesCount
	from towns t
	join addresses a on a.TownID = t.TownID
	join employees e on e.AddressID = a.AddressID
	group by t.townid
	having EmployeesCount = 
	(
		select max(EmployeesCount)
		from
		(
			select t.townid, count(e.EmployeeID) as EmployeesCount
			from towns t
			join addresses a on a.TownID = t.TownID
			join employees e on e.AddressID = a.AddressID
			group by t.townid
		) as maxtable
	) 
) as sortedtable
join towns tt on tt.townid = sortedtable.townid;

-- 18
select t.Name, count(e.EmployeeID) ManagersCount
from employees e
join addresses a on a.AddressID = e.EmployeeID
join towns t on t.TownID = a.TownID
where e.EmployeeID in (select distinct ManagerID from employees where ManagerID is not null)
group by t.Name;

-- 19
create table Users (
	UserID int primary key auto_increment,
	Username varchar(50) unique,
	Password varchar(50),
	FullName varchar(50),
	LastLoginTime timestamp,
	check(length(Password) > 4)
);

-- 20
insert into Users (Username, Password, FullName, LastLoginTime)
select
	concat(lower(substr(e.FirstName, 1, 3)), lower(e.LastName)) as Username,
	concat(lower(e.FirstName), lower(e.LastName)) as Password,
	concat(e.FirstName, ' ', e.LastName) as FullName,
	e.HireDate
from employees e;

-- 21
update Users
set Password = null
where year(LastLoginTime) < 2000;

-- 22
delete from Users
where Password is null;

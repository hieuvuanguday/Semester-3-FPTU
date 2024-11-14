CREATE DATABASE LAB4_SE1707
USE LAB4_SE1707

CREATE TABLE Worker(
	WORKER_ID char(3) Primary Key not null,
	FIRST_NAME nvarchar(20),
	LAST_NAME nvarchar(20),
	SALARY float(7),
	JOINING_DATE Datetime2(0),
	DEPARTMENT nvarchar(10),
)

INSERT INTO Worker 
	VALUES('001', N'Monika', N'Arora', '100000', '2014-02-20 09:00:00', N'HR')
INSERT INTO Worker 	
	VALUES('002', N'Niharika', N'Verma', '80000', '2014-06-11 09:00:00', N'Admin')
INSERT INTO Worker 	
	VALUES('003', N'Vishal', N'Singhal', '300000', '2014-02-20 09:00:00', N'HR')
INSERT INTO Worker 	
	VALUES('004', N'Amitabh', N'Singh', '500000', '2014-02-20 09:00:00', N'Admin')
INSERT INTO Worker 	
	VALUES('005', N'Vivek', N'Bhati', '500000', '2014-06-11 09:00:00', N'Admin')
INSERT INTO Worker 	
	VALUES('006', N'Vipul', N'Diwan', '200000', '2014-06-11 09:00:00', N'Account')
INSERT INTO Worker 	
	VALUES('007', N'Satish', N'Kumar', '75000', '2014-01-20 09:00:00', N'Account')
INSERT INTO Worker 	
	VALUES('008', N'Geetika', N'Chauhan', '90000', '2014-04-11 09:00:00', N'Admin')
	
CREATE TABLE Bonus(
	WORKER_REF_ID char(3),
	BONUS_DATE Datetime2(0),
	BONUS_AMOUNT float(7),
)

INSERT INTO Bonus
	VALUES('001', '2016-02-20 00:00:00', '5000')
INSERT INTO Bonus
	VALUES('002', '2016-06-11 00:00:00', '3000')
INSERT INTO Bonus
	VALUES('003', '2016-02-20 00:00:00', '4000')
INSERT INTO Bonus
	VALUES('001', '2016-02-20 00:00:00', '4500')
INSERT INTO Bonus
	VALUES('002', '2016-06-11 00:00:00', '3500')

ALTER TABLE Bonus
	ADD Constraint PK_Bonus_WORKER_REF_ID_WorkerWORKER_ID
		Foreign Key (WORKER_REF_ID) References Worker(WORKER_ID)
		
CREATE TABLE Title(
	WORKER_REF_ID char(3) Primary Key,
	WORKER_TITLE nvarchar(20),
	AFFECTED_FROM Datetime2(0),
)

INSERT INTO Title
	VALUES('001', 'Manager', '2016-02-20 00:00:00')
INSERT INTO Title
	VALUES('002', 'Executive', '2016-06-11 00:00:00')
INSERT INTO Title
	VALUES('008', 'Executive', '2016-06-11 00:00:00')
INSERT INTO Title
	VALUES('005', 'Manager', '2016-06-11 00:00:00')
INSERT INTO Title
	VALUES('004', 'Asst. Manager', '2016-06-11 00:00:00')
INSERT INTO Title
	VALUES('007', 'Executive', '2016-06-11 00:00:00')
INSERT INTO Title
	VALUES('006', 'Lead', '2016-06-11 00:00:00')
INSERT INTO Title
	VALUES('003', 'Lead', '2016-06-11 00:00:00')

ALTER TABLE Title
	ADD Constraint PK_Title_WORKER_REF_ID_WorkerWORKER_ID
		Foreign Key (WORKER_REF_ID) References Worker(WORKER_ID)

--Q-1. Write an SQL query to fetch “FIRST_NAME” from Worker table using the alias name as <WORKER_NAME>.
SELECT FIRST_NAME AS WORKER_NAME
	FROM Worker;

--Q-2. Write an SQL query to fetch “FIRST_NAME” from Worker table in upper case.
SELECT UPPER(FIRST_NAME) AS FIRST_NAME_UPPERCASE
	FROM Worker;

--Q-3. Write an SQL query to fetch unique values of DEPARTMENT from Worker table.
SELECT DISTINCT DEPARTMENT
	FROM Worker;

--Q-4. Write an SQL query to find the position of the alphabet (‘a’) in the first name column ‘Amitabh’ from Worker table.
SELECT CHARINDEX('a', FIRST_NAME) AS Position
	FROM Worker
		WHERE FIRST_NAME = 'Amitabh';

--Q-5. Write an SQL query to print the FIRST_NAME from Worker table after removing white spaces from the right side.
SELECT RTRIM(FIRST_NAME) AS FIRST_NAME_TRIMMED
	FROM Worker;

--Q-6. Write an SQL query that fetches the unique values of DEPARTMENT from Worker table and prints its length.
SELECT DISTINCT DEPARTMENT, LEN(DEPARTMENT) AS DEPARTMENT_LENGTH
	FROM Worker;

--Q-7. Write an SQL query to print all Worker details from the Worker table order by FIRST_NAME Ascending and DEPARTMENT Descending.
SELECT w.WORKER_ID, w.FIRST_NAME, w.LAST_NAME, w.SALARY, w.JOINING_DATE, w.DEPARTMENT,
  MAX(b.BONUS_DATE) AS BONUS_DATE,
  SUM(b.BONUS_AMOUNT) AS BONUS_AMOUNT,
  MAX(t.WORKER_TITLE) AS WORKER_TITLE,
  MAX(t.AFFECTED_FROM) AS AFFECTED_FROM
FROM Worker w
LEFT JOIN Bonus b ON w.WORKER_ID = b.WORKER_REF_ID
LEFT JOIN Title t ON w.WORKER_ID = t.WORKER_REF_ID
GROUP BY w.WORKER_ID, w.FIRST_NAME, w.LAST_NAME, w.SALARY, w.JOINING_DATE, w.DEPARTMENT
ORDER BY w.FIRST_NAME ASC, w.DEPARTMENT DESC;

--Q-8. Write an SQL query to print details for Workers with the first name as “Vipul” and “Satish” from Worker table.
SELECT w.WORKER_ID, w.FIRST_NAME, w.LAST_NAME, w.SALARY, w.JOINING_DATE, w.DEPARTMENT,
  MAX(b.BONUS_DATE) AS BONUS_DATE,
  SUM(b.BONUS_AMOUNT) AS BONUS_AMOUNT,
  MAX(t.WORKER_TITLE) AS WORKER_TITLE,
  MAX(t.AFFECTED_FROM) AS AFFECTED_FROM
FROM Worker w
LEFT JOIN Bonus b ON w.WORKER_ID = b.WORKER_REF_ID
LEFT JOIN Title t ON w.WORKER_ID = t.WORKER_REF_ID
WHERE w.FIRST_NAME IN ('Vipul', 'Satish')
GROUP BY w.WORKER_ID, w.FIRST_NAME, w.LAST_NAME, w.SALARY, w.JOINING_DATE, w.DEPARTMENT;

--Q-9. Write an SQL query to print details of Workers with DEPARTMENT name as “Admin”.
SELECT w.WORKER_ID, w.FIRST_NAME, w.LAST_NAME, w.SALARY, w.JOINING_DATE, w.DEPARTMENT,
  MAX(b.BONUS_DATE) AS BONUS_DATE,
  SUM(b.BONUS_AMOUNT) AS BONUS_AMOUNT,
  MAX(t.WORKER_TITLE) AS WORKER_TITLE,
  MAX(t.AFFECTED_FROM) AS AFFECTED_FROM
FROM Worker w
LEFT JOIN Bonus b ON w.WORKER_ID = b.WORKER_REF_ID
LEFT JOIN Title t ON w.WORKER_ID = t.WORKER_REF_ID
WHERE w.DEPARTMENT = 'Admin'
GROUP BY w.WORKER_ID, w.FIRST_NAME, w.LAST_NAME, w.SALARY, w.JOINING_DATE, w.DEPARTMENT;

--Q-10. Write an SQL query to print details of the Workers whose FIRST_NAME contains ‘a’.
SELECT w.WORKER_ID, w.FIRST_NAME, w.LAST_NAME, w.SALARY, w.JOINING_DATE, w.DEPARTMENT,
  MAX(b.BONUS_DATE) AS BONUS_DATE,
  SUM(b.BONUS_AMOUNT) AS BONUS_AMOUNT,
  MAX(t.WORKER_TITLE) AS WORKER_TITLE,
  MAX(t.AFFECTED_FROM) AS AFFECTED_FROM
FROM Worker w
LEFT JOIN Bonus b ON w.WORKER_ID = b.WORKER_REF_ID
LEFT JOIN Title t ON w.WORKER_ID = t.WORKER_REF_ID
WHERE w.FIRST_NAME LIKE '%a%'
GROUP BY w.WORKER_ID, w.FIRST_NAME, w.LAST_NAME, w.SALARY, w.JOINING_DATE, w.DEPARTMENT;

















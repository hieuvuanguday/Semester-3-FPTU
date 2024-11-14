CREATE TABLE tblStudents(
	stid NCHAR(7) PRIMARY KEY,
	name NVARCHAR(25),
	birthday DATE,
	phone NVARCHAR(15)
)

CREATE TABLE tblSubjects(
	subid NCHAR(6) PRIMARY KEY,
	subname NVARCHAR(50),
	unit INT
)

CREATE TABLE Result(
	score01 FLOAT,
	score02 FLOAT,
	stid NCHAR(7) FOREIGN KEY REFERENCES dbo.tblStudents(stid),
	subid NCHAR(6) FOREIGN KEY REFERENCES dbo.tblSubjects(subid),
	PRIMARY KEY(stid, subid)
)
CREATE DATABASE DBI202_LAB3
USE DBI202_LAB3

--1. Write a SQL statement to create a table product including columns pro_id, pro_name, pro_price.

CREATE TABLE PRODUCT(
	pro_id char(8) Primary Key,
	pro_name nvarchar(30),
	pro_price float(10),
	cate_id char(8),
)
--2. Write a SQL statement to create a table category including columns cate_id, cate_name.

CREATE TABLE CATEGORY(
	cate_id char(8) Primary Key,
	cate_name nvarchar(30),
)

--4. Using SQL statement to insert 7 rows for every table.
INSERT INTO PRODUCT
	VALUES ('P001', N'Máy Giặt', '700000', 'C001')
INSERT INTO PRODUCT
	VALUES ('P002', N'Máy Sấy', '1000000', 'C001')
INSERT INTO PRODUCT
	VALUES ('P003', N'Điều Hòa', '500000', 'C002')
INSERT INTO PRODUCT
	VALUES ('P004', N'Quạt Điện', '700000', 'C002')
INSERT INTO PRODUCT
	VALUES ('P005', N'Máy Rửa Chén', '450000', 'C003')
INSERT INTO PRODUCT
	VALUES ('P006', N'Máy Sấy Chén', '700000', 'C003')
INSERT INTO PRODUCT
	VALUES ('P007', N'Ti Vi', '690000', 'C004')


INSERT INTO CATEGORY
	VALUES ('C001', N'Dụng Cụ Giặt Đồ')
INSERT INTO CATEGORY
	VALUES ('C002', N'Dụng Cụ Làm Mát')
INSERT INTO CATEGORY
	VALUES ('C003', N'Dụng Cụ Làm Bếp')
INSERT INTO CATEGORY
	VALUES ('C004', N'Dụng Cụ Giải Trí')
INSERT INTO CATEGORY
	VALUES ('C005', N'Dụng Cụ Làm Vườn')
INSERT INTO CATEGORY
	VALUES ('C006', N'Dụng Cụ Sửa Chữa')
INSERT INTO CATEGORY
	VALUES ('C007', N'Dụng Cụ Làm Đẹp')
--3. Implementation a relationship between product table and category.
ALter TABLE PRODUCT
	add Constraint PK_PRODUCT_cateID__CategoryID
		Foreign Key (cate_id) References CATEGORY(cate_id)

--5. Using SQL statement to select all product that the price is 700.000$

SELECT * FROM PRODUCT
	WHERE pro_price = 700000;
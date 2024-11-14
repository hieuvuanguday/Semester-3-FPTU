CREATE DATABASE BOOK_MANAGEMENT
USE BOOK_MANAGEMENT

--CREATE NEW TABLES
CREATE TABLE Book_Publisher(
	PublisherID CHAR(6) PRIMARY KEY,
	PublisherName NVARCHAR(50) NOT NULL UNIQUE,
)

CREATE TABLE Book_Author(
	AuthorID CHAR(5) PRIMARY KEY,
	AuthorName NVARCHAR(50) NOT NULL UNIQUE,
)

CREATE TABLE Book_Shelf(
	ShelfID CHAR(1) PRIMARY KEY,
	ShelfName NVARCHAR(50) NOT NULL UNIQUE,
)

CREATE TABLE Book_Type(
	TypeID CHAR(3) PRIMARY KEY,
	TypeName NVARCHAR(50) NOT NULL UNIQUE,
)

CREATE TABLE Student_Major(
	MajorID CHAR(2) PRIMARY KEY,
	MajorName NVARCHAR(50) NOT NULL UNIQUE, 
)

CREATE TABLE Book(
	BookID CHAR(4) PRIMARY KEY,
	BookTitle NVARCHAR(50) NOT NULL UNIQUE,
	BookPublisherID CHAR(6),
	BookAuthorID CHAR(5),
	BookPageNum INT CHECK (BookPageNum > 5),
	BookQuantity INT CHECK (BookQuantity > 1), 
	BookPrice FLOAT CHECK (BookPrice > 0),
	DateGetIn DATETIME2(0), 
	BookPlaceID CHAR(1),
	BookTypeID CHAR(3),
)

CREATE TABLE Student(
	StudentID CHAR(4) Primary Key,
	StudentName NVARCHAR(50) NOT NULL UNIQUE,
	DateValue DATETIME2(0),
	StudentMajorID CHAR(2),
	StudentEmail NVARCHAR(255),
	StudentPhoneNum NVARCHAR(20),
)

CREATE TABLE Borrow_Book(
	BorrowID CHAR(5) Primary Key,
	BookID CHAR(4),
	StudentID CHAR(4),
	DateBorrow DATETIME2(0),
	DateMustReturn DATETIME2(0),
	DateReturn NVARCHAR(30),
	BorrowStatus NVARCHAR(10) CHECK (BorrowStatus IN ('Borrowing', 'Returned', 'Overdue'))
)
--INPUT DATA INTO TABLES

--Book_Publisher
INSERT INTO Book_Publisher
	VALUES('PL0001', N'Nhà Xuất Bản Trẻ')
INSERT INTO Book_Publisher
	VALUES('PL0002', N'Nhà Xuất Bản Kim Đồng')
INSERT INTO Book_Publisher
	VALUES('PL0003', N'Nhà Xuất Bản Hội Nhà Văn')
INSERT INTO Book_Publisher
	VALUES('PL0004', N'Nhà Xuất Bản Lao Động')
INSERT INTO Book_Publisher
	VALUES('PL0005', N'Nhà Xuất Bản Phụ Nữ Việt Nam')
INSERT INTO Book_Publisher
	VALUES('PL0006', N'Nhã Nam')
INSERT INTO Book_Publisher
	VALUES('PL0007', N'Đinh Tị Books')
INSERT INTO Book_Publisher
	VALUES('PL0008', N'Đông A')
INSERT INTO Book_Publisher
	VALUES('PL0009', N'Sky Books')

--Book_Author
INSERT INTO Book_Author
	VALUES('A0001', N'Hồ Anh Thái')
INSERT INTO Book_Author
	VALUES('A0002', N'Nguyễn Vĩnh Nguyên')
INSERT INTO Book_Author
	VALUES('A0003', N'Nguyễn Trương Quý')
INSERT INTO Book_Author
	VALUES('A0004', N'Đỗ Bích Thúy')
INSERT INTO Book_Author
	VALUES('A0005', N'Nguyễn Mai Chi')
INSERT INTO Book_Author
	VALUES('A0006', N'Nguyễn Nhật Ánh')
INSERT INTO Book_Author
	VALUES('A0007', N'Trang Hạ')
INSERT INTO Book_Author
	VALUES('A0008', N'Nguyễn Phong Việt')
INSERT INTO Book_Author
	VALUES('A0009', N'Anh Khang')

--Book_Shelf
INSERT INTO Book_Shelf
	VALUES('G', N'Tầng Trệt')
INSERT INTO Book_Shelf
	VALUES('1', N'Tầng Một')
INSERT INTO Book_Shelf
	VALUES('2', N'Tầng Hai')
INSERT INTO Book_Shelf
	VALUES('3', N'Tầng Ba')
INSERT INTO Book_Shelf
	VALUES('4', N'Tầng Bốn')
INSERT INTO Book_Shelf
	VALUES('5', N'Tầng Năm')
INSERT INTO Book_Shelf
	VALUES('6', N'Tầng Sáu')

--Book_Type
INSERT INTO Book_Type
	VALUES('LAW', N'Sách Pháp Luật')
INSERT INTO Book_Type
	VALUES('SCI', N'Sách Khoa Học')
INSERT INTO Book_Type
	VALUES('ECN', N'Sách Kinh Tế')
INSERT INTO Book_Type
	VALUES('GDS', N'Sách Thiết Kế Mỹ Thuật Số')
INSERT INTO Book_Type
	VALUES('AIT', N'Sách Trí Tuệ Nhân Tạo')
INSERT INTO Book_Type
	VALUES('SEN', N'Sách Kỹ Thuật Phầm Mềm')
INSERT INTO Book_Type
	VALUES('MKT', N'Sách Marketing')
INSERT INTO Book_Type
	VALUES('MTM', N'Sách Truyền Thông Đa Phương Tiện')
INSERT INTO Book_Type
	VALUES('JPD', N'Sách Tiếng Nhật')
INSERT INTO Book_Type
	VALUES('IT', N'Sách Công Nghệ Thông Tin')

--Student_Major
INSERT INTO Student_Major
	VALUES('GD', N'Thiết Kế Mỹ Thuật Số')
INSERT INTO Student_Major
	VALUES('SE', N'Kỹ Thuật Phần Mềm')
INSERT INTO Student_Major
	VALUES('BI', N'Kinh Doanh Quốc Tế')
INSERT INTO Student_Major
	VALUES('MK', N'Marketing')
INSERT INTO Student_Major
	VALUES('SS', N'Kinh Tế')
INSERT INTO Student_Major
	VALUES('SA', N'Ngôn Ngữ')
INSERT INTO Student_Major
	VALUES('AI', N'Trí Tuệ Nhân Tạo')
INSERT INTO Student_Major
	VALUES('IA', N'An Ninh Mạng')
INSERT INTO Student_Major
	VALUES('IT', N'Công Nghệ Thông Tin')


--Book
INSERT INTO Book
	VALUES('B001', N'Cõi Người Rung Chuông Tận Thế', 'PL0001', 'A0001', '54', '4', '54000', '2015-01-09 21:26:40', 'G', 'MTM')
INSERT INTO Book
	VALUES('B002', N'Tờ Khai Visa', 'PL0003', 'A0001', '102', '5', '89000', '2018-02-18 19:35:45', '4', 'LAW')
INSERT INTO Book
	VALUES('B003', N'Đà Lạt Một Thời Hương Xa', 'PL0008', 'A0002', '25', '6', '45000', '2017-05-09 22:10:00', '2', 'AIT')
INSERT INTO Book
	VALUES('B004', N'Còn Ai Hát Về Hà Nội', 'PL0004', 'A0003', '78', '2', '102000', '2019-07-14 09:26:20', '1', 'SEN')
INSERT INTO Book
	VALUES('B005', N'Những Tọa Độ Song Song', 'PL0006', 'A0005', '87', '3', '99000', '2021-12-09 04:30:20', '5', 'GDS')
INSERT INTO Book
	VALUES('B006', N'Lặng Yên Dưới Vực Sâu', 'PL0007', 'A0004', '98', '10', '115000', '2014-08-14 19:45:58', '3', 'JPD')
INSERT INTO Book
	VALUES('B007', N'40 Days To Master SQL', 'PL0004', 'A0002', '25', '12', '125000', '2014-05-19 17:41:58', '3', 'MTM')
INSERT INTO Book
	VALUES('B008', N'300 Code Lesson', 'PL0003', 'A0001', '78', '34', '205000', '2014-05-19 17:41:58', '3', 'IT')

--Student
INSERT INTO Student
	VALUES('S001', N'Đỗ Thế Hiếu','2025-08-26 23:59:59', 'SE', N'hieudtse170041@fpt.edu.vn', N'0967475325')
INSERT INTO Student
	VALUES('S002', N'Nguyễn Hoàng Đạt','2025-08-26 23:59:59', 'SE', N'datnhse170330@fpt.edu.vn', N'0966548257')
INSERT INTO Student
	VALUES('S003', N'Đào Hoài Phương','2025-08-28 23:59:59', 'SE', N'phuongdhse170524@fpt.edu.vn', N'0985457216')
INSERT INTO Student
	VALUES('S004', N'Nguyễn Trường Thọ','2025-09-15 23:59:59', 'SE', N'thontse171441@fpt.edu.vn', N'0967456825')
INSERT INTO Student
	VALUES('S005', N'Lê Ngọc Thanh Trúc','2026-08-26 23:59:59', 'GD', N'truclntse184843@fpt.edu.vn', N'0387774541')

INSERT INTO Student
	VALUES('S006', N'Châu Vĩnh Phước','2025-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0381254541')
INSERT INTO Student
	VALUES('S007', N'Nguyễn Tấn Trí','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S008', N'Nguyễn Vắn Triệu Tấn','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S009', N'Trần Ánh Tuyết','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S010', N'Phạm Trung Nguyên','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S011', N'Trịnh Nhật Huy','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S012', N'Lê Tuấn Dũng','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S013', N'Bùi Trọng Nghĩa','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S014', N'Lê Đức Nam','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S015', N'Phạm Hồng Quân','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S016', N'Phạm Quốc Trung','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S017', N'Nguyễn Trường Sinh','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S018', N'Phạm Phú Cường','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S019', N'Phạm Hoàng Minh Khôi','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S020', N'Trần Đăng Dũng','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S021', N'Phan Võ Ngọc Phú','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S022', N'Đào Hoài Phượng','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S023', N'Nguyễn Anh Khoa','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S024', N'Nguyễn Huy Phúc','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S025', N'Lê Như Ngọc','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S026', N'Nguyễn Đỗ Minh Quân','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S027', N'Nguyễn Đỗ Minh Đức','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')
INSERT INTO Student
	VALUES('S028', N'Nguyễn Đỗ Minh Thức','2026-08-26 23:59:59', 'GD', N'test1@fpt.edu.vn', N'0387774541')

--Borrow_Book
INSERT INTO Borrow_Book
	VALUES('BR001', 'B002', 'S001', '2023-01-01 13:00:00', '2023-03-01 13:00:00', '2023-02-05 15:00:02', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR002', 'B001', 'S002', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR003', 'B003', 'S004', '2023-01-21 16:00:00', '2023-03-21 16:00:00', '0000-00-00 00:00:00', N'Borrowing')
INSERT INTO Borrow_Book
	VALUES('BR004', 'B004', 'S005', '2023-01-28 09:00:00', '2023-03-28 09:00:00', '0000-00-00 00:00:00', N'Overdue')
INSERT INTO Borrow_Book
	VALUES('BR005', 'B005', 'S003', '2023-02-18 08:00:00', '2023-05-18 08:00:00', '0000-00-00 00:00:00', N'Borrowing')

INSERT INTO Borrow_Book
	VALUES('BR006', 'B001', 'S006', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR007', 'B001', 'S007', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR008', 'B001', 'S008', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR009', 'B001', 'S009', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR010', 'B001', 'S010', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR011', 'B001', 'S011', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR012', 'B001', 'S012', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR013', 'B001', 'S013', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR014', 'B001', 'S014', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR015', 'B001', 'S015', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR016', 'B001', 'S016', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR017', 'B001', 'S017', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR018', 'B001', 'S018', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR019', 'B001', 'S019', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR020', 'B001', 'S020', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR021', 'B001', 'S021', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR022', 'B001', 'S022', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR023', 'B001', 'S023', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR024', 'B001', 'S024', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR025', 'B001', 'S025', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')
INSERT INTO Borrow_Book
	VALUES('BR026', 'B001', 'S026', '2023-01-12 18:00:00', '2023-03-12 18:00:00', '2023-03-16 11:07:28', N'Returned')

--Set relationship for tables
ALTER TABLE Book
	ADD Constraint FK_Book_BookPublisherID_Book_PublisherPublisherID
		Foreign Key (BookPublisherID) References Book_Publisher(PublisherID)

ALTER TABLE Book
	ADD Constraint FK_Book_BookAuthorID_Book_AuthorAuthorID
		Foreign Key (BookAuthorID) References Book_Author(AuthorID)

ALTER TABLE Book
	ADD Constraint FK_Book_BookPlaceID_Book_ShelfShelfID
		Foreign Key (BookPlaceID) References Book_Shelf(ShelfID)

ALTER TABLE Book
	ADD Constraint FK_Book_BookTypeID_Book_TypeTypeID
		Foreign Key (BookTypeID) References Book_Type(TypeID)

ALTER TABLE Student
	ADD Constraint FK_Student_StudentMajorID_Student_MajorMajorID
		Foreign Key (StudentMajorID) References Student_Major(MajorID)

ALTER TABLE Borrow_Book
	ADD Constraint FK_Borrow_Book_BookID_BookBookID
		Foreign Key (BookID) References Book(BookID)

ALTER TABLE Borrow_Book
	ADD Constraint FK_Borrow_Book_StudentID_StudentStudentID
		Foreign Key (StudentID) References Student(StudentID)

--6.1 Liệt kê tất cả thông tin của các đầu sách gồm tên sách, mã sách, giá tiền , tác giả thuộc loại sách có mã “IT”.
SELECT b.BookID, b.BookTitle, b.BookPrice, a.AuthorName, b.BookTypeID  
FROM Book b
LEFT JOIN Book_Author a ON b.BookAuthorID = a.AuthorID
WHERE b.BookTypeID = 'IT';

--6.2 Liệt kê các phiếu mượn gồm các thông tin mã phiếu mượn, mã sách , ngày mượn, mã sinh viên có ngày mượn trong tháng 01/2023.
SELECT BorrowID, BookID, StudentID, DateBorrow
FROM Borrow_Book
WHERE DateBorrow >= '2023-01-01 00:00:00' AND DateBorrow < '2023-02-01 23:59:59'

--6.3 Liệt kê các phiếu mượn chưa trả sách cho thư viện theo thứ tự tăng dần của ngày mượn sách.
SELECT * FROM Borrow_Book
WHERE BorrowStatus = 'Borrowing'
ORDER BY DateBorrow ASC

--6.4 Liệt kê tổng số đầu sách của mỗi loại sách ( gồm mã loại sách, tên loại sách, tổng số lượng sách mỗi loại).
SELECT t.TypeID, t.TypeName, ISNULL(SUM(b.BookQuantity), 0) AS TotalQuantity
FROM Book_Type t
LEFT JOIN Book b ON t.TypeID = b.BookTypeID
GROUP BY t.TypeID, t.TypeName

--6.5 Đếm xem có bao nhiêu lượt sinh viên đã mượn sách.
SELECT COUNT(*) AS BorrowCount FROM Borrow_Book

--6.6 Hiển thị tất cả các quyển sách có tiêu đề chứa từ khoá “SQL”.
SELECT b.*, p.PublisherName, a.AuthorName, s.ShelfName, t.TypeName FROM Book b
LEFT JOIN Book_Publisher p ON b.BookPublisherID = p.PublisherID
LEFT JOIN Book_Author a ON b.BookAuthorID = a.AuthorID
LEFT JOIN Book_Shelf s ON b.BookPlaceID = s.ShelfID
LEFT JOIN Book_Type t ON b.BookTypeID = t.TypeID
WHERE BookTitle LIKE '%SQL%'

--6.7 Hiển thị thông tin mượn sách gồm các thông tin: mã sinh viên, tên sinh viên, mã phiếu mượn, tiêu đề sách, ngày mượn, ngày trả. Sắp xếp thứ tự theo ngày mượn sách.
SELECT br.StudentID, s.StudentName, br.BorrowID, b.BookTitle, br.DateBorrow, br.DateReturn FROM Borrow_Book br
LEFT JOIN Student s ON br.StudentID = s.StudentID
LEFT JOIN Book b ON br.BookID = b.BookID
ORDER BY br.DateBorrow ASC

--6.8 Liệt kê các đầu sách có lượt mượn lớn hơn 20 lần.
SELECT b.*, p.PublisherName, a.AuthorName, s.ShelfName, t.TypeName FROM Book b
LEFT JOIN Book_Publisher p ON b.BookPublisherID = p.PublisherID
LEFT JOIN Book_Author a ON b.BookAuthorID = a.AuthorID
LEFT JOIN Book_Shelf s ON b.BookPlaceID = s.ShelfID
LEFT JOIN Book_Type t ON b.BookTypeID = t.TypeID
WHERE b.BookID in (SELECT bf.BookID FROM (SELECT b.BookID, COUNT(*) AS BorrowTurn FROM Borrow_Book b GROUP BY b.BookID) bf WHERE bf.BorrowTurn > 20)

--6.9 Viết câu lệnh cập nhật lại giá tiền của các quyển sách có ngày nhập kho trước năm 2014 giảm 30%.
UPDATE Book 
SET 
	BookPrice = BookPrice*(0.7)
WHERE Year(DateGetIn) < 2014

--6.10 Viết câu lệnh cập nhật lại trạng thái đã trả sách cho phiếu mượn của sinh viên có mã sinh viên PD12301 (ví dụ).
UPDATE Borrow_Book
SET
	BorrowStatus = 'Returned'
WHERE StudentID = 'S004'

--6.11 Lập danh sách các phiếu mượn quá hạn chưa trả gồm các thông tin: mã phiếu mượn, tên sinh viên, email, danh sách các sách đã mượn, ngày mượn.
SELECT br.BorrowID, s.StudentName, s.StudentEmail, br.BookID, br.DateBorrow FROM Borrow_Book br
LEFT JOIN Student s ON s.StudentID = br.StudentID
WHERE BorrowStatus = 'Overdue'
ORDER BY br.StudentID ASC

--6.12 Viết câu lệnh cập nhật lại số lượng bản sao tăng lên 5 đơn vị đối với các đầu sách có lượt mượn lớn hơn 10
UPDATE Book 
SET
	BookQuantity = BookQuantity + 5
WHERE BookID in (SELECT bf.BookID FROM (SELECT br.BookID, COUNT(*) AS BorrowTurn FROM Borrow_Book br GROUP BY br.BookID) AS bf
					WHERE bf.BorrowTurn > 10)

--6.13 Viết câu lệnh xoá các phiếu mượn có ngày mượn và ngày trả trước ‘1/1/2023’
DELETE FROM Borrow_Book
WHERE DateBorrow < '2023-01-01 00:00:00' AND DateReturn < '2023-01-01 00:00:00'

--6.14. Tạo một Trigger cập nhật số lượng sách khi có sinh viên mượn hoặc trả sách
GO
CREATE TRIGGER TR_Update_Quantity_Book ON Borrow_Book
	AFTER INSERT, UPDATE, DELETE
	AS
		BEGIN
			UPDATE Book
				SET BookQuantity = BookQuantity - 1
				FROM Book b
				JOIN inserted ON b.BookID = inserted.BookID
				WHERE b.BookID = inserted.BookID
					AND (inserted.BorrowStatus = 'Borrowing' OR inserted.BorrowStatus = 'Overdue')
			UPDATE Book
				SET BookQuantity = BookQuantity + 1
				FROM Book b
				JOIN deleted ON b.BookID = deleted.BookID
				WHERE b.BookID = deleted.BookID
					AND (deleted.BorrowStatus = 'Borrowing' OR deleted.BorrowStatus = 'Overdue')
		END
GO

--Show All Table
SELECT * FROM Book_Publisher
SELECT * FROM Book_Author
SELECT * FROM Book_Shelf
SELECT * FROM Book_Type
SELECT * FROM Book
SELECT * FROM Student
SELECT * FROM Borrow_Book
SELECT * FROM Student_Major




























CREATE DATABASE QuanLySinhVien
GO

USE QuanLySinhVien
GO

CREATE TABLE tbl_Role 
(
	id INT IDENTITY PRIMARY KEY,
	Name NVARCHAR(100),
)
GO

CREATE TABLE tbl_Teacher
(
	id INT IDENTITY PRIMARY KEY,
	Name NVARCHAR(100),
	Phone NVARCHAR(10),
	Email NVARCHAR(100),
	Password NVARCHAR(1000),
	Address NVARCHAR(1000),
	Birthday DATE,
	Status TINYINT ,
	Role_ID INT FOREIGN KEY REFERENCES dbo.tbl_Role(id)
)
GO

CREATE TABLE tbl_KhoaHoc
(
	id INT IDENTITY PRIMARY KEY,
	Name NVARCHAR(100),
	Begin_date DATE,
	End_data DATE,
)
GO

CREATE TABLE tbl_Class
(
	id INT PRIMARY KEY  IDENTITY,
	Name NVARCHAR(100),
	KhoaHoc_ID INT FOREIGN KEY REFERENCES dbo.tbl_KhoaHoc(id),
	GiaoVien_ID INT FOREIGN KEY REFERENCES dbo.tbl_Teacher(id)
)
GO

CREATE TABLE tbl_Students
(
	id INT IDENTITY PRIMARY KEY,
	MaSV NVARCHAR(4) UNIQUE,
	Name NVARCHAR(100),
	Phone NVARCHAR(10),
	Email NVARCHAR(100),
	Address NVARCHAR(1000),
	Birthday DATE ,
	Gender TINYINT DEFAULT(0),
	Status TINYINT DEFAULT(0),
	Class_ID INT FOREIGN KEY REFERENCES dbo.tbl_Class(id)
)
GO

CREATE TABLE tbl_Subject
(
	id INT IDENTITY PRIMARY KEY,
	Name NVARCHAR(100),
	credits int default(2),
	Status TINYINT,
)
GO

CREATE TABLE tbl_Mark 
(
	Student_ID INT FOREIGN KEY REFERENCES dbo.tbl_Students(id),
	MonHoc_ID INT FOREIGN KEY REFERENCES dbo.tbl_Subject(id),
	Diem INT,
	Ex_Date date default(GetDate()) not null,
	Status TINYINT,
	Note NVARCHAR(1000),
	primary key (Student_ID,MonHoc_ID, Ex_Date)
)
GO

INSERT INTO dbo.tbl_KhoaHoc
(
    Name,
    Begin_date,
    End_data
)
VALUES
(   N'Lập trình',2020-01-12,2020-01-12),
(   N'Quản trị viên',2020-02-12,2020-01-12)
GO

insert into tbl_Role values
(N'Hiệu trưởng'),
(N'Phó hiệu trưởng'),
(N'Giảng viên'),
(N'Giảng viên thực tập')
GO

SELECT * FROM dbo.tbl_KhoaHoc
GO

CREATE PROC getAllRole
AS
	
BEGIN
    SELECT * FROM dbo.tbl_Role
END
GO

EXEC getAllRole;
GO

insert into tbl_Subject(Name,credits,Status) values
(N'Kinh Tế Vĩ Mô',2,1),
(N'Kinh tế phát triển',2,1),
(N'Kinh tế môi trường',2,1),
(N'Lịch sử các học thuyết kinh tế',2,1),
(N'Toán cao cấp',2,1),
(N'Triết học Mác Lênin',2,1),
(N'Tư tưởng Hồ Chí Minh',2,1),
(N'Quan hệ kinh tế quốc tế',2,1),
(N'Nguyên lý thống kê kinh tế',2,1),
(N'Giao nhận vận tải',2,1),
(N'Tin học đại cương',2,1),
(N'Tiếng Anh giao tiếp',2,1)
GO

INSERT INTO dbo.tbl_Teacher
(
    Name,
    Phone,
    Email,
    Password,
    Address,
    Birthday,
    Status,
    Role_ID
)
VALUES
(   N'Ngô Văn Thuyết',       -- Name - nvarchar(100)
    N'0973086596',       -- Phone - nvarchar(10)
    N'thuyetnv96@gmail.com',       -- Email - nvarchar(100)
    N'Thuyet123',       -- Password - nvarchar(1000)
    N'Bắc Ninh',       -- Address - nvarchar(1000)
    GETDATE(), -- Birthday - date
    0,         -- Status - tinyint
    1          -- Role_ID - int
    )

GO

CREATE PROC getAllAccount
AS
BEGIN 
	SELECT tbl_Teacher.id,tbl_Teacher.Name,dbo.tbl_Role.id 'RoleId',tbl_Role.Name 'RoleName',Phone,Email,Password,Address,Birthday,Status FROM dbo.tbl_Teacher INNER JOIN dbo.tbl_Role ON tbl_Role.id = tbl_Teacher.id
END
GO

SELECT * FROM dbo.tbl_Role

DROP PROC dbo.getAllAccount
GO

EXEC dbo.getAllAccount
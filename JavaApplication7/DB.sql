

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
	SELECT tbl_Teacher.id,tbl_Teacher.Name,dbo.tbl_Role.id 'RoleId',tbl_Role.Name 'RoleName',Phone,Email,Password,Address,Birthday,Status FROM dbo.tbl_Teacher INNER JOIN dbo.tbl_Role ON tbl_Role.id = tbl_Teacher.Role_ID
END
GO

EXEC dbo.getAllAccount
GO

CREATE PROC insertAccount
	@Name NVARCHAR(100),
	@Phone NVARCHAR(10),
	@Email NVARCHAR(100),
	@Password NVARCHAR(1000),
	@Address NVARCHAR(1000),
	@Birthday DATE,
	@Status TINYINT ,
	@Role_ID INT 
AS
BEGIN
    INSERT INTO dbo.tbl_Teacher(Name,Phone,Email,Password,Address,Birthday,Status,Role_ID)VALUES(@Name,@Phone,@Email,@Password,@Address,@Birthday,@Status,@Role_ID)
END

GO

CREATE PROC deleteAccount
@id INT
AS
BEGIN
    DELETE FROM dbo.tbl_Teacher WHERE id = @id
END
GO

CREATE PROC findAccount
@name NVARCHAR(100)
AS
BEGIN
	SELECT tbl_Teacher.id,tbl_Teacher.Name,dbo.tbl_Role.id 'RoleId',tbl_Role.Name 'RoleName',Phone,Email,Password,Address,Birthday,Status FROM dbo.tbl_Teacher INNER JOIN dbo.tbl_Role ON tbl_Role.id = tbl_Teacher.Role_ID
	WHERE tbl_Teacher.Name LIKE N'name'
	
END
GO


EXEC dbo.findAccount @name = 0 -- int



CREATE PROC updateAccount
	@id INT,
	@Name NVARCHAR(100),
	@Phone NVARCHAR(10),
	@Email NVARCHAR(100),
	@Password NVARCHAR(1000),
	@Address NVARCHAR(1000),
	@Birthday DATE,
	@Status TINYINT,
	@Role_ID INT 
AS
BEGIN
    UPDATE dbo.tbl_Teacher SET Name = @Name,Phone=@Phone,Email=@Email,Password=@Password,Address=@Address,Birthday=@Birthday,Status=@Status,Role_ID=@Role_ID WHERE id = @id
END
GO



CREATE PROC getAllStudent
AS
BEGIN
    SELECT *,tbl_Class.Name'ClassName' FROM dbo.tbl_Students LEFT JOIN dbo.tbl_Class ON tbl_Class.id = tbl_Students.Class_ID ORDER BY MaSV ASC
END
GO

EXEC dbo.getAllStudent

CREATE PROC insertStudent
	@MaSV NVARCHAR(4),
	@Name NVARCHAR(100),
	@Phone NVARCHAR(10),
	@Email NVARCHAR(100),
	@Address NVARCHAR(1000),
	@Birthday DATE ,
	@Gender TINYINT,
	@Status TINYINT,
	@Class_ID INT
AS
BEGIN
	INSERT INTO tbl_Students(MaSV,Name,Phone,Email,Address,Birthday,Gender,Status,Class_ID) VALUES (@MaSV,@Name,@Phone,@Email,@Address,@Birthday,@Gender,@Status,@Class_ID) 
END
GO

CREATE PROC deleteStudent
@id INT
AS
BEGIN
	DELETE FROM dbo.tbl_Students WHERE id = @id
END
GO

CREATE PROC getAllSubject
AS
BEGIN
	SELECT * FROM dbo.tbl_Subject
END
GO

CREATE PROC insertSubject
@Name NVARCHAR(100),
@credits INT,
@Status
 TINYINT
AS
BEGIN
    INSERT INTO tbl_Subject(Name,credits,Status) VALUES (@Name,@credits,@Status)
END
GO



EXEC getAllStudent

SELECT * FROM dbo.tbl_Class

insert into tbl_KhoaHoc(Name,Begin_date,End_data) values
(N'Lập trình','2019-05-09','2020-05-25'),
(N'Quản trị mạng','2018-09-05','2021-05-25'),
(N'Tiếng Anh','2018-09-05','2022-05-25'),
(N'PHP','2019-09-05','2023-05-25'),
(N'Java','2020-09-05','2024-05-25')
GO

insert into tbl_Class(Name,KhoaHoc_ID,GiaoVien_ID) values
(N'C1905M',1,5),
(N'C1902J',1,5),
(N'C1903A',1,5),
(N'C1709M',1,3),
(N'C1803F',1,3),
(N'C1605K',1,3),
(N'C1900M',1,3)
GO

insert into tbl_Students(MaSV,Name,Phone,Email,Address,Birthday,Gender,Status,Class_ID) values
('B001',N'Trịnh Việt Thái','0973086596','zxczxc@gmail.com',N'Phạm Văn Đồng, Bắc Từ Liêm, Hà Nội','1996-01-09',0,1,5),
('B002',N'Ngô Thị Duyên','097654123','asdasd@gmail.com',N'Lạc Long Quân, Bắc Từ Liêm, Hà Nội','1995-01-27',0,1,2),
('B003',N'Lê Văn Hải','0973086558','zxczxc@gmail.com',N'Phạm Văn Đồng, Bắc Từ Liêm, Hà Nội','1994-01-28',1,1,3),
('B004',N'Trịnh Văn Mạnh','0973086528 ','qeqwe@gmail.com',N'Âu Cơ, Bắc Từ Liêm, Hà Nội','1993-02-27',1,1,4)
GO

SELECT * FROM dbo.tbl_Teacher LEFT JOIN dbo.tbl_Role ON tbl_Role.id = tbl_Teacher.Role_ID
EXEC dbo.getAllAccount


GO

SELECT * FROM dbo.tbl_Subject

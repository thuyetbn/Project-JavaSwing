
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
	Status TINYINT DEFAULT(0),
	Note NVARCHAR(1000),
	primary key (Student_ID,MonHoc_ID)
)
GO



ALTER TABLE dbo.tbl_Subject add KhoaHoc_ID INT FOREIGN KEY REFERENCES dbo.tbl_KhoaHoc(id)


INSERT INTO dbo.tbl_KhoaHoc(Name,Begin_date,End_data)
VALUES
(   N'Lập trình','2018-01-12','2020-01-12'),
(   N'Quản trị viên','2012-02-12','2020-01-12')
GO

insert into tbl_Role values
(N'Hiệu trưởng'),
(N'Phó hiệu trưởng'),
(N'Giảng viên'),
(N'Giảng viên thực tập')
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
(N'Java',2,1),
(N'PHP',2,1),
(N'Android',2,1)
GO

INSERT INTO dbo.tbl_Teacher(Name,Phone,Email,Password,Address,Birthday,Status,Role_ID)
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
	WHERE tbl_Teacher.Name LIKE N'%'+@name+N'%'
	
END
GO


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
    SELECT S.*, C.Name 'ClassName',T.id 'TeacherID',T.Name'TeacherName',KH.id'KH_ID',KH.Name'KH_Name' FROM dbo.tbl_Students S
	LEFT JOIN dbo.tbl_Class C ON C.id = S.Class_ID 
	LEFT JOIN dbo.tbl_Teacher T ON T.id = C.GiaoVien_ID
	LEFT JOIN dbo.tbl_KhoaHoc KH ON KH.id = C.KhoaHoc_ID
	ORDER BY MaSV ASC
END
GO

CREATE PROC findStudent
@name NVARCHAR(100)
AS
BEGIN
	SELECT S.*, C.Name 'ClassName',T.id 'TeacherID',T.Name'TeacherName',KH.id'KH_ID',KH.Name'KH_Name' FROM dbo.tbl_Students S
	LEFT JOIN dbo.tbl_Class C ON C.id = S.Class_ID 
	LEFT JOIN dbo.tbl_Teacher T ON T.id = C.GiaoVien_ID
	LEFT JOIN dbo.tbl_KhoaHoc KH ON KH.id = C.KhoaHoc_ID
	WHERE S.Name LIKE N'%'+@name+N'%'
	
END
GO


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

CREATE PROC updateStudent
	@id INT,
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
    UPDATE dbo.tbl_Students SET MaSV=@MaSV,Name=@Name,Phone=@Phone,Email=@Email,Address=@Address,Birthday=@Birthday,Gender=@Gender,Status=@Status,Class_ID=@Class_ID WHERE id =@id
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
	SELECT S.*,KH.id,KH.Name'KH_Name' FROM dbo.tbl_Subject S INNER JOIN dbo.tbl_KhoaHoc KH ON KH.id = S.KhoaHoc_ID
END
GO



CREATE PROC insertSubject
@Name NVARCHAR(100),
@credits INT,
@Status TINYINT,
@KH_ID INT
AS
BEGIN
    INSERT INTO tbl_Subject(Name,credits,Status,KhoaHoc_ID) VALUES (@Name,@credits,@Status,@KH_ID)
END
GO


CREATE PROC updateSubject
@id INT,
@Name NVARCHAR(100),
@credits INT,
@Status TINYINT,
@KH_ID INT
AS
BEGIN
    UPDATE dbo.tbl_Subject SET Name=@Name,credits=@credits,Status=@Status,KhoaHoc_ID=@KH_ID WHERE id = @id
END
GO



CREATE PROC findSubject
@name NVARCHAR(100)
AS
BEGIN
	SELECT S.*,KH.id,KH.Name'KH_Name' FROM dbo.tbl_Subject S INNER JOIN dbo.tbl_KhoaHoc KH ON KH.id = S.KhoaHoc_ID
	WHERE S.Name LIKE N'%'+@name+N'%'
END
GO


CREATE PROC loginForm
@Email NVARCHAR(100),
@Password NVARCHAR(1000)
AS
BEGIN
    SELECT tbl_Teacher.id,tbl_Teacher.Name,dbo.tbl_Role.id 'RoleId',tbl_Role.Name 'RoleName',Phone,Email,Password,Address,Birthday,Status FROM dbo.tbl_Teacher INNER JOIN dbo.tbl_Role ON tbl_Role.id = tbl_Teacher.Role_ID WHERE Email = @Email AND Password = @Password
END
GO

EXEC dbo.getAllAccount


CREATE PROC getAllClass
AS
BEGIN
    SELECT C.*,KH.Name 'KH_Name',T.Name 'Teacher_Name' FROM dbo.tbl_Class C LEFT JOIN dbo.tbl_KhoaHoc KH ON KH.id = C.KhoaHoc_ID
									LEFT JOIN dbo.tbl_Teacher T  ON T.id = C.GiaoVien_ID 
END
GO


GO

CREATE PROC addClassRoom
@Name NVARCHAR(100),
@KhoaHoc_ID INT,
@GiaoVien_ID INT
AS
BEGIN
	INSERT INTO tbl_Class(Name,KhoaHoc_ID,GiaoVien_ID) VALUES (@Name,@KhoaHoc_ID,@GiaoVien_ID)
END
GO

CREATE PROC updateClassRoom
@id INT,
@Name NVARCHAR(100),
@KhoaHoc_ID INT,
@GiaoVien_ID INT
AS
BEGIN
	UPDATE dbo.tbl_Class SET Name=@Name, KhoaHoc_ID=@KhoaHoc_ID, GiaoVien_ID = @GiaoVien_ID WHERE id = @id
END
GO

ALTER PROC getAllMark
AS
BEGIN
	SELECT M.*,s.id'Student_Id',s.Name'Student_Name',s.MaSV'S_MSV',SJ.id'SJ_ID',SJ.Name'SJ_Name' FROM dbo.tbl_Students S 
	LEFT JOIN dbo.tbl_Mark M ON S.id = M.Student_ID
	LEFT JOIN dbo.tbl_Subject SJ ON SJ.id = M.MonHoc_ID
END
GO

EXEC dbo.getAllMark
EXEC dbo.getAllStudent

SELECT M.*,s.id'Student_Id',s.Name'Student_Name',s.MaSV'S_MSV',SJ.id'SJ_ID',SJ.Name'SJ_Name' FROM dbo.tbl_Students S 
LEFT JOIN dbo.tbl_Mark M ON S.id = M.Student_ID
LEFT JOIN dbo.tbl_Subject SJ ON SJ.id = M.MonHoc_ID
GO


ALTER PROC addMark
@Student_ID INT,
@MonHoc_ID INT,
@Diem INT,
@Ex_Date DATE,
@Note NVARCHAR(1000)
AS
BEGIN
    INSERT INTO tbl_Mark(Student_ID,MonHoc_ID,Diem,Ex_Date,Note) VALUES (@Student_ID,@MonHoc_ID,@Diem,@Ex_Date,@Note)
END
GO

EXEC dbo.addMark @Student_ID =3,         -- int
                 @MonHoc_ID = 4,          -- int
                 @Diem = 5,               -- int
                 @Ex_Date = '2020-12-25', -- date
                 @Status = 1,             -- tinyint
                 @Note = N'Trượt'              -- nvarchar(1000)
EXEC getAllMark
GO

SELECT COUNT(*) FROM dbo.tbl_Subject

CREATE PROC findStudentMark
@name NVARCHAR(100)
AS
BEGIN
    SELECT M.*,S.id'Student_Id',S.Name'Student_Name',SJ.id'SJ_ID',SJ.Name'SJ_Name' FROM dbo.tbl_Mark M 
	LEFT JOIN dbo.tbl_Students S ON S.id = M.Student_ID
	LEFT JOIN dbo.tbl_Subject SJ ON SJ.id = M.MonHoc_ID WHERE S.Name LIKE N'%'+@name+N'%'
END
GO

CREATE PROC updateMark
@Student_ID INT,
@MonHoc_ID INT,
@Diem INT,
@Ex_Date DATE,
@Status TINYINT,
@Note TEXT
AS
BEGIN
    UPDATE dbo.tbl_Mark SET MonHoc_ID=@Student_ID,Diem=@Diem,Ex_Date=@Ex_Date,Status=@Status,Note=@Note WHERE Student_ID=@Student_ID AND MonHoc_ID = @MonHoc_ID
END
GO

EXEC getAllMark
GO

CREATE PROC getInfoStudent
@id INT
AS
BEGIN
    SELECT s.*,c.Name'C_Name',t.Name'T_Name',kh.Name'KH_Name',
	kh.Begin_date'KH_begin_date',kh.End_data'KH_end_date',m.Diem'Diem',m.Status'M_Status',sj.Name'SJ_Name'
	FROM dbo.tbl_Students s 
	LEFT JOIN dbo.tbl_Class c ON c.id = s.Class_ID
	LEFT JOIN dbo.tbl_Teacher t ON t.id = c.GiaoVien_ID
	LEFT JOIN dbo.tbl_KhoaHoc kh ON kh.id = c.KhoaHoc_ID
	LEFT JOIN dbo.tbl_Mark m ON  m.Student_ID = s.id
	LEFT JOIN dbo.tbl_Subject sj ON sj.id = m.MonHoc_ID
	WHERE s.id = @id							    
END

EXEC dbo.getAllStudent


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
('B003',N'Trịnh Việt Thái','0973086596','zxczxc@gmail.com',N'Phạm Văn Đồng, Bắc Từ Liêm, Hà Nội','1996-01-09',0,1,5),
('B004',N'Ngô Thị Duyên','097654123','asdasd@gmail.com',N'Lạc Long Quân, Bắc Từ Liêm, Hà Nội','1995-01-27',0,1,2),
('B005',N'Lê Văn Hải','0973086558','zxczxc@gmail.com',N'Phạm Văn Đồng, Bắc Từ Liêm, Hà Nội','1994-01-28',1,1,3),
('B006',N'Trịnh Văn Mạnh','0973086528 ','qeqwe@gmail.com',N'Âu Cơ, Bắc Từ Liêm, Hà Nội','1993-02-27',1,1,4)
GO

EXEC dbo.getAllAccount
GO

SELECT * FROM dbo.tbl_Teacher

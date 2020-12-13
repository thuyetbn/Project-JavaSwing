CREATE DATABASE QuanLySinhVien
GO

USE QuanLySinhVien
GO

CREATE TABLE tbl_SinhVien
(
	id INT IDENTITY PRIMARY KEY,
	MaSV NVARCHAR(5) UNIQUE,
	Name NVARCHAR(100),
	Phone NVARCHAR(10),
	Email NVARCHAR(100),
	Address NVARCHAR(1000),
	Birthday DATE,
	Gender TINYINT,
	Status TINYINT,
	Class_ID INT,
)
GO

CREATE TABLE tbl_Class
(
	id INT PRIMARY KEY  IDENTITY,
	Name NVARCHAR(100),
	KhoaHoc_ID INT,
	GiaoVien_ID INT,
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
CREATE TABLE tbl_Teacher
(
	id INT IDENTITY PRIMARY KEY,
	Name NVARCHAR(100),
	Phone NVARCHAR(10),
	Email NVARCHAR(100),
	Password NVARCHAR(1000),
	Address NVARCHAR(1000),
	Birthday DATE,
	Status TINYINT,
	Role_ID INT,
)
GO

CREATE TABLE tbl_Mark 
(
	Student_ID INT,
	MonHoc_ID INT,
	Diem INT,
	Status TINYINT,
	Note NVARCHAR(1000),
)
GO

CREATE TABLE tbl_Subject
(
	id INT IDENTITY PRIMARY KEY,
	Name NVARCHAR(100),
	Status TINYINT,
)
GO

CREATE TABLE tbl_Role 
(
	id INT IDENTITY PRIMARY KEY,
	Name NVARCHAR(100),
)
GO

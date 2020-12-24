/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BinDz
 */
public class Student {
    private int id;
    private String MaSV;
    private String Name;
    private String Phone;
    private String Email;
    private String Address;
    private String Birthday;
    private int Gender;
    private int Status;
    private int Class_ID;
    private String Class_name;
    private int Teacher_ID;
    private String Teacher_Name;
    private int KH_ID;
    private String KH_Name;
    
    
    
    public Student(int id, String MaSV, String Name, String Phone, String Email, String Address, String Birthday, int Gender, int Status, int Class_ID,String Class_name) {
        this.id = id;
        this.MaSV = MaSV;
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Birthday = Birthday;
        this.Gender = Gender;
        this.Status = Status;
        this.Class_ID = Class_ID;
        this.Class_name = Class_name;
    }

    public Student(int id,String MaSV, String Name, String Phone, String Email, String Address, String Birthday, int Gender, int Status, int Class_ID, String Class_name, int Teacher_ID, String Teacher_Name, int KH_ID, String KH_Name) {
        this.id = id;
        this.MaSV = MaSV;
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Birthday = Birthday;
        this.Gender = Gender;
        this.Status = Status;
        this.Class_ID = Class_ID;
        this.Class_name = Class_name;
        this.Teacher_ID = Teacher_ID;
        this.Teacher_Name = Teacher_Name;
        this.KH_ID = KH_ID;
        this.KH_Name = KH_Name;
    }

    public Student(String MaSV, String Name, String Phone, String Email, String Address, String Birthday, int Gender, int Status, int Class_ID) {
        this.MaSV = MaSV;
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Birthday = Birthday;
        this.Gender = Gender;
        this.Status = Status;
        this.Class_ID = Class_ID;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getClass_ID() {
        return Class_ID;
    }

    public void setClass_ID(int Class_ID) {
        this.Class_ID = Class_ID;
    }

    public String getClass_name() {
        return Class_name;
    }

    public void setClass_name(String Class_name) {
        this.Class_name = Class_name;
    }

    public int getTeacher_ID() {
        return Teacher_ID;
    }

    public void setTeacher_ID(int Teacher_ID) {
        this.Teacher_ID = Teacher_ID;
    }

    public String getTeacher_Name() {
        return Teacher_Name;
    }

    public void setTeacher_Name(String Teacher_Name) {
        this.Teacher_Name = Teacher_Name;
    }

    public int getKH_ID() {
        return KH_ID;
    }

    public void setKH_ID(int KH_ID) {
        this.KH_ID = KH_ID;
    }

    public String getKH_Name() {
        return KH_Name;
    }

    public void setKH_Name(String KH_Name) {
        this.KH_Name = KH_Name;
    }
    

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", MaSV=" + MaSV + ", Name=" + Name + ", Phone=" + Phone + ", Email=" + Email + ", Address=" + Address + ", Birthday=" + Birthday + ", Gender=" + Gender + ", Status=" + Status + ", Class_ID=" + Class_ID + '}';
    }
    
    
}

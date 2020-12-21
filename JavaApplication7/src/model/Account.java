/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model; 

import java.sql.Date;

/**
 *
 * @author BinDz
 */
public class Account {
    private int id;
    private String Name;
    private String Phone;
    private String Email;
    private String Password;
    private String Address;
    private String Birthday;
    private int Status;
    private int Role_ID;
    private String Rolde_Name;

    public Account(int id, String Name, String Phone, String Email, String Password, String Address, String Birthday, int Status, int Role_ID, String Rolde_Name) {
        this.id = id;
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.Birthday = Birthday;
        this.Status = Status;
        this.Role_ID = Role_ID;
        this.Rolde_Name = Rolde_Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getRole_ID() {
        return Role_ID;
    }

    public void setRole_ID(int Role_ID) {
        this.Role_ID = Role_ID;
    }

    public String getRolde_Name() {
        return Rolde_Name;
    }

    public void setRolde_Name(String Rolde_Name) {
        this.Rolde_Name = Rolde_Name;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", Name=" + Name + ", Phone=" + Phone + ", Email=" + Email + ", Password=" + Password + ", Address=" + Address + ", Birthday=" + Birthday + ", Status=" + Status + ", Role_ID=" + Role_ID + ", Rolde_Name=" + Rolde_Name + '}';
    }


    
    
}


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
public class Subject {
    private int id;
    private String Name;
    private int credits;
    private int Status;
    private int KH_ID;
    private String KH_Name;

    public Subject(int id, String Name, int credits, int Status, int KH_ID, String KH_Name) {
        this.id = id;
        this.Name = Name;
        this.credits = credits;
        this.Status = Status;
        this.KH_ID = KH_ID;
        this.KH_Name = KH_Name;
    }

    public Subject(String Name, int credits, int Status, int KH_ID, String KH_Name) {
        this.Name = Name;
        this.credits = credits;
        this.Status = Status;
        this.KH_ID = KH_ID;
        this.KH_Name = KH_Name;
    }

    public Subject(String Name, int credits, int Status, int KH_ID) {
        this.Name = Name;
        this.credits = credits;
        this.Status = Status;
        this.KH_ID = KH_ID;
    }

    public Subject(int id, String Name, int credits, int Status, int KH_ID) {
        this.id = id;
        this.Name = Name;
        this.credits = credits;
        this.Status = Status;
        this.KH_ID = KH_ID;
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

    public int getCredits() {
        return credits;
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

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", Name=" + Name + ", credits=" + credits + ", Status=" + Status + '}';
    }
    
     
}

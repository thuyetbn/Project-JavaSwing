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

    public Subject(int id, String Name, int credits, int Status) {
        this.id = id;
        this.Name = Name;
        this.credits = credits;
        this.Status = Status;
    }

    public Subject(String Name, int credits, int Status) {
        this.Name = Name;
        this.credits = credits;
        this.Status = Status;
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

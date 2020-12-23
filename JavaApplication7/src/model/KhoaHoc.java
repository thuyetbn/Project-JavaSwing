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
public class KhoaHoc {
    int id;
    String Name;
    String Begin_date;
    String End_date;

    public KhoaHoc(int id, String Name, String Begin_date, String End_date) {
        this.id = id;
        this.Name = Name;
        this.Begin_date = Begin_date;
        this.End_date = End_date;
    }

    public KhoaHoc(String Name, String Begin_date, String End_date) {
        this.Name = Name;
        this.Begin_date = Begin_date;
        this.End_date = End_date;
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

    public String getBegin_date() {
        return Begin_date;
    }

    public void setBegin_date(String Begin_date) {
        this.Begin_date = Begin_date;
    }

    public String getEnd_date() {
        return End_date;
    }

    public void setEnd_date(String End_date) {
        this.End_date = End_date;
    }

    @Override
    public String toString() {
        return "KhoaHoc{" + "id=" + id + ", Name=" + Name + ", Begin_date=" + Begin_date + ", End_date=" + End_date + '}';
    }
    
    
}

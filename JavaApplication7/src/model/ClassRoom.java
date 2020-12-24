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
public class ClassRoom {
    private int id;
    private String name;
    private int KH_id;
    private int Teacher_id;
    private String KH_Name;
    private String Teacher_Name;

    public ClassRoom(int id, String name, int KH_id, int Teacher_id, String KH_Name, String Teacher_Name) {
        this.id = id;
        this.name = name;
        this.KH_id = KH_id;
        this.Teacher_id = Teacher_id;
        this.KH_Name = KH_Name;
        this.Teacher_Name = Teacher_Name;
    }

    public ClassRoom(String name, int KH_id, int Teacher_id) {
        this.name = name;
        this.KH_id = KH_id;
        this.Teacher_id = Teacher_id;
    }

    public ClassRoom(int id, String name, int KH_id, int Teacher_id) {
        this.id = id;
        this.name = name;
        this.KH_id = KH_id;
        this.Teacher_id = Teacher_id;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKH_id() {
        return KH_id;
    }

    public void setKH_id(int KH_id) {
        this.KH_id = KH_id;
    }

    public int getTeacher_id() {
        return Teacher_id;
    }

    public void setTeacher_id(int Teacher_id) {
        this.Teacher_id = Teacher_id;
    }

    public String getKH_Name() {
        return KH_Name;
    }

    public void setKH_Name(String KH_Name) {
        this.KH_Name = KH_Name;
    }

    public String getTeacher_Name() {
        return Teacher_Name;
    }

    public void setTeacher_Name(String Teacher_Name) {
        this.Teacher_Name = Teacher_Name;
    }
    
    
    
    
    
}

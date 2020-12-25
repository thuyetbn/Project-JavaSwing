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
public class Mark {
    private int Student_ID;
    private int Subject_ID;
    private int mark;
    private String note;
    private String Ex_date;
    private int S_id;
    private String S_name;
    private int SJ_id;
    private String SJ_name;
    private String S_MSV;

    public Mark(int Student_ID, int Subject_ID, int mark, String note, String Ex_date) {
        this.Student_ID = Student_ID;
        this.Subject_ID = Subject_ID;
        this.mark = mark;
        this.note = note;
        this.Ex_date = Ex_date;
    }

    
    
    public Mark(int Student_ID, int Subject_ID, int mark, String note, String Ex_date,String S_MSV) {
        this.Student_ID = Student_ID;
        this.Subject_ID = Subject_ID;
        this.mark = mark;
        this.note = note;
        this.Ex_date = Ex_date;
        this.S_MSV = S_MSV;
    }

    public Mark(int Student_ID, int Subject_ID, int mark, String note, String Ex_date, int S_id, String S_name, int SJ_id, String SJ_name,String S_MSV) {
        this.Student_ID = Student_ID;
        this.Subject_ID = Subject_ID;
        this.mark = mark;
        this.note = note;
        this.Ex_date = Ex_date;
        this.S_id = S_id;
        this.S_name = S_name;
        this.SJ_id = SJ_id;
        this.SJ_name = SJ_name;
        this.S_MSV = S_MSV;
    }
    
    

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    public int getSubject_ID() {
        return Subject_ID;
    }

    public void setSubject_ID(int Subject_ID) {
        this.Subject_ID = Subject_ID;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEx_date() {
        return Ex_date;
    }

    public void setEx_date(String Ex_date) {
        this.Ex_date = Ex_date;
    }

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int S_id) {
        this.S_id = S_id;
    }

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String S_name) {
        this.S_name = S_name;
    }

    public int getSJ_id() {
        return SJ_id;
    }

    public void setSJ_id(int SJ_id) {
        this.SJ_id = SJ_id;
    }

    public String getSJ_name() {
        return SJ_name;
    }

    public void setSJ_name(String SJ_name) {
        this.SJ_name = SJ_name;
    }

    public String getS_MSV() {
        return S_MSV;
    }

    public void setS_MSV(String S_MSV) {
        this.S_MSV = S_MSV;
    }
    
    
    @Override
    public String toString() {
        return "Mark{" + "Student_ID=" + Student_ID + ", Subject_ID=" + Subject_ID + ", mark=" + mark  + ", note=" + note + ", Ex_date=" + Ex_date + '}';
    }
    
    
}

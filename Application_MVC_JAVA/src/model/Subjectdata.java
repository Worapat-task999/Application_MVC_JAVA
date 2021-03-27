package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Subjectdata {
    private String firstname;
    private int sid;
    private String lastname;
    private String subject;

    public Subjectdata(int sid,String subject,String firstname, String lastname) {
        this.firstname = firstname;
        this.sid = sid;
        this.lastname = lastname;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    
    public int getSid() {
        return sid;
    }

   
    public void setSid(int sid) {
        this.sid = sid;
    }

}
       


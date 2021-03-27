package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Lecturerdata {
    private int num,tid;
    private String lec;
    
    public Lecturerdata(int tid,String lec,int num){
        this.tid=tid;
        this.lec=lec;
        this.num=num;
     }

    public String getLecturerName() {
         return lec;
      }
    

    public int getNumOfSubjects() {
           return num;
        }
    
    public int getTID(){
        return tid;
    }
    
}

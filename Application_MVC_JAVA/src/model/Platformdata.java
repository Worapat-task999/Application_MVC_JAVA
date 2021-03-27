
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Platformdata {
   private double platsc;
    private String subjects,platforms;
    public Platformdata(String subjects,String platforms,double platsc){
        this.platsc = platsc;
        this.subjects = subjects;
        this.platforms = platforms;
    }

    public double getPlatsc() {
        return platsc;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getPlatforms() {
        return platforms;
    } 
}

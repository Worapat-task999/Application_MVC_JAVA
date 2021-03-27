package model;
import controller.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
public class Smodel {
    private Scontroller con;
    private Connection conn;
    private Statement myStmt;
    private ResultSet myRs;
    private  PreparedStatement pst;
    public Smodel() throws Exception {

        Properties props = new Properties();
        props.load(new FileInputStream("loginsql.properties"));

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl = props.getProperty("dburl");
        try {
            conn = DriverManager.getConnection(dburl, user, password);
            System.out.println("Database connection successful to " + dburl);
        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
        }
    }
    public void updateteacher(String [] updateteacher_tempmodel)throws Exception{
         try { 
             System.out.print("model is work");
             String sql = "update lecturer set firstname = ?, lastname =? where tid = ?";
             pst= conn.prepareStatement(sql);
             pst.setString(1,updateteacher_tempmodel[2]);
              pst.setString(2,updateteacher_tempmodel[3]);
              pst.setString(3,updateteacher_tempmodel[1]);     
            pst.execute();
              } catch(SQLException e){System.out.println("errorsqlupdatevalue");}
         finally {
            close(myStmt, myRs);
        }
    }
    public void deleteteacher(String deleteteacher_tempmodel)throws Exception{
         try { 
              myStmt = conn.createStatement();
             System.out.print("model is work");
             String sql = "DELETE FROM lecturer WHERE tid="+deleteteacher_tempmodel;       
            myStmt.executeUpdate(sql);
              } catch(SQLException e){System.out.println("errordelete");}
         finally {
            close(myStmt, myRs);
        }
    }
    public void addteacher(String [] teacher_tempmodel)throws Exception{
         try { 
             System.out.print("model is work");
             String sql = "insert into lecturer (tid,firstname,lastname) values (?,?,?)";
             pst= conn.prepareStatement(sql);
             pst.setString(1,teacher_tempmodel[1]);
              pst.setString(2,teacher_tempmodel[2]);
              pst.setString(3,teacher_tempmodel[3]);     
            pst.execute();
              } catch(SQLException e){System.out.println("errorsqlvalue");}
         finally {
            close(myStmt, myRs);
        }
    }
     public ArrayList<teachersearchdata> searchteachersubject(String [] searchteacher_tempmodel)throws Exception{
         ArrayList<teachersearchdata> list = new ArrayList<>();     
        try {
            myStmt = conn.createStatement();
            String firstname_temp_temp=searchteacher_tempmodel[1];
            String lastname_temp_temp=searchteacher_tempmodel[2];
            String sql = "Select subjects.tid,firstname,lastname,subjectname from lecturer,subjects where subjects.tid = lecturer.tid and firstname='"+firstname_temp_temp+"' "
                    + "and lastname='"+lastname_temp_temp+"' ";
            myRs = myStmt.executeQuery(sql);
    

            while (myRs.next()) {
                int tid_temp=myRs.getInt(1);
                String firstname_temp=myRs.getString(2);
                String lastname_temp=myRs.getString(4);
                 String subjectname_temp=myRs.getString(3);
                teachersearchdata result1_temp=new teachersearchdata (tid_temp,subjectname_temp,firstname_temp,lastname_temp);
                list.add(result1_temp);
              
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }
    public ArrayList<Subjectdata> getAllSubjects() throws Exception {
        ArrayList<Subjectdata> list = new ArrayList<>();
        
        try {
            myStmt = conn.createStatement();
            String sql = "Select sid,subjectname,firstname,lastname from lecturer,subjects where subjects.tid = lecturer.tid";
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                //อันนี้เเบบไม่รวบตัวเเปร ตย.
                int sid_temp=myRs.getInt(1);
                String subjectname_temp=myRs.getString(2);
                String firstname_temp=myRs.getString(3);
                String lirstname_temp=myRs.getString(4);
                Subjectdata result1_temp=new Subjectdata (sid_temp,subjectname_temp,firstname_temp,lirstname_temp);
                list.add(result1_temp);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public ArrayList<Lecturerdata> getLecturerAndNumOfSubjects() throws Exception {
        ArrayList<Lecturerdata> list = new ArrayList<>();
        
        try {
            myStmt = conn.createStatement();
            String sql = "Select subjects.tid,firstname,lastname,count(*) from lecturer,subjects where subjects.tid = lecturer.tid GROUP By lecturer.firstname";
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                //อันนี้เเบบใช้ method เก็บตัวเเปร
                Lecturerdata tempLecturer = convertRowToLecturer(myRs);
                list.add(tempLecturer);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public ArrayList<Platformdata> getPlatformsScore() throws Exception {
        ArrayList<Platformdata> list = new ArrayList<>();

        try {
            myStmt = conn.createStatement();
            String sql = "Select subjectname,platformname,sscore from subjects,platforms where subjects.pid = platforms.pid order by sscore desc";
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                Platformdata tempPlatformsScore = convertRowToPlatformsScore(myRs);
                list.add(tempPlatformsScore);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
            throws SQLException {

        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {

        }

        if (myConn != null) {
            myConn.close();
        }
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

   /* private Subjectdata convertRowToSubjects(ResultSet myRs) throws SQLException {
        int sID = myRs.getInt(1);
        String subjects = myRs.getString(2);
        String lecturer = myRs.getString(3) + " " + myRs.getString(4);
        Subjectdata tempSubjects = new Subjectdata(sID, subjects, lecturer);
        return tempSubjects;
    }*/

    private Lecturerdata convertRowToLecturer(ResultSet myRs) throws SQLException {
        int tID = myRs.getInt(1);
        String lecturer = myRs.getString(2) + " " + myRs.getString(3);
        int numOfSubjects = myRs.getInt(4);
        Lecturerdata tempLecturer = new Lecturerdata(tID, lecturer, numOfSubjects);
        return tempLecturer;
    }

    private Platformdata convertRowToPlatformsScore(ResultSet myRs) throws SQLException {
        String subjects = myRs.getString(1);
        String platforms = myRs.getString(2);
        double satisfactionSc = myRs.getDouble(3);
        Platformdata tempLecturer = new Platformdata(subjects, platforms, satisfactionSc);
        return tempLecturer;
    }
}


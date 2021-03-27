package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.Sview;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Scontroller implements ActionListener{//จำเป็นต้อง implement
    private Sview view;
    private Smodel model;
    public boolean alreadyclick1;
    private boolean alreadyclick2,alreadyclick3,alreadyclick4;
    
    public Scontroller(Sview view,Smodel model){
        this.view = view;
        this.model = model;
    }
    
    public void showA() throws Exception{
        ArrayList<Subjectdata> subjectsList = model.getAllSubjects();
        view.setTable1(subjectsList);
    }
    public void showB()throws Exception{
        ArrayList<Lecturerdata> lecturerList = model.getLecturerAndNumOfSubjects();
         view.setTable2(lecturerList);
    }
    public void showC()throws Exception{
        ArrayList<Platformdata> platformsList = model.getPlatformsScore();
         view.setTable3(platformsList);
    }
    public void showforsearch()throws Exception{
        String [] searchteacher_tempcon=view.gettext2();
        ArrayList<teachersearchdata> teacherList =  model.searchteachersubject(searchteacher_tempcon);
         view.setTable4(teacherList);
    }
    public void addteacher()throws Exception{
        String [] teacher_tempcon=view.gettext();
    model.addteacher(teacher_tempcon);
    }
    public void deleteteacher()throws Exception{
        String  deleteteacher_tempcon=view.gettext3();
    model.deleteteacher(deleteteacher_tempcon);
    }
    public void updateteacher()throws Exception{
        String [] updateteacher_tempcon=view.gettext4();
    model.updateteacher(updateteacher_tempcon);
    }
   

    @Override
    public void actionPerformed(ActionEvent e) { //จำเป็นต้อง override
        String command=e.getActionCommand();
        if(command.equals("รายชื่อวิชาทั้งหมด")&&alreadyclick1==false){
            try{
                showA();
                alreadyclick1=true;
            }catch(Exception e1){} 
        }
        else if(command.equals("จำนวนวิชาที่อาจารย์แต่ละทานสอน")&&alreadyclick2==false){
            try{
                showB();
                alreadyclick2=true;
            }catch(Exception e1){}
        }
        else if(command.equals("เรียงลำดับคะแนนความพึงพอใจต่อแพลตฟอร์มในแต่ละวิชา")&&alreadyclick3==false){
            try{
                showC();
                alreadyclick3=true;
            }catch(Exception e1){}
        }
         else if(command.equals("done")){
            try{
                System.out.println("button action");
               addteacher(); 
            }
            catch(Exception e1){}
        }else if(command.equals("search")){
            try{
                System.out.println("button action");
               showforsearch(); 
            }
            catch(Exception e1){System.out.println("errorquery");}
        }else if(command.equals("DeleteDatateacher")){
            try{
                System.out.println("button action");
               deleteteacher(); 
            }
            catch(Exception e1){System.out.println("errordelete");}
        }else if(command.equals("Update")){
            try{
                System.out.println("button action");
               updateteacher(); 
            }
            catch(Exception e1){System.out.println("errorupdate");}
        }
    }
}

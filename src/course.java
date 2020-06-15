
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class course {
    private static Connection connection;
    private static PreparedStatement insertCourse;
    private static PreparedStatement removeCourse;
    private static PreparedStatement changeCourse;
    private static PreparedStatement getCourses;
    private static PreparedStatement getSemesters;
    private static ResultSet rs;
    
    
    public static ArrayList<ArrayList> semesterTable(Integer sem){
        ArrayList<ArrayList> semesterList = new ArrayList<ArrayList>();
        
        try{
           connection = DBConnection.getConnection();
           getSemesters = connection.prepareStatement("select cabbr, cname, croom, prof, poffice, phour, cdays, ctime1, ctime2, clevel from course where csem = ?");  
           getSemesters.setInt(1,sem);
           rs = getSemesters.executeQuery();
           while(rs.next()){
               ArrayList semester = new ArrayList(Arrays.asList(rs.getString("cabbr"), rs.getString("cname"), rs.getString("croom"), 
                        rs.getString("prof"), rs.getString("poffice"), rs.getString("phour"),
                        rs.getString("cdays"), rs.getString("ctime1"), rs.getString("ctime2"), rs.getInt("clevel")));
               semesterList.add(semester);
           } 
        }
        catch(SQLException ex){
           ex.printStackTrace();
        }
        return semesterList;
    }
    
    public static ArrayList<Integer> getSemester(){
        ArrayList Semester = new ArrayList<Integer>();
        try{
           connection = DBConnection.getConnection();
           getSemesters = connection.prepareStatement("select distinct csem from course");  
           rs = getSemesters.executeQuery();
           while(rs.next()){
               Semester.add(rs.getInt("csem"));
           }
           Collections.sort(Semester);
           
        }
        catch(SQLException ex){
           ex.printStackTrace();
        }
        return Semester;
    }
    
    
    public static ArrayList<String> getCourses(){
        ArrayList arrayCourses = new ArrayList<String>();
        try{
           connection = DBConnection.getConnection();
           getCourses = connection.prepareStatement("select distinct cabbr from course");  
           rs = getCourses.executeQuery();
           while(rs.next()){
               arrayCourses.add(rs.getString("cabbr"));
           }
        }
        catch(SQLException ex){
           ex.printStackTrace();
        }
        return arrayCourses;
    }
    
    public static void modifyCourse(String abbr, String name, String room, String pname, String poffice, String phour, String days, String classStarts, String classEnds, Integer mandatory){
        try{
            connection = DBConnection.getConnection(); 
            changeCourse = connection.prepareStatement("UPDATE course SET cname = ?, croom = ?, prof = ?, poffice = ?, phour = ?, cdays = ?, ctime1 = ?, ctime2 = ?, clevel = ? WHERE cabbr = ?");
            changeCourse.setString(1,name);
            changeCourse.setString(2,room);
            changeCourse.setString(3,pname);
            changeCourse.setString(4,poffice);
            changeCourse.setString(5,phour);
            changeCourse.setString(6,days);
            changeCourse.setString(7,classStarts);
            changeCourse.setString(8,classEnds);
            changeCourse.setInt(9,mandatory);
            changeCourse.setString(10,abbr);
            changeCourse.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void removeCourse(String abbr){
        try{
            connection = DBConnection.getConnection();
            removeCourse = connection.prepareStatement("DELETE FROM COURSE WHERE cabbr = ?");
            removeCourse.setString(1,abbr);
            removeCourse.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    
    public static void addCourse(String abbr, String name, String room, String pname, String poffice, String phour, Integer semester, Integer plevel, Boolean mon, Boolean tues, Boolean wed, Boolean thurs, Boolean fri, Boolean sat, Boolean on, String classStarts, String classEnds){
        ArrayList<String> Days = new ArrayList();
        String theDays = "";
        if (mon == true && on == false){String temp = "M";Days.add(temp);}
        if (tues == true && on == false){String temp = "T";Days.add(temp);}
        if (wed == true && on == false){String temp = "W";Days.add(temp);}
        if (thurs == true && on == false){String temp = "Th";Days.add(temp);}
        if (fri == true && on == false){String temp = "F";Days.add(temp);}
        if (sat == true && on == false){String temp = "S";Days.add(temp);}
        if (on == true){String temp = "Online";Days.add(temp);}
        for(int i = 0; i < Days.size(); i++){
            theDays += Days.get(i);
        }
        
        try{
            connection = DBConnection.getConnection();
            insertCourse = connection.prepareStatement("insert into course (cabbr,cname,croom,prof,poffice,phour,cdays,ctime1,ctime2,clevel,csem) values (?,?,?,?,?,?,?,?,?,?,?)");
            insertCourse.setString(1,abbr);
            insertCourse.setString(2,name);
            insertCourse.setString(3,room);
            insertCourse.setString(4,pname);
            insertCourse.setString(5,poffice);
            insertCourse.setString(6,phour);
            insertCourse.setString(7,theDays);
            insertCourse.setString(8,classStarts);
            insertCourse.setString(9,classEnds);
            insertCourse.setInt(10,plevel);
            insertCourse.setInt(11,semester);
            insertCourse.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}

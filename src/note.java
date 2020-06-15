
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class note {
    private static Connection connection;
    private static PreparedStatement addNoteQuery;
    private static PreparedStatement deleteNoteQuery;
    private static PreparedStatement noteTableQuery;
    private static PreparedStatement getNoteQuery;
    private static PreparedStatement modifyNoteQuery;
    private static ResultSet rs;
    
    public static void modifyNote(String title, String note, String nmodified, Integer nid){
        try{
            connection = DBConnection.getConnection();
            modifyNoteQuery = connection.prepareStatement("UPDATE note SET ntitle = ?, note = ?, nmodified = ? WHERE nid = ?");
            modifyNoteQuery.setString(1,title);
            modifyNoteQuery.setString(2,note);
            modifyNoteQuery.setString(3,nmodified);
            modifyNoteQuery.setInt(4,nid);
            modifyNoteQuery.executeUpdate();
        }
            
        catch(SQLException ex){
           ex.printStackTrace();
        }
    }
    
    public static ArrayList getNote(Integer nid){
        ArrayList noteInfo = new ArrayList<ArrayList>();
        try{
           connection = DBConnection.getConnection();
           getNoteQuery = connection.prepareStatement("select * from note where nid = ?");
           getNoteQuery.setInt(1,nid);
           rs = getNoteQuery.executeQuery();
           while(rs.next()){
                String completed = rs.getString("ncreated");
                
                String part[] = completed.split(" ");
                String datePart[] = part[0].split("/");
                String timePart[] = part[1].split(":");
                Integer hourInt = Integer.parseInt(timePart[0]);
                String getcompletedDue = "";

                if (hourInt == 0){
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "AM";
                }
                else if (hourInt > 0 && hourInt < 10){
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1] + " " + "AM";
                }
                else if (hourInt >= 10 && hourInt < 12){
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1] + " " + "AM";
                }
                else if (hourInt == 12){
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "PM";
                }
                else if (hourInt > 12 && hourInt < 22){
                    Integer hourMinus12 = hourInt - 12;
                    String hourStr = Integer.toString(hourMinus12);
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 0" + hourStr + ":" + timePart[1] + " " + "PM";
                }
                else if(hourInt >= 22 && hourInt < 24){
                    Integer hourMinus12 = hourInt - 12;
                    String hourStr = Integer.toString(hourMinus12);
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + hourStr + ":" + timePart[1] + " " + "PM";
                }
                
                String completed1 = rs.getString("nmodified");
                String part1[] = completed1.split(" ");
                String datePart1[] = part1[0].split("/");
                String timePart1[] = part1[1].split(":");
                Integer hourInt1 = Integer.parseInt(timePart1[0]);
                String getcompletedDate = "";

                if (hourInt1 == 0){
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " 12:" + timePart1[1] + " " + "AM";
                }
                else if (hourInt1 > 0 && hourInt1 < 10){
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " " + timePart1[0] + ":" + timePart1[1] + " " + "AM";
                }
                else if (hourInt1 >= 10 && hourInt1 < 12){
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " " + timePart1[0] + ":" + timePart1[1] + " " + "AM";
                }
                else if (hourInt1 == 12){
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " 12:" + timePart1[1] + " " + "PM";
                }
                else if (hourInt1 > 12 && hourInt1 < 22){
                    Integer hourMinus12 = hourInt1 - 12;
                    String hourStr = Integer.toString(hourMinus12);
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " 0" + hourStr + ":" + timePart1[1] + " " + "PM";
                }
                else if(hourInt1 >= 22 && hourInt1 < 24){
                    Integer hourMinus12 = hourInt1 - 12;
                    String hourStr = Integer.toString(hourMinus12);
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " " + hourStr + ":" + timePart1[1] + " " + "PM";
                }
               
               noteInfo = new ArrayList(Arrays.asList(rs.getString("ntitle"), rs.getString("note"), getcompletedDue, getcompletedDate, rs.getInt("nid")));
           } 
        }
        catch(SQLException ex){
           ex.printStackTrace();
        }
        return noteInfo;
    }
    
    public static void deleteNote(Integer nid){
        try{
           connection = DBConnection.getConnection();
           deleteNoteQuery = connection.prepareStatement("DELETE FROM NOTE WHERE nid = ?");
           deleteNoteQuery.setInt(1,nid);
           deleteNoteQuery.executeUpdate();
        }
        catch(SQLException ex){
           ex.printStackTrace();
        }
    }
    
    public static ArrayList<ArrayList> noteTable(){
        ArrayList<ArrayList> tables = new ArrayList<ArrayList>();
        try{
           connection = DBConnection.getConnection();
           noteTableQuery = connection.prepareStatement("select ntitle, ncreated, nmodified, nid from note order by nmodified desc");  
           rs = noteTableQuery.executeQuery();
           while(rs.next()){
               String completed = rs.getString("ncreated");
                
                String part[] = completed.split(" ");
                String datePart[] = part[0].split("/");
                String timePart[] = part[1].split(":");
                Integer hourInt = Integer.parseInt(timePart[0]);
                String getcompletedDue = "";

                if (hourInt == 0){
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "AM";
                }
                else if (hourInt > 0 && hourInt < 10){
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1] + " " + "AM";
                }
                else if (hourInt >= 10 && hourInt < 12){
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1] + " " + "AM";
                }
                else if (hourInt == 12){
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "PM";
                }
                else if (hourInt > 12 && hourInt < 22){
                    Integer hourMinus12 = hourInt - 12;
                    String hourStr = Integer.toString(hourMinus12);
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 0" + hourStr + ":" + timePart[1] + " " + "PM";
                }
                else if(hourInt >= 22 && hourInt < 24){
                    Integer hourMinus12 = hourInt - 12;
                    String hourStr = Integer.toString(hourMinus12);
                    getcompletedDue = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + hourStr + ":" + timePart[1] + " " + "PM";
                }
                
                String completed1 = rs.getString("nmodified");
                String part1[] = completed1.split(" ");
                String datePart1[] = part1[0].split("/");
                String timePart1[] = part1[1].split(":");
                Integer hourInt1 = Integer.parseInt(timePart1[0]);
                String getcompletedDate = "";

                if (hourInt1 == 0){
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " 12:" + timePart1[1] + " " + "AM";
                }
                else if (hourInt1 > 0 && hourInt1 < 10){
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " " + timePart1[0] + ":" + timePart1[1] + " " + "AM";
                }
                else if (hourInt1 >= 10 && hourInt1 < 12){
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " " + timePart1[0] + ":" + timePart1[1] + " " + "AM";
                }
                else if (hourInt1 == 12){
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " 12:" + timePart1[1] + " " + "PM";
                }
                else if (hourInt1 > 12 && hourInt1 < 22){
                    Integer hourMinus12 = hourInt1 - 12;
                    String hourStr = Integer.toString(hourMinus12);
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " 0" + hourStr + ":" + timePart1[1] + " " + "PM";
                }
                else if(hourInt1 >= 22 && hourInt1 < 24){
                    Integer hourMinus12 = hourInt1 - 12;
                    String hourStr = Integer.toString(hourMinus12);
                    getcompletedDate = datePart1[0] + "/" + datePart1[1] + "/" + datePart1[2] + " " + hourStr + ":" + timePart1[1] + " " + "PM";
                }
               
               ArrayList table = new ArrayList(Arrays.asList(rs.getString("ntitle"), getcompletedDue, getcompletedDate, rs.getInt("nid")));
               tables.add(table);
           } 
        }
        catch(SQLException ex){
           ex.printStackTrace();
        }
        return tables;
    }
    
    public static void addNote(String getTimestamp24){
        try{
            String newTitle = "new note";
            String emptyString = "";
            connection = DBConnection.getConnection();
            addNoteQuery = connection.prepareStatement("insert into note (ntitle,note,ncreated,nmodified) values (?,?,?,?)");
            addNoteQuery.setString(1,newTitle);
            addNoteQuery.setString(2,emptyString);
            addNoteQuery.setString(3,getTimestamp24);
            addNoteQuery.setString(4,getTimestamp24);
            addNoteQuery.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}

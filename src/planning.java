
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
public class planning {
    private static Connection connection;
    private static PreparedStatement insertPlanning;
    private static PreparedStatement theCategory;
    private static ResultSet rs;
    private static ArrayList<String> arrayCategory;
    private static PreparedStatement orderByDue;
    private static PreparedStatement orderByCreate;
    private static PreparedStatement orderByMandatory;
    private static PreparedStatement orderByCompleted;
    private static PreparedStatement modifyPlanning;
    
    public static void deletePlan(Integer PID){
        try{
            connection = DBConnection.getConnection();
            modifyPlanning = connection.prepareStatement("DELETE FROM PLAN WHERE pid = ?");
            modifyPlanning.setInt(1,PID);
            modifyPlanning.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void completePlan(Integer PID){
        Boolean theBoolean = false;
        try{
            connection = DBConnection.getConnection();
            orderByCompleted = connection.prepareStatement("SELECT pcomplete FROM PLAN WHERE pid = ?");
            orderByCompleted.setInt(1, PID);
            rs = orderByCompleted.executeQuery();
            while(rs.next()){
                theBoolean = rs.getBoolean("pcomplete");
                if (theBoolean == false){
                    theBoolean = true;
                }
                else{
                    theBoolean = false;
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        try{
            connection = DBConnection.getConnection();
            modifyPlanning = connection.prepareStatement("UPDATE plan SET pcomplete = ? WHERE pid = ?");
            modifyPlanning.setBoolean(1,theBoolean);
            modifyPlanning.setInt(2,PID);
            modifyPlanning.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void modifyingPlan(String ptitle, String pdescription, String plocation, String pcategory, Integer pmandatory, Integer PID, String pdue){
        String location = "";
        String theDate = "";
        String part[] = pdue.split(" ");
        String datePart[] = part[0].split("/");
        String timePart[] = part[1].split(":");
        Integer hourInt = Integer.parseInt(timePart[0]);

        String tempm = (String) part[2];
        String am = "AM";
        String pm = "PM";

        Integer compareAM = tempm.compareTo(am);
        Integer comparePM = tempm.compareTo(pm);

        if (compareAM == 0 && comparePM != 0){
            if (hourInt >= 1 && hourInt <= 11){
                theDate = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1];
            }
            else if (hourInt == 12){
                theDate = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 00:" + timePart[1];
            }
        }
        else if(comparePM == 0 && compareAM != 0){
            if (hourInt >= 1 && hourInt <= 11){
                Integer hourInt2 = hourInt + 12;
                String hourStr = Integer.toString(hourInt2);
                theDate = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + hourStr + ":" + timePart[1];
            }
            else if (hourInt == 12){
                Integer hourInt2 = hourInt + 12;
                String hourStr = Integer.toString(hourInt2);
                theDate = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1];
            }
        }
        
        if (plocation.compareTo("No Location") == 0){
            location = "";
        }
        else{
            location = plocation;
        }
        try{
            connection = DBConnection.getConnection();
            modifyPlanning = connection.prepareStatement("UPDATE plan SET ptitle = ?, pdescription = ?, pcategory = ?, plocation = ?, pmandatory = ?, pdue = ? WHERE pid = ?");
            modifyPlanning.setString(1,ptitle);
            modifyPlanning.setString(2,pdescription);
            modifyPlanning.setString(3,pcategory);
            modifyPlanning.setString(4,plocation);
            modifyPlanning.setInt(5,pmandatory);
            modifyPlanning.setString(6,theDate);
            modifyPlanning.setInt(7,PID);
            modifyPlanning.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    
    
    public static ArrayList view(String title, String category, String date, String due, String location, Integer mandatory){
        boolean theTrue = true;
        ArrayList arrayPlan = new ArrayList();
        
        String theDate = "";
        String part[] = date.split(" ");
        String datePart[] = part[0].split("/");
        String timePart[] = part[1].split(":");
        Integer hourInt = Integer.parseInt(timePart[0]);

        String tempm = (String) part[2];
        String am = "AM";
        String pm = "PM";

        Integer compareAM = tempm.compareTo(am);
        Integer comparePM = tempm.compareTo(pm);

        if (compareAM == 0 && comparePM != 0){
            if (hourInt >= 1 && hourInt <= 11){
                theDate = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1];
            }
            else if (hourInt == 12){
                theDate = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 00:" + timePart[1];
            }
        }
        else if(comparePM == 0 && compareAM != 0){
            if (hourInt >= 1 && hourInt <= 11){
                Integer hourInt2 = hourInt + 12;
                String hourStr = Integer.toString(hourInt2);
                theDate = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + hourStr + ":" + timePart[1];
            }
            else if (hourInt == 12){
                Integer hourInt2 = hourInt + 12;
                String hourStr = Integer.toString(hourInt2);
                theDate = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1];
            }
        }
        
        String theDue = "";
        String part2[] = due.split(" ");
        String datePart2[] = part2[0].split("/");
        String timePart2[] = part2[1].split(":");
        Integer hourInt3 = Integer.parseInt(timePart2[0]);

        String tempm2 = (String) part2[2];
        String am2 = "AM";
        String pm2 = "PM";

        Integer compareAM2 = tempm2.compareTo(am2);
        Integer comparePM2 = tempm2.compareTo(pm2);

        if (compareAM2 == 0 && comparePM2 != 0){
            if (hourInt3 >= 1 && hourInt3 <= 11){
                theDue = datePart2[0] + "/" + datePart2[1] + "/" + datePart2[2] + " " + timePart2[0] + ":" + timePart2[1];
            }
            else if (hourInt3 == 12){
                theDue = datePart2[0] + "/" + datePart2[1] + "/" + datePart2[2] + " 00:" + timePart2[1];
            }
        }
        else if(comparePM2 == 0 && compareAM2 != 0){
            if (hourInt3 >= 1 && hourInt3 <= 11){
                Integer hourInt4 = hourInt3 + 12;
                String hourStr2 = Integer.toString(hourInt4);
                theDue = datePart2[0] + "/" + datePart2[1] + "/" + datePart2[2] + " " + hourStr2 + ":" + timePart2[1];
            }
            else if (hourInt == 12){
                Integer hourInt4 = hourInt3 + 12;
                String hourStr2 = Integer.toString(hourInt4);
                theDue = datePart2[0] + "/" + datePart2[1] + "/" + datePart2[2] + " 12:" + timePart2[1];
            }
        }
        
        try{
            connection = DBConnection.getConnection();
            orderByCompleted = connection.prepareStatement("SELECT * FROM PLAN WHERE ptitle = ? and pcategory = ? and pdate = ? and pdue = ? and plocation = ? and pmandatory = ?");
            orderByCompleted.setString(1, title);
            orderByCompleted.setString(2, category);
            orderByCompleted.setString(3, theDate);
            orderByCompleted.setString(4, theDue);
            orderByCompleted.setString(5, location);
            orderByCompleted.setInt(6, mandatory);
            rs = orderByCompleted.executeQuery();
            while(rs.next()){
                arrayPlan = new ArrayList(Arrays.asList(rs.getString("ptitle"), rs.getString("pcategory"), date, 
                        due, rs.getString("plocation"), rs.getInt("pmandatory"), 
                        rs.getString("pdescription"), rs.getBoolean("pcomplete"), rs.getInt("pid")));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return arrayPlan;
    }   
    
    public static ArrayList<ArrayList> listCompleted(){
        boolean theTrue = true;
        ArrayList arrayPlan = new ArrayList();
        ArrayList<ArrayList> arrayPlans = new ArrayList<ArrayList>();
        try{
            connection = DBConnection.getConnection();
            orderByCompleted = connection.prepareStatement("SELECT * FROM PLAN WHERE pcomplete = ? ORDER BY pdue");
            orderByCompleted.setBoolean(1, theTrue);
            rs = orderByCompleted.executeQuery();
            while(rs.next()){
                String completed = rs.getString("pdue");
                
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
                
                String completed1 = rs.getString("pdate");
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
                
                arrayPlan = new ArrayList(Arrays.asList(rs.getString("ptitle"), rs.getString("pcategory"), getcompletedDate, getcompletedDue, rs.getString("plocation"), rs.getInt("pmandatory")));
                arrayPlans.add(arrayPlan);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return arrayPlans;
    }    
    
    public static ArrayList<ArrayList> listPlanMandatory(){
        boolean theFalse = false;
        ArrayList arrayPlan = new ArrayList();
        ArrayList<ArrayList> arrayPlans = new ArrayList<ArrayList>();
        try{
            connection = DBConnection.getConnection();
            orderByMandatory = connection.prepareStatement("SELECT * FROM PLAN WHERE pcomplete = ? ORDER BY pmandatory DESC");
            orderByMandatory.setBoolean(1, theFalse);
            rs = orderByMandatory.executeQuery();
            while(rs.next()){
                String completed = rs.getString("pdue");
                
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
                
                String completed1 = rs.getString("pdate");
                
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
                arrayPlan = new ArrayList(Arrays.asList(rs.getString("ptitle"), rs.getString("pcategory"), getcompletedDate, getcompletedDue, rs.getString("plocation"), rs.getInt("pmandatory")));
                arrayPlans.add(arrayPlan);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return arrayPlans;
    }
    
    public static ArrayList<ArrayList> listPlanCreate(){
        boolean theFalse = false;
        ArrayList arrayPlan = new ArrayList();
        ArrayList<ArrayList> arrayPlans = new ArrayList<ArrayList>();
        try{
            connection = DBConnection.getConnection();
            orderByCreate = connection.prepareStatement("SELECT * FROM PLAN WHERE pcomplete = ? ORDER BY pdate");
            orderByCreate.setBoolean(1, theFalse);
            rs = orderByCreate.executeQuery();
            while(rs.next()){
                String completed = rs.getString("pdue");
                
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
                
                String completed1 = rs.getString("pdate");
                
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
                arrayPlan = new ArrayList(Arrays.asList(rs.getString("ptitle"), rs.getString("pcategory"), getcompletedDate, getcompletedDue, rs.getString("plocation"), rs.getInt("pmandatory")));
                arrayPlans.add(arrayPlan);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return arrayPlans;
    }    
    
    public static ArrayList<ArrayList> listPlanDue(){
        boolean theFalse = false;
        ArrayList arrayPlan = new ArrayList();
        ArrayList<ArrayList> arrayPlans = new ArrayList<ArrayList>();
        try{
            connection = DBConnection.getConnection();
            orderByDue = connection.prepareStatement("SELECT * FROM PLAN WHERE pcomplete = (?) ORDER BY pdue");
            orderByDue.setBoolean(1, theFalse);
            rs = orderByDue.executeQuery();
            while(rs.next()){
                String completed = rs.getString("pdue");
                
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
                
                String completed1 = rs.getString("pdate");
                
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
                arrayPlan = new ArrayList(Arrays.asList(rs.getString("ptitle"), rs.getString("pcategory"), getcompletedDate, getcompletedDue, rs.getString("plocation"), rs.getInt("pmandatory")));
                arrayPlans.add(arrayPlan);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return arrayPlans;
    }        
               
    public static ArrayList<String> getCategory(){
        arrayCategory = new ArrayList<String>();
        try{
           connection = DBConnection.getConnection();
           theCategory = connection.prepareStatement("select distinct pcategory from plan");  
           rs = theCategory.executeQuery();
           while(rs.next()){
               arrayCategory.add(rs.getString("pcategory"));
           }
           arrayCategory.add("Or new category->");
        }
        catch(SQLException ex){
           ex.printStackTrace();
        }
        return arrayCategory;
    }
    
    public static void addPlanning(String ptitle, String pdate, String pdescription, String pdue, String pcategory, String plocation, Integer pmandatory){
        boolean incomplete = false;
        String location = "";
        if (plocation.compareTo("") == 0){
            location = "No Location";
        }
        else{
            location = plocation;
        }
        try{
            connection = DBConnection.getConnection();
            insertPlanning = connection.prepareStatement("insert into plan (ptitle,pdate,pdescription,pdue,pcategory,plocation,pmandatory,pcomplete) values (?,?,?,?,?,?,?,?)");
            insertPlanning.setString(1,ptitle);
            insertPlanning.setString(2,pdate);
            insertPlanning.setString(3,pdescription);
            insertPlanning.setString(4,pdue);
            insertPlanning.setString(5,pcategory);
            insertPlanning.setString(6,location);
            insertPlanning.setInt(7,pmandatory);
            insertPlanning.setBoolean(8,incomplete);
            insertPlanning.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_management;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.*;

/**
 *
 * @author sameer
 */
class Rentability{
    Date arrivalFrom = new Date();
    Date departureTo = new Date();
    List<String> checkInDay;
    List<String> checkOutDay;
    int minStay;
    int maxStay;
    
    private final FileWriter fout;
    
    
    Rentability(Date arrivalFrom, Date departureTo, List checkInDay, List checkOutDay)throws Exception{
        this.arrivalFrom = arrivalFrom;
        this.departureTo = departureTo;
        this.checkInDay  = checkInDay;
        this.checkOutDay = checkOutDay;
        fout = new FileWriter("rentability.txt", true);
        BufferedWriter bw = new BufferedWriter(fout);
        
        StringBuilder inDays = new StringBuilder();
        StringBuilder outDays = new StringBuilder();
        
        for( String s: this.checkInDay)
            inDays.append(s+",");
        
        for( String s: this.checkOutDay)
            outDays.append(s+",");
        
        String write = arrivalFrom.toInstant().toString()+" \t"+ departureTo.toInstant().toString()+" \t"+inDays.toString()+" \t"+outDays.toString()+"\r\n";
        
        bw.write(write);
        bw.close();
    }
    
    Rentability(Date arrivalFrom, Date departureTo, List checkInDay, List checkOutDay, int minstay, int maxstay)throws Exception{
        this.arrivalFrom = arrivalFrom;
        this.departureTo = departureTo;
        this.checkInDay  = checkInDay;
        this.checkOutDay = checkOutDay;
        this.minStay     = minstay;
        this.maxStay     = maxstay;
        
        fout = new FileWriter("rentability.txt", true);
        BufferedWriter bw = new BufferedWriter(fout);
        
       
        
        StringBuilder inDays = new StringBuilder();
        StringBuilder outDays = new StringBuilder();
        
        for( String s: this.checkInDay)
            inDays.append(s+",");
        
        for( String s: this.checkOutDay)
            outDays.append(s+",");
        
        String write = this.arrivalFrom.toInstant().toString()+" \t"+ this.departureTo.toInstant().toString()+" \t"+ inDays.toString()+" \t"+outDays.toString()+" \t"+ this.minStay+" \t"+this.maxStay+"\r\n";
        bw.write(write);
        bw.close();
    }
}


class Rooms{
    private final List<String> rooms = new ArrayList();
    private final Connection con;
    private final Statement stmt;
    private final PreparedStatement pstmt;
    
        
    
    Rooms() throws Exception{ 
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();                

                this.con = DriverManager.getConnection("jdbc:derby://localhost:1527/hotel_management","hotel","hotel123");
                this.stmt = con.createStatement();
                
                String query = "INSERT INTO HOTEL.ROOM(CODE) VALUES (?)";
                this.pstmt = con.prepareStatement(query);

                ResultSet rs = stmt.executeQuery("SELECT code from HOTEL.ROOM");

                while(rs.next()){
                    rooms.add(rs.getString("code"));
                }
        }
        
    public String addRoom(String code){
        int ack= 0;
        String ret="";
        try{
            pstmt.setString(1, code);
            ack = pstmt.executeUpdate();
            
        if(ack == 1){
            this.rooms.add(code);
            ret="Room Added Successfully";
        }
        else
            ret="rooms not added successfully";
        }
        catch(SQLException e){
            e.getMessage();
        }
        
        return ret;    
    }
    
    
    public void deleteRoom(String code){
        int ack=0;
        String delQuery = "DELETE FROM HOTEL.ROOM WHERE CODE=?";
               
        try{
            PreparedStatement del = this.con.prepareStatement(delQuery);
            del.setString(1, code);
            ack = del.executeUpdate();
        }
        catch(SQLException e){
            e.getMessage();
        }
        if(ack==1){
            this.rooms.remove(code);
            System.out.println("room deleted");
        }
        else
            System.out.println("Not Deleted");
        
    }
    
    
    public void getRooms(){
        System.out.println(rooms);
    }
    
    
    public boolean contains(String code){
       return rooms.contains(code);    
    }
    
    
    public boolean isBookable(Long room_id, Date arrival_date, Date departure_date){
        return true;
    }
    
}
public class BookRoom {

    /**
     Get rentability details here.
     */
    
    
    public static void setRentability()throws Exception{
        char c;
        Scanner in = new Scanner(System.in);
        Date arrivalFrom = new Date();
        Date departureTo = new Date();
        List <String> checkInDay = new ArrayList();
        List <String> checkOutDay= new ArrayList();
        int minStay;
        int maxStay;
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter Arrival Date");
        arrivalFrom = df.parse(in.nextLine());
        
        System.out.println("Enter departure date");
        departureTo = df.parse(in.nextLine());
        
        
        System.out.println("Enter Check in Days");
        String days = in.nextLine();
        String [] daysArray = new String[days.length()];
        daysArray = days.split(" ");
        for(String day: daysArray){
            checkInDay.add(day);
        }
        
        System.out.println("Enter Check Out Days");
        String checkOutDays = in.nextLine();
        String [] checkOutDaysArray = new String[checkOutDays.length()];
        checkOutDaysArray = checkOutDays.split(" ");
        for(String day: checkOutDaysArray){
            checkOutDay.add(day);
        }
        
        System.out.println("Do you want to set minimum and maximum stay? Y/N");
        
        c = in.next().charAt(0);
        if(c == 'Y'){
            minStay = in.nextInt();
            maxStay = in.nextInt();
            
            Rentability R1 = new Rentability(arrivalFrom, departureTo, checkInDay, checkOutDay, minStay, maxStay);
            
        }
        else if(c=='N'){
            Rentability R2 = new Rentability(arrivalFrom, departureTo, checkInDay, checkOutDay);
        }   
    }
    
    public static void bookroom(){
        
    }
    
    public static void main(String[] args)throws Exception {
        
        Scanner in = new Scanner(System.in);
        Byte choice ;
        String code ;
        
        Rooms room = new Rooms();
        
        while(true){
        System.out.println("Choose Option:\n 1. Add Room\n 2. Delete Room\n 3. set reantability\n 4. Book\n 5. Get Rooms\n 6. Exit");
        choice = in.nextByte();
        in.nextLine();
        
        switch(choice){
            case 1:
                System.out.println("Enter room code");
                code = in.nextLine();
                        if(room.contains(code))
                            System.out.println("Alredy added");
                        else{
                            System.out.println(room.addRoom(code));
                        }
                while(true){
                    System.out.println("want to add new room? Y/N");
                    char c = in.next().charAt(0);
                    if(c=='Y'){
                        System.out.println("Enter Room Code");
                        in.nextLine();
                        code = in.nextLine();
                        
                       if(room.contains(code))
                            System.out.println("Alredy added");
                       else{
                        room.addRoom(code);
                        System.out.println("room added successfully");
                       }
                    }
                    else if(c=='N'){
                        break;
                    }
                    else{
                        System.out.println("wrong input");
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Enter room code");
                code = in.nextLine();
                room.deleteRoom(code);
                while(true){
                    System.out.println("want to delete room? Y/N");
                    char c = in.next().charAt(0);
                    if(c=='Y'){
                        System.out.println("Enter Room code");
                        code = in.nextLine();
                        in.nextLine();
                        room.deleteRoom(code);
                    }
                    else if(c=='N'){
                        break;
                    }
                    else{
                        System.out.println("wrong input");
                        break;
                    }
                }
                break;
            case 3:
                setRentability();
                break;
            case 4:
                bookroom();
                break;
            case 5:
                room.getRooms();
                break;
                
            case 6:
                System.exit(0);
                break;
                
            default:
                System.out.println("Wrong Input try again");
                break;
        
        }
    }
    }
    
}

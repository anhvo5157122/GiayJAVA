/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connection {
     public static Connection getConnection(){
         Connection con = null;
         String name="root";
         String pass="";
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlbg",name,pass);
             
         }catch(Exception e){
             System.out.println(e);
         }
         return con;
         
     }
     public static void closeConnection(Connection c){
         try{
             c.close();
         }catch(Exception e){
             System.out.println(e);
         }
         
     }
     public static void main(String[] args) {
        Connection con  = getConnection();
        if(con !=null){
            System.out.println("Thành công ");
        } else{
            System.out.println("Thất bại");
        }
        
    }
}

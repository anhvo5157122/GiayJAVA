/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.account;
import DTO.connection;/**
 *
 * @author it200
 */

public class accountDAL {
    static Connection con = connection.getConnection();
    public static void main(String[] args) {
        account c = new account("IT2001.sgu","IT2001.sgu",3);
        if(addAccount(c)>0) System.out.println("Thanh cong");
    }
    public static int addAccount(account a){
        try{
            String sql = "INSERT INTO taikhoan (TenTaiKhoan, MatKhau, Quen) VALUES ('"+a.getUsername()+"','"+a.getPassword()+"',"+a.getPower()+")";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql);
            return i;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static int updateAccount(account a){
        try{
            String sql = "UPDATE taikhoan SET MatKhau = '"+a.getPassword()+"', Quen = "+a.getPower();
            Statement st = con.createStatement();
            int i =st.executeUpdate(sql);
            return i;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static int deleteAccount(String username){
        try{
            String sql= "DELETE taikhoan WHERE TenTaiKhoan LIKE "+username;
            Statement st = con.createStatement();
            int i =st.executeUpdate(sql);
            return i;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static ArrayList<account> readAccount(){
        try{
            String sql = "SELECT * FROM taikhoan";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<account> listAccount = new ArrayList<>();
            while(rs.next()){
                account a = new account();
                a.setUsername(rs.getString("TenTaiKhoan"));
                a.setPassword(rs.getString("MatKhau"));
                a.setPower(rs.getInt("Quen"));
                listAccount.add(a);
            }
            return listAccount;
            
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static account getAccountByUsername(String username){
        try{
            String sql = "SELECT * FROM taikhoan WHERE TenTaiKhoan LIKE '"+username+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            account a =new account();
            while(rs.next()){
                a.setUsername(rs.getString("TenTaiKhoan"));
                a.setPassword(rs.getString("MatKhau"));
                a.setPower(rs.getInt("Quen"));
            }
            return a;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
       return null;
    }
    
}

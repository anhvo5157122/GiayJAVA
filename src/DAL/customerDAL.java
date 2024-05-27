/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.connection;
import DTO.customer;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author it200
 */
public class customerDAL {
    static Connection con = connection.getConnection();
    public static void main(String[] args) {
        customer c = new customer("Võ Ngọc Anh","0123456782",1000);
        System.out.println(addCustomer(c));
    }
    public static int addCustomer(customer c){
        try{
            String sql = "INSERT INTO khachhang (TenKhachHang, SoDienThoai, TichDiem) VALUES ('"+c.getCustomerName()+"','"+c.getPhone()+"','"+c.getPoint()+"')";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql);
            return i;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static int deleteCustomer(int id){
        try{
            String sql = "DELETE FROM khachhang WHERE MaKhachHang = "+id;
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql);
            return i;
            
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static int updateCustomer(customer c){
        try{
            String sql =  "UPDATE khachhang SET TenKhachHang = '"+c.getCustomerName()+"', SoDienThoai = '"+c.getPhone()+"', TichDiem = "+c.getPoint()+" WHERE MaKhachHang  = "+c.getCustomerId();
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql);
            return i;
            
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static ArrayList<customer> readCustomer(){
        try{
            String sql = "SELECT * FROM khachhang";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<customer> listCustomer = new ArrayList<>();
            while(rs.next()){
                customer c = new customer();
                c.setCustomerId(rs.getInt("MaKhachHang"));
                c.setCustomerName(rs.getString("TenKhachHang"));
                c.setPhone(rs.getString("SoDienThoai"));
                c.setPoint(rs.getInt("TichDiem"));
                listCustomer.add(c);
            }
            return listCustomer;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static customer getCustomerByPhone(int phone){
        try{
            String sql = "SELECT * FROM khachhang WHERE SoDienThoai = "+phone;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            customer c= new customer();
            while(rs.next()){
                c.setCustomerId(rs.getInt("MaKhachHang"));
                c.setCustomerName(rs.getString("TenKhachHang"));
                c.setPhone(rs.getString("SoDienThoai"));
                c.setPoint(rs.getInt("TichDiem"));
                
            }
            return c;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static customer getCustomerById(int id){
        try{
            String sql = "SELECT * FROM khachhang WHERE MaKhachHang = "+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            customer c= new customer();
            while(rs.next()){
                c.setCustomerName(rs.getString("TenKhachHang"));
                c.setPhone(rs.getString("SoDienThoai"));
                c.setPoint(rs.getInt("TichDiem"));
                
            }
            return c;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<customer> getCustomerByName(String name){
        try{
            String sql = "SELECT * FROM khachhang WHERE TenKhachHang LIKE '%"+name+"%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<customer> listCustomer = new ArrayList<>();
            while(rs.next()){
                customer c = new customer();
                c.setCustomerId(rs.getInt("MaKhachHang"));
                c.setCustomerName(rs.getString("TenKhachHang"));
                c.setPhone(rs.getString("SoDienThoai"));
                c.setPoint(rs.getInt("TichDiem"));
                listCustomer.add(c);
            }
            return listCustomer;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<customer> searchCustomerById(String id){
        try{
            String sql = "SELECT * FROM khachhang WHERE MaKhachHang LIKE '%"+id+"%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<customer> listCustomer = new ArrayList<>();
            while(rs.next()){
                customer c = new customer();
                c.setCustomerId(rs.getInt("MaKhachHang"));
                c.setCustomerName(rs.getString("TenKhachHang"));
                c.setPhone(rs.getString("SoDienThoai"));
                c.setPoint(rs.getInt("TichDiem"));
                listCustomer.add(c);
            }
            return listCustomer;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<customer> searchCustomerByPhone(String phone){
        try{
            String sql = "SELECT * FROM khachhang WHERE SoDienThoai LIKE '%"+phone+"%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<customer> listCustomer = new ArrayList<>();
            while(rs.next()){
                customer c = new customer();
                c.setCustomerId(rs.getInt("MaKhachHang"));
                c.setCustomerName(rs.getString("TenKhachHang"));
                c.setPhone(rs.getString("SoDienThoai"));
                c.setPoint(rs.getInt("TichDiem"));
                listCustomer.add(c);
            }
            return listCustomer;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
}

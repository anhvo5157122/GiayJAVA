/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.connection;
import DTO.supplier;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author it200
 */
public class supplierDAL {
    private static Connection con = connection.getConnection();
    public static void main(String[] args) {
//        supplier s = new supplier(1,"ADIDAS","0123456788");
//        
//        System.out.println(updateSupplier(s));
//        if(addSupplier(s)>0){
//            System.out.println("Thành công");
//        }
//            System.out.println(deleteSupplier(3));
            System.out.println(getSupplierById(1).getSupplierName());
            System.out.println(getSupplierByName("Puma").getSupplierName());
    }
    public static int addSupplier(supplier s){
        try{
            String sql = "INSERT INTO nhacungcap (TenNhaCungCap, SoDienThoai) VALUES ('"+s.getSupplierName()+"','"+s.getPhone()+"')";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql);
            return i;
            
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static int deleteSupplier(int id){
        try{
            String sql = "DELETE FROM nhacungcap WHERE MaNhaCungCap ="+id;
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql);
            return i;
        }catch(Exception e ){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static int updateSupplier(supplier s){
            try{
                String sql = "UPDATE nhacungcap SET TenNhaCungCap = '"+s.getSupplierName()+"', SoDienThoai='"+s.getPhone()+"' WHERE MaNhaCungCap = "+ s.getSupplierId();
                Statement st = con.createStatement();
                int i  = st.executeUpdate(sql);
                return i;
            }catch(Exception e){
                System.out.println(e);
            }
            connection.closeConnection(con);
        
        return 0;
    }
    public static supplier getSupplierById(int id){
        try{
              supplier s = new supplier();
              String sql = "SELECT * FROM nhacungcap WHERE MaNhaCungCap = "+ id;
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(sql);
              while(rs.next()){
                  s.setSupplierId(id);
                  s.setSupplierName(rs.getString("TenNhaCungCap"));
                  s.setPhone(rs.getString("SoDienThoai"));
                  
              }
              return s;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static supplier getSupplierByName(String name ){
        try{
              supplier s = new supplier();
              String sql = "SELECT * FROM nhacungcap WHERE TenNhaCungCap LIKE '"+name+"'";
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(sql);
              while(rs.next()){
                  s.setSupplierId(rs.getInt("MaNhaCungCap"));
                  s.setSupplierName(rs.getString("TenNhaCungCap"));
                  s.setPhone(rs.getString("SoDienThoai"));
              }
              return s;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    
    public static ArrayList<supplier> searchById(String id){
        ArrayList<supplier> listSuppList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM nhacungcap WHERE MaNhaCungCap LIKE '%"+id+"%'";
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                supplier s = new supplier();
                s.setSupplierId(rs.getInt("MaNhaCungCap"));
                s.setSupplierName(rs.getString("TenNhaCungCap"));
                s.setPhone(rs.getString("SoDienThoai"));
                listSuppList.add(s);
            }
            return listSuppList;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<supplier> searchByName(String name){
        ArrayList<supplier> listSuppList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM nhacungcap WHERE TenNhaCungCap LIKE '%"+name+"%'";
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                supplier s = new supplier();
                s.setSupplierId(rs.getInt("MaNhaCungCap"));
                s.setSupplierName(rs.getString("TenNhaCungCap"));
                s.setPhone(rs.getString("SoDienThoai"));
                listSuppList.add(s);
            }
            return listSuppList;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<supplier> searchByNameAZ(){
        ArrayList<supplier> listSuppList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM nhacungcap ORDER BY TenNhaCungCap ASC";
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                supplier s = new supplier();
                s.setSupplierId(rs.getInt("MaNhaCungCap"));
                s.setSupplierName(rs.getString("TenNhaCungCap"));
                s.setPhone(rs.getString("SoDienThoai"));
                listSuppList.add(s);
            }
            return listSuppList;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<supplier> searchByNameZA(){
        ArrayList<supplier> listSuppList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM nhacungcap ORDER BY TenNhaCungCap DESC";
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                supplier s = new supplier();
                s.setSupplierId(rs.getInt("MaNhaCungCap"));
                s.setSupplierName(rs.getString("TenNhaCungCap"));
                s.setPhone(rs.getString("SoDienThoai"));
                listSuppList.add(s);
            }
            return listSuppList;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<supplier> searchByPhone(String phone){
        ArrayList<supplier> listSuppList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM nhacungcap WHERE SoDienThoai LIKE '%"+phone+"%'";
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                supplier s = new supplier();
                s.setSupplierId(rs.getInt("MaNhaCungCap"));
                s.setSupplierName(rs.getString("TenNhaCungCap"));
                s.setPhone(rs.getString("SoDienThoai"));
                listSuppList.add(s);
            }
            return listSuppList;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<supplier> readSupplier(){
        ArrayList<supplier> listSuppList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM nhacungcap";
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                supplier s = new supplier();
                s.setSupplierId(rs.getInt("MaNhaCungCap"));
                s.setSupplierName(rs.getString("TenNhaCungCap"));
                s.setPhone(rs.getString("SoDienThoai"));
                listSuppList.add(s);
            }
            return listSuppList;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.connection;

/**
 *
 * @author it200
 */
import DTO.connection;
import DTO.staff;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class staffDAL {
    static Connection con = connection.getConnection();
    public static void main(String[] args) {
        staff s = new staff("admin", "Nguyễn Tài Hà", "0327348069", "VN", "admin", 2);
//        int i = addStaff(s);
//        if(deleteStaff("admin")>1) System.out.println("Thanh cong");
        for(staff a : readStaff()){
            System.out.println(a.getAddress());
        }
    }
    public static int addStaff(staff s){
        try{
            String sql_staff = "INSERT INTO nhanvien(MaNhanVien, TenNhanVien, SoDienThoai, DiaChi) VALUES ('"+s.getStaffId()+"','"+s.getStaffName()+"','"+s.getPhone()+"','"+s.getAddress()+"')";
            String sql_account = "INSERT INTO taikhoan(TenTaiKhoan, MatKhau, Quen) VALUES ('"+s.getStaffId()+"','"+s.getPassword()+"','"+s.getPower()+"')";
            Statement stm = con.createStatement();
            int i  = stm.executeUpdate(sql_staff);
            if(i>0){
                if(stm.executeUpdate(sql_account)>0) return i;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static int updateStaff(staff s){
        try{
            String sql_staff = "UPDATE nhanvien set TenNhanVien = '"+s.getStaffName()+"', SoDienThoai = '"+s.getPhone()+"', DiaChi = '"+s.getAddress()+"' WHERE MaNhanVien = '"+s.getStaffId()+"'";
            String sql_account = "UPDATE taikhoan set MatKhau = '"+s.getPassword()+"', Quen= '"+s.getPower()+"' WHERE TenTaiKhoan = '"+s.getStaffId()+"'";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_staff);
            int j = st.executeUpdate(sql_account);
            return i+j;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return 0;
    }
    public static int deleteStaff(String id){
        try{
            String sql_account = "DELETE FROM taikhoan WHERE TenTaiKhoan = '"+id+"'";
            String sql_staff = "DELETE FROM nhanvien WHERE MaNhanVien = '"+id+"'";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_account);
            if(i>0){
                if(st.executeUpdate(sql_staff)>0) return i;
            }
        }catch(Exception e){
            System.out.println(e);
        }
//        connection.closeConnection(con);
        return 0;
    }
    public static ArrayList<staff> readStaff(){
        try{
            String sql = "SELECT * FROM nhanvien n JOIN taikhoan t ON n.MaNhanVien = t.TenTaiKhoan";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<staff> list = new ArrayList<>();
            while(rs.next()){
                staff s = new staff();
                s.setStaffId(rs.getString("n.MaNhanVien"));
                s.setAddress(rs.getString("DiaChi"));
                s.setPhone(rs.getString("SoDienThoai"));
                s.setStaffName(rs.getString("TenNhanVien"));
                s.setPower(rs.getInt("Quen"));
                s.setPassword(rs.getString("MatKhau"));
                list.add(s);
                
            }
            return list;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static staff getStaffById(String id){
        try{
            String sql ="SELECT * FROM nhanvien n JOIN taikhoan t ON n.MaNhanVien = t.TenTaiKhoan WHERE n.MaNhanVien ='"+id+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            staff s = new staff();
            while(rs.next()){
                
                s.setStaffId(rs.getString("n.MaNhanVien"));
                s.setAddress(rs.getString("DiaChi"));
                s.setPhone(rs.getString("SoDienThoai"));
                s.setStaffName(rs.getString("TenNhanVien"));
                s.setPower(rs.getInt("Quen"));
                s.setPassword(rs.getString("MatKhau"));
                
                
            }
            return s;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
     public static staff GetByUsername(String id){
        try{
            String sql = "SELECT * FROM nhanvien  WHERE MaNhanVien LIKE '"+id+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
           staff s = new staff();
            while(rs.next()){
                s.setStaffId(id);
            }
            return s;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<staff> searchById(String id){
        try{
            String sql = "SELECT * FROM nhanvien n JOIN taikhoan t ON n.MaNhanVien = t.TenTaiKhoan WHERE n.MaNhanVien LIKE '%"+id+"%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<staff> list = new ArrayList<>();
            while(rs.next()){
                staff s = new staff();
                s.setStaffId(rs.getString("n.MaNhanVien"));
                s.setAddress(rs.getString("DiaChi"));
                s.setPhone(rs.getString("SoDienThoai"));
                s.setStaffName(rs.getString("TenNhanVien"));
                s.setPower(rs.getInt("Quen"));
                s.setPassword(rs.getString("MatKhau"));
                list.add(s);
                
            }
            return list;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<staff> searchByPhone(String phone){
        try{
            String sql = "SELECT * FROM nhanvien n JOIN taikhoan t ON n.MaNhanVien = t.TenTaiKhoan WHERE SoDienThoai LIKE '%"+phone+"%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<staff> list = new ArrayList<>();
            while(rs.next()){
                staff s = new staff();
                s.setStaffId(rs.getString("n.MaNhanVien"));
                s.setAddress(rs.getString("DiaChi"));
                s.setPhone(rs.getString("SoDienThoai"));
                s.setStaffName(rs.getString("TenNhanVien"));
                s.setPower(rs.getInt("Quen"));
                s.setPassword(rs.getString("MatKhau"));
                list.add(s);
                
            }
            return list;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
    public static ArrayList<staff> searchByName(String name){
        try{
            String sql = "SELECT * FROM nhanvien n JOIN taikhoan t ON n.MaNhanVien = t.TenTaiKhoan WHERE TenNhanVien LIKE '%"+name+"%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<staff> list = new ArrayList<>();
            while(rs.next()){
                staff s = new staff();
                s.setStaffId(rs.getString("n.MaNhanVien"));
                s.setAddress(rs.getString("DiaChi"));
                s.setPhone(rs.getString("SoDienThoai"));
                s.setStaffName(rs.getString("TenNhanVien"));
                s.setPower(rs.getInt("Quen"));
                s.setPassword(rs.getString("MatKhau"));
                list.add(s);
                
            }
            return list;
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection(con);
        return null;
    }
}

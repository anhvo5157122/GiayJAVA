/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.bill;
import DTO.billPay;
import DTO.connection;
import DTO.infoBillPay;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class billPayDAL {
    static Connection con = connection.getConnection();
    
    
    public static int addBillPay(billPay b){
        try{
            String sql_bill = "INSERT INTO hoadonbanhang(MaNhanVien, MaKhachHang, ThanhTien, NgayLap) VALUES ('"+b.getStaffId()+"','"+b.getCustomerId()+"','"+b.getTotal()+"','"+b.getDate()+"')";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        
        
        
        return 0;
    }
    public static int addBillPayInfo(infoBillPay b){
        try{
            String sql_bill = "INSERT INTO chitiethoadonbanhang(MaHoaDonBanHang, MaSanPham, SoLuong,Gia ,ThanhTien) VALUES ('"+b.getBillId()+"','"+b.getProductId()+"','"+b.getQuantity()+"','"+b.getPrice()+"','"+b.getTotal()+"')";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        return 0;
    }
    public static billPay getBillPay(){
        try{
            String sql = "SELECT * FROM hoadonbanhang ORDER BY MaHoaDonBanHang DESC LIMIT 1";
            Statement st = con.createStatement();
            billPay b = new billPay();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                b.setBillId(rs.getInt("MaHoaDonBanHang"));
            }
            return b;
        }catch(Exception e){
            System.out.println(e);
        }
        
        return null;
    }
    public static ArrayList<billPay> listBill(){
        try{
            String sql = "SELECT * FROM hoadonbanhang ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<billPay> list = new ArrayList<>();
            while(rs.next()){
                billPay b = new billPay();
                b.setBillId(rs.getInt("MaHoaDonBanHang"));
                b.setStaffId(rs.getString("MaNhanVien"));
                b.setCustomerId(rs.getInt("MaKhachHang"));
                b.setTotal(rs.getFloat("ThanhTien"));
                b.setDate(rs.getString("NgayLap"));
                list.add(b);
            }
            return list;
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        
        return null;
    }
    public static ArrayList<infoBillPay> listBillInfo(int id){
        try{
            String sql = "SELECT * FROM chitiethoadonbanhang WHERE MaHoaDonBanHang LIKE "+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<infoBillPay> list = new ArrayList<>();
            while(rs.next()){
                infoBillPay b = new infoBillPay();
                b.setBillId(id);
                b.setInfoBillId(rs.getInt("MaChiTietHoaDon"));
                b.setProductId(rs.getInt("MaSanPham"));
                b.setQuantity(rs.getInt("SoLuong"));
                b.setPrice(rs.getFloat("Gia"));
                b.setTotal(rs.getFloat("ThanhTien"));
                list.add(b);
            }
            return list;
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        
        return null;
    }
    public static int deleteBillPay(int id){
        try{
            String sql_bill = "DELETE FROM hoadonbanhang WHERE MaHoaDonBanHang LIKE "+id;
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        
        
        
        return 0;
    }
    public static int deleteBillPayInfo(int id ){
        try{
            String sql_bill = "DELETE FROM chitiethoadonbanhang WHERE MaHoaDonBanHang LIKE "+id;
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        return 0;
    }
}

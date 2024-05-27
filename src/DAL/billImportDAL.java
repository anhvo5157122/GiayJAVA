/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.billImport;
import DTO.connection;
import DTO.infoBillImport;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author it200
 */
public class billImportDAL {
    static Connection con = connection.getConnection();
    public static void main(String[] args) {
        infoBillImport i = new infoBillImport();
        i.setPrice(20000);
        i.setBillImportId(7);
        i.setInfoBillId(4);
        i.setQuantity(2);
        i.setTotal(i.getQuantity()*i.getPrice());
        System.out.println(updateBillImportinfo(i));
    }
    
    public static int addBillImport(billImport b){
        try{
            String sql_bill = "INSERT INTO hoadonnhaphang(MaNhanVien, MaNhaCungCap, ThanhTien, NgayLap) VALUES ('"+b.getStaffId()+"','"+b.getSupplierId()+"','"+b.getTotal()+"','"+b.getDate()+"')";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        return 0;
    }
    public static int addBillImportInfo(infoBillImport b){
        try{
            String sql_bill = "INSERT INTO chitiethoadonnhaphang(MaHoaDonNhapHang, MaSanPham, SoLuong,Gia ,TongTien) VALUES ('"+b.getBillImportId()+"','"+b.getProductId()+"','"+b.getQuantity()+"','"+b.getPrice()+"','"+b.getTotal()+"')";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        return 0;
    }
    public static billImport getBillImport(){
        try{
            String sql = "SELECT * FROM hoadonnhaphang ORDER BY MaHoaDonNhapHang DESC LIMIT 1";
            Statement st = con.createStatement();
            billImport b = new billImport();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                b.setBillId(rs.getInt("MaHoaDonNhapHang"));
            }
            return b;
        }catch(Exception e){
            System.out.println(e);
        }
        
        return null;
    }
    public static infoBillImport getBillImportInfo(int id){
        try{
            String sql = "SELECT * FROM chitiethoadonnhaphang WHERE MaChiTietHoaDonNhapHang LIKE "+id;
            Statement st = con.createStatement();
            infoBillImport b = new infoBillImport();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                b.setBillImportId(rs.getInt("MaHoaDonNhapHang"));
                b.setInfoBillId(rs.getInt("MaChiTietHoaDonNhapHang"));
                b.setQuantity(rs.getInt("SoLuong"));
                b.setPrice(rs.getFloat("Gia"));
            }
            return b;
        }catch(Exception e){
            System.out.println(e);
        }
        
        return null;
    }
    public static ArrayList<billImport> listBill(){
        try{
            String sql = "SELECT * FROM hoadonnhaphang ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<billImport> list = new ArrayList<>();
            while(rs.next()){
                billImport b = new billImport();
                b.setBillId(rs.getInt("MaHoaDonNhapHang"));
                b.setStaffId(rs.getString("MaNhanVien"));
                b.setSupplierId(rs.getInt("MaNhaCungCap"));
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
    public static ArrayList<infoBillImport> listBillInfo(int id){
        try{
            String sql = "SELECT * FROM chitiethoadonnhaphang WHERE MaHoaDonNhapHang LIKE "+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<infoBillImport> list = new ArrayList<>();
            while(rs.next()){
                infoBillImport b = new infoBillImport();
                b.setBillImportId(id);
                b.setInfoBillId(rs.getInt("MaChiTietHoaDonNhapHang"));
                b.setProductId(rs.getInt("MaSanPham"));
                b.setQuantity(rs.getInt("SoLuong"));
                b.setPrice(rs.getFloat("Gia"));
                b.setTotal(rs.getFloat("TongTien"));
                list.add(b);
            }
            return list;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static int deleteBillImport(int id){
        try{
            String sql_bill = "DELETE FROM hoadonnhaphang WHERE MaHoaDonNhapHang LIKE "+id;
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        
        
        
        return 0;
    }
    public static int deleteBillImportInfo(int id ){
        try{
            String sql_bill = "DELETE FROM chitiethoadonnhaphang WHERE MaHoaDonNhapHang LIKE "+id;
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        return 0;
    }
    public static int deleteBillImportInfoBid(int id ){
        try{
            String sql_bill = "DELETE FROM chitiethoadonnhaphang WHERE MaChiTietHoaDonNhapHang LIKE "+id;
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        return 0;
    }
    public static float getTotal(int id){
        try{
            float total=0;
            String sql ="SELECT MaHoaDonNhapHang, SUM(TongTien) AS TongTien FROM chitiethoadonnhaphang WHERE MaHoaDonNhapHang LIKE "+id+" ORDER BY MaHoaDonNhapHang";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                total = total+ rs.getFloat("TongTien");
            }
            return total;
        }catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    public static int updateBillImport(float total, int id){
        try{
             
            String sql_bill = "UPDATE hoadonnhaphang SET ThanhTien = "+total+" WHERE MaHoaDonNhapHang LIKE "+id;
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql_bill);
            if(i>0) return i;
        }
        catch(Exception e){
            System.out.println(e);   
        }
        return 0;
    }
    public static int updateBillImportinfo(infoBillImport bill){
        try{
             
            String sql_bill = "UPDATE chitiethoadonnhaphang SET SoLuong = "+bill.getQuantity()+",TongTien = "+bill.getTotal()+" WHERE MaChiTietHoaDonNhapHang LIKE "+bill.getInfoBillId();
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

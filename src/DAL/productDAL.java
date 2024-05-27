/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.connection;
import DTO.product;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class productDAL {
    static Connection con = connection.getConnection();
    public static void main(String[] args) {
        product p = new product("giay", 10000, 0, 2, "qqqq", "trang");
        for(product a : load("-----", "Cao - Thấp", "Xanh")){
            System.out.println(a.getColor());
        }
    }
    public static int addProduct(product p){
        try{
            String sql = "INSERT INTO sanpham(TenSanPham, Gia, SoLuong, NhaCungCap, HinhAnh, Mau) VALUES ('"+p.getProductName()+"','"+p.getPrice()+"','"+p.getQuantity()+"','"+p.getSupplierId()+"','"+p.getImage()+"','"+p.getColor()+"')";
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql);
            if(i>0) return i;
        }catch(Exception e){
            System.out.println(e);
        }
        
        return 0;
    }
    public static int updateProduct(product p){
        try{
            String sql = "UPDATE sanpham SET TenSanPham ='"+p.getProductName()+"', Gia= '"+p.getPrice()+"', SoLuong= '"+p.getQuantity()+"', NhaCungCap= '"+p.getSupplierId()+"', HinhAnh = '"+p.getImage()+"', Mau='"+p.getColor()+"' WHERE MaSanPham = "+p.getId();
            Statement st = con.createStatement();
            int i =st.executeUpdate(sql);
            if(i>0) return i;
        }catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    public static int deleteProduct(int id){
        try{
            String sql = "DELETE FROM sanpham WHERE MaSanPham ="+id;
            Statement st = con.createStatement();
            int i = st.executeUpdate(sql);
            if(i>0) return i;
        }catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    public static ArrayList<product> readProduct(){
        try{
            String sql = "SELECT * FROM sanpham";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<product> list = new ArrayList<>();
            while(rs.next()){
                product p = new product();
                p.setId(rs.getInt("MaSanPham"));
                p.setProductName(rs.getString("TenSanPham"));
                p.setPrice(rs.getFloat("Gia"));
                p.setSupplierId(rs.getInt("NhaCungCap"));
                p.setQuantity(rs.getInt("SoLuong"));
                p.setImage(rs.getString("HinhAnh"));
                p.setColor(rs.getString("Mau"));
                list.add(p);
            }
            return list;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static ArrayList<product> readProductBySupplier(int supplierId ){
        try{
            String sql = "SELECT * FROM sanpham WHERE NhaCungCap = "+supplierId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<product> list = new ArrayList<>();
            while(rs.next()){
                product p = new product();
                p.setId(rs.getInt("MaSanPham"));
                p.setProductName(rs.getString("TenSanPham"));
                p.setPrice(rs.getFloat("Gia"));
                p.setSupplierId(rs.getInt("NhaCungCap"));
                p.setQuantity(rs.getInt("SoLuong"));
                p.setImage(rs.getString("HinhAnh"));
                p.setColor(rs.getString("Mau"));
                list.add(p);
            }
            return list;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static product getProductById(int id){
        try{
            String sql = "SELECT * FROM sanpham WHERE MaSanPham = "+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
           product p = new product();
            while(rs.next()){
                
                p.setId(rs.getInt("MaSanPham"));
                p.setProductName(rs.getString("TenSanPham"));
                p.setPrice(rs.getFloat("Gia"));
                p.setSupplierId(rs.getInt("NhaCungCap"));
                p.setQuantity(rs.getInt("SoLuong"));
                p.setImage(rs.getString("HinhAnh"));
                p.setColor(rs.getString("Mau"));
                
            }
            return p;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    public static ArrayList<product> searchProductById(String id){
        try{
            String sql = "SELECT * FROM sanpham WHERE MaSanPham LIKE '%"+id+"%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<product> list = new ArrayList<>();
            while(rs.next()){
                product p = new product();
                p.setId(rs.getInt("MaSanPham"));
                p.setProductName(rs.getString("TenSanPham"));
                p.setPrice(rs.getFloat("Gia"));
                p.setSupplierId(rs.getInt("NhaCungCap"));
                p.setQuantity(rs.getInt("SoLuong"));
                p.setImage(rs.getString("HinhAnh"));
                p.setColor(rs.getString("Mau"));
                list.add(p);
            }
            return list;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static ArrayList<product> searchProductByName(String name){
        try{
            String sql = "SELECT * FROM sanpham WHERE TenSanPham LIKE '%"+name+"%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<product> list = new ArrayList<>();
            while(rs.next()){
                product p = new product();
                p.setId(rs.getInt("MaSanPham"));
                p.setProductName(rs.getString("TenSanPham"));
                p.setPrice(rs.getFloat("Gia"));
                p.setSupplierId(rs.getInt("NhaCungCap"));
                p.setQuantity(rs.getInt("SoLuong"));
                p.setImage(rs.getString("HinhAnh"));
                p.setColor(rs.getString("Mau"));
                list.add(p);
            }
            return list;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static ArrayList<product> returnList(String sql){
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<product> list = new ArrayList<>();
            while(rs.next()){
                product p = new product();
                p.setId(rs.getInt("MaSanPham"));
                p.setProductName(rs.getString("TenSanPham"));
                p.setPrice(rs.getFloat("Gia"));
                p.setSupplierId(rs.getInt("NhaCungCap"));
                p.setQuantity(rs.getInt("SoLuong"));
                p.setImage(rs.getString("HinhAnh"));
                p.setColor(rs.getString("Mau"));
                list.add(p);
            }
            return list;
            
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static ArrayList<product> load(String pubblishId, String price, String color){
        // price
        if(price.equals("Cao - Thấp")&&pubblishId.equals("-----")&&color.equals("-----")){
                String sql = "SELECT * FROM sanpham ORDER BY Gia DESC ";
                
                return returnList(sql);        
        }
        else if(price.equals("Thấp - Cao")&&pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham ORDER BY Gia ASC ";
                
                return returnList(sql);  
        }
        else if(price.equals("100 - 200")&&pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 100000 AND Gia <= 200000 ";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("200 - 500")&&pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 200000 AND Gia <= 500000 ";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("500 - 1000")&&pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 500000 AND Gia <= 1000000 ";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("Trên 1000")&&pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia > 1000000 ";
                System.out.println("a");
                return returnList(sql);  
        }
        // price + NCC
        else if(price.equals("Cao - Thấp")&&!pubblishId.equals("-----")&&color.equals("-----")){
                String sql = "SELECT * FROM sanpham WHERE NhaCungCap LIKE '"+pubblishId+"' ORDER BY Gia DESC ";
                
                return returnList(sql);        
        }
        else if(price.equals("Thấp - Cao")&&!pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE NhaCungCap LIKE '"+pubblishId+"' ORDER BY Gia ASC ";
                
                return returnList(sql);  
        }
        else if(price.equals("100 - 200")&&!pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 100000 AND Gia <= 200000 AND NhaCungCap LIKE '"+pubblishId+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("200 - 500")&&!pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 200000 AND Gia <= 500000 AND NhaCungCap LIKE '"+pubblishId+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("500 - 1000")&&!pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 500000 AND Gia <= 1000000 AND NhaCungCap LIKE '"+pubblishId+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("Trên 1000")&&!pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia > 1000000 AND NhaCungCap LIKE '"+pubblishId+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        //price+NCC+color
        else if(price.equals("Cao - Thấp")&&!pubblishId.equals("-----")&&!color.equals("-----")){
                String sql = "SELECT * FROM sanpham WHERE NhaCungCap LIKE '"+pubblishId+"' AND Mau LIKE '"+color+"' ORDER BY Gia DESC";
                return returnList(sql);
        }
        else if(price.equals("Thấp - Cao")&&!pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE NhaCungCap LIKE '"+pubblishId+"' AND Mau LIKE '"+color+"' ORDER BY Gia ASC ";
                
                return returnList(sql);  
        }
        else if(price.equals("100 - 200")&&!pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 100000 AND Gia <= 200000 AND NhaCungCap LIKE '"+pubblishId+"' AND Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("200 - 500")&&!pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 200000 AND Gia <= 500000 AND NhaCungCap LIKE '"+pubblishId+"' AND Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("500 - 1000")&&!pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 500000 AND Gia <= 1000000 AND NhaCungCap LIKE '"+pubblishId+"' AND Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("Trên 1000")&&!pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia > 1000000 AND NhaCungCap LIKE '"+pubblishId+"' AND Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        
        //Price+color
        else if(price.equals("Cao - Thấp")&&pubblishId.equals("-----")&&!color.equals("-----")){
                String sql = "SELECT * FROM sanpham WHERE Mau LIKE '"+color+"' ORDER BY Gia DESC ";
                System.out.println("a1");
                return returnList(sql);        
        }
        else if(price.equals("Thấp - Cao")&&pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Mau LIKE '"+color+"' ORDER BY Gia ASC ";
                
                return returnList(sql);  
        }
        else if(price.equals("100 - 200")&&pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 100000 AND Gia <= 200000 AND Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("200 - 500")&&pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 200000 AND Gia <= 500000 AND Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("500 - 1000")&&pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia >= 500000 AND Gia <= 1000000 AND Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        else if(price.equals("Trên 1000")&&pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Gia > 1000000 AND Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        //NCC + color
        else if(price.equals("-----")&&!pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE NhaCungCap LIKE '"+pubblishId+"' AND Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        // NCC
        else if(price.equals("-----")&&!pubblishId.equals("-----")&&color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE NhaCungCap LIKE '"+pubblishId+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        //color
        else if(price.equals("-----")&&pubblishId.equals("-----")&&!color.equals("-----")){
            String sql = "SELECT * FROM sanpham WHERE Mau LIKE '"+color+"'";
                System.out.println("a");
                return returnList(sql);  
        }
        return null;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.product;
import DAL.productDAL;
import java.util.ArrayList;
public class productBLL {
    public static boolean checkPrice(float price){
        if(price<=0) return false;
        return true;
    }
    public static boolean checkName(String name){
        if(name.length() ==0) return false;
        return true;
    }
    public static int addProduct(product p){
        if(checkPrice(p.getPrice())&&checkName(p.getProductName())){
            return productDAL.addProduct(p);
        }
        return 0;
    }
    public static int updateProduct(product p){
        if(checkPrice(p.getPrice())&&checkName(p.getProductName())){
            return productDAL.updateProduct(p);
        }
        return 0;
    }
    public static int deleteProduct(int id){
        return productDAL.deleteProduct(id);
    }
    public static ArrayList<product> readProduct(){
        return productDAL.readProduct();
    }
    public static product getProductById(int id){
        return productDAL.getProductById(id);
    }
    public static ArrayList<product> searchById(String id){
        return productDAL.searchProductById(id);
    }
    public static ArrayList<product> searchByName(String name){
        return productDAL.searchProductByName(name);
    }
    public static ArrayList<product> load(String pubblishId, String price, String color){
        return productDAL.load(pubblishId,price,color);
    }
    public static ArrayList<product> readProductBySupplier(int supplierId ){
        
        return productDAL.readProductBySupplier(supplierId);
    }
    
}

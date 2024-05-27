/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DTO.supplier;
import DAL.supplierDAL;
import java.util.ArrayList;
/**
 *
 * @author it200
 */
public class supplierBLL {
   
    public static boolean isPhone(String phone){
        
        if(phone.length() != 10){
            return false;
        }
        if(!phone.startsWith("0")){
            return false;
        }
        for(int i=1 ; i< phone.length();i++){
            if(!Character.isDigit(phone.charAt(i))) return false;
        }
        return true;
    }
    public static boolean checkPhoneAdd(String phone){
        ArrayList<supplier> list =  supplierBLL.readSupplier();
        for(supplier s : list){
            if(phone.equals(s.getPhone()) ) return false;
        }
        return true;
    }
    public static boolean checkPhoneUpdate(String phone, int id){
        ArrayList<supplier> list =  supplierBLL.readSupplier();
        if(!getSupplierById(id).getPhone().equals(phone)){
            for(supplier s : list){
            if(phone.equals(s.getPhone()) ) return false;
        }
        } else return true;
        return true;
    }
    public static boolean isSupplierName(String supplierName){
        if(supplierName.length() ==  0 ) return false; 
        return true;
    }
    public static int addSupplier(supplier s){
        if(isPhone(s.getPhone())&&checkPhoneAdd(s.getPhone())&&isSupplierName(s.getSupplierName())){
            return supplierDAL.addSupplier(s);
        }
       return 0;
    }
    public static int updateSupplier(supplier s){
        if(isPhone(s.getPhone())&&checkPhoneUpdate(s.getPhone(), s.getSupplierId())&&isSupplierName(s.getSupplierName())){
            return supplierDAL.updateSupplier(s);
        }
        return 0;
    }
    public static int deleteSupplier(int id){
        return supplierDAL.deleteSupplier(id);
    }
    public static ArrayList<supplier> readSupplier(){
        ArrayList<supplier> list = supplierDAL.readSupplier();
        return list;
    }
    public static ArrayList<supplier> searchById(String id){
        ArrayList<supplier> list = supplierDAL.searchById(id);
        return list;
    }
    public static ArrayList<supplier> searchByName(String name){
        ArrayList<supplier> list = supplierDAL.searchByName(name);
        return list;
    }
    public static ArrayList<supplier> searchByNameAZ(){
        ArrayList<supplier> list = supplierDAL.searchByNameAZ();
        return list;
    }
    public static ArrayList<supplier> searchByNameZA(){
        ArrayList<supplier> list = supplierDAL.searchByNameZA();
        return list;
    }
    public static ArrayList<supplier> searchByPhone(String phone){
        ArrayList<supplier> list = supplierDAL.searchByPhone(phone);
        return list;
    }
    public static supplier getSupplierById(int id){
        return supplierDAL.getSupplierById(id);
    }
    public static supplier getSupplierByName(String name){
        return supplierDAL.getSupplierByName(name);
    }
}

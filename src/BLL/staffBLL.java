/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author it200
 */
import DTO.staff;
import DAL.staffDAL;
import java.util.ArrayList;
public class staffBLL {
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
        ArrayList<staff> list =  staffBLL.readStaff();
        for(staff s : list){
            if(phone.equals(s.getPhone()) ) return false;
        }
        return true;
    }
    public static boolean checkStaffUsername(String username){
        ArrayList<staff> list =  staffBLL.readStaff();
        for(staff s : list){
            if(username.equals(s.getStaffId()) ) return false;
        }
        return true;
    }
    public static boolean checkPhoneUpdate(String phone, String id){
        ArrayList<staff> list =  staffBLL.readStaff();
        if(!getStaffById(id).getPhone().equals(phone)){
            for(staff s : list){
            if(phone.equals(s.getPhone()) ) return false;
        }
        } else return true;
        return true;
    }
    public static boolean isStaffName(String supplierName){
        if(supplierName.length() ==  0 ) return false; 
        return true;
    }
    public static staff getStaffById(String id){
        return staffDAL.getStaffById(id);
    }
    public static ArrayList<staff> readStaff(){
        return staffDAL.readStaff();
    }
    public static int addStaff(staff s){
        if(isPhone(s.getPhone())&&checkStaffUsername(s.getStaffId())&&checkPhoneAdd(s.getPhone())&&isStaffName(s.getStaffName())){
            return staffDAL.addStaff(s);
        }
       return 0;
    }
    public static int updateStaff(staff s){
        if(isPhone(s.getPhone())&&checkPhoneUpdate(s.getPhone(), s.getStaffId())&&isStaffName(s.getStaffName())){
            return staffDAL.updateStaff(s);
        }
        return 0;
    }
    public static int deleteSupplier(String id){
        return staffDAL.deleteStaff(id);
    }
    public static ArrayList<staff> searchById(String id){
        return staffDAL.searchById(id);
    }
    public static ArrayList<staff> searchByName(String name){
        return staffDAL.searchByName(name);
    }
    public static ArrayList<staff> searchByPhone(String phone){
        return staffDAL.searchByName(phone);
    }
    public static staff GetByUsername(String id){
        return staffDAL.getStaffById(id);
    }
    
}

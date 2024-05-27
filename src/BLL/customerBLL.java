/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.customerDAL;
import DTO.customer;
import java.util.ArrayList;
public class customerBLL {
    public static void main(String[] args) {
        customer c = new customer("Võ Ngọc Anh","0123446782",1000);
        if(addCustomer(c)>0) System.out.println("1");
    }
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
        for(customer c : readCustomer()){
            if(c.equals(phone)) return false;
        }
        return true;
    }
    public static boolean checkPhoneUpdate(String phone,int id){
        if(!getCustomerById(id).getPhone().equals(phone)){
            for(customer s : readCustomer()){
            if(phone.equals(s.getPhone()) ) return false;
        }
        } else return true;
        return true;
    }
    public static boolean isCustomerName(String supplierName){
        if(supplierName.length() ==  0 ) return false; 
        return true;
    }
    public static boolean  checkPoint(int point){
        if(point <0 ) return false;
        return true;
    }
    public static int addCustomer(customer c){
        if(checkPoint(c.getPoint()) && isPhone(c.getPhone())&& checkPhoneAdd(c.getPhone()) && isCustomerName(c.getCustomerName()))
            return customerDAL.addCustomer(c);
        return 0;
    }
    public static int updateCustomer(customer c){
        if(checkPoint(c.getPoint())&&checkPhoneUpdate(c.getPhone(), c.getCustomerId()) && isPhone(c.getPhone()) && isCustomerName(c.getCustomerName()))
            return customerDAL.updateCustomer(c);
        return 0;
    }
    public static int deleteCustomer(int id){
        return customerDAL.deleteCustomer(id);
    }
    public static ArrayList<customer> readCustomer(){
        ArrayList<customer> listCustomer = customerDAL.readCustomer();
        return listCustomer;
    }
    public static customer getCustomerById(int id){
        return customerDAL.getCustomerById(id);
    }
    public static customer getCustomerByPhone(int phone){
        return customerDAL.getCustomerByPhone(phone);
    }
    public static ArrayList<customer> getCustomerByName(String name){
        ArrayList<customer> listCustomer = customerDAL.getCustomerByName(name);
        return listCustomer;
    }
    public static ArrayList<customer> searchCustomerById(String id){
        ArrayList<customer> listCustomer = customerDAL.searchCustomerById(id);
        return listCustomer;
    }
    public static ArrayList<customer> searchCustomerByPhone(String phone){
        ArrayList<customer> listCustomer = customerDAL.searchCustomerByPhone(phone);
        return listCustomer;
    }
}

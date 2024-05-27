/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.billImportDAL;
import DTO.billImport;
import DTO.infoBillImport;
import java.util.ArrayList;

/**
 *
 * @author it200
 */
public class billImportBLL {
     public static int addBillImport(billImport b){
        return billImportDAL.addBillImport(b);
    }
    public static int addBillImportInFo(infoBillImport b){
        return billImportDAL.addBillImportInfo(b);
    }
    public static billImport getBillImport(){
        return billImportDAL.getBillImport();
    }
    public static ArrayList<billImport> listBill(){
        return billImportDAL.listBill();
    }
    public static ArrayList<infoBillImport> listBillInfo(int id){
        return billImportDAL.listBillInfo(id);
    }
    public static int deleteBillImport(int id){
            return billImportDAL.deleteBillImport(id);
    }
    public static int deleteBillImportInfo(int id){
            return billImportDAL.deleteBillImportInfo(id);
    }
    public static int deleteBillImportInfoBid(int id ){
        return billImportDAL.deleteBillImportInfoBid(id);
    }
    public static float getTotal(int id){
        return billImportDAL.getTotal(id);
    }
    public static int updateBillImport(float total, int id){
        return billImportDAL.updateBillImport(total, id);
    }
    public static int updateBillImportinfo(infoBillImport bill){
        return billImportDAL.updateBillImportinfo(bill);
    }
     public static infoBillImport getBillImportInfo(int id){
         return billImportDAL.getBillImportInfo(id);
     }
}

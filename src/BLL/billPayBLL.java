/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.billPayDAL;
import DTO.billPay;
import DTO.infoBillPay;
import java.util.ArrayList;

/**
 *
 * @author it200
 */
public class billPayBLL {
    public static int addBillPay(billPay b){
        return billPayDAL.addBillPay(b);
    }
    public static int addBillPayInFo(infoBillPay b){
        return billPayDAL.addBillPayInfo(b);
    }
    public static billPay getBillPay(){
        return billPayDAL.getBillPay();
    }
    public static ArrayList<billPay> listBill(){
        return billPayDAL.listBill();
    }
    public static ArrayList<infoBillPay> listBillInfo(int id){
        return billPayDAL.listBillInfo(id);
    }
    public static int deleteBillPayInfo(int id ){
        return billPayDAL.deleteBillPayInfo(id);
    }
    public static int deleteBillPay(int id){
        return billPayDAL.deleteBillPay(id);
    }
}

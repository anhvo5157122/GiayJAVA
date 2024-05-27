/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author it200
 */
public class billImport{
     public int billId;
    public  String staffId;
    public float total;
    public String date;
    private int supplierId;

    public billImport() {
    }
    
    public billImport(int billId, String staffId, float total, String date, int supplierId) {
        this.billId = billId;
        this.staffId = staffId;
        this.total = total;
        this.date = date;
        this.supplierId = supplierId;
    }
     public billImport( String staffId, float total, String date, int supplierId) {
       
        this.staffId = staffId;
        this.total = total;
        this.date = date;
        this.supplierId = supplierId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}

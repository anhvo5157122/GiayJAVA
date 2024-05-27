/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author it200
 */
public class bill {
    public int billId;
    public  String staffId;
    public float total;
    public String date;
    public bill(int billId, String staffId, float total, String date) {
        this.billId = billId;
        this.staffId = staffId;
        this.total = total;
        this.date = date;
    }
    public bill(String staffId, float total, String date) {
        
        this.staffId = staffId;
        this.total = total;
        this.date = date;
    }
    public bill() {
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
    
    
}

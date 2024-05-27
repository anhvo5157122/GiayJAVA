/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author it200
 */
public class customer {
    private int customerId;
    private String customerName;
    private String phone;
    private int point;

    public customer(int customerId, String customerName, String phone, int point) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
        this.point = point;
    }
    public customer( String customerName, String phone, int point) {
        
        this.customerName = customerName;
        this.phone = phone;
        this.point = point;
    }

    public customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
}

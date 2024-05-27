/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author it200
 */
public class supplier {
    private int supplierId;
    private String supplierName;
    private String phone;
    public supplier() {
    }
    public supplier(int supplierId, String supplierName, String phone) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.phone = phone;
    }
    public supplier( String supplierName, String phone) {
        this.supplierName = supplierName;
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    
}

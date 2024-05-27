/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
public class staff {
    private String staffId;
    private String staffName;
    private String phone;
    private String address;
    private String password;
    private int power;
    public staff() {
    }
    public staff(String staffId, String staffName, String phone, String address) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.phone = phone;
        this.address = address;
    }

    public staff(String staffId, String staffName, String phone, String address, String password, int power) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.power = power;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}

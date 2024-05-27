/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author it200
 */
public class infoBill {
    private int infoBillId;
    private int productId;
    private int quantity;
    private float price;
    private float total;

    public infoBill() {
    }
    public infoBill(int infoBillId, int productId, int quantity, float price, float total) {
        this.infoBillId = infoBillId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }
    public infoBill( int productId, int quantity, float price, float total) {
        
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }
    public int getInfoBillId() {
        return infoBillId;
    }

    public void setInfoBillId(int infoBillId) {
        this.infoBillId = infoBillId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}

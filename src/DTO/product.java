/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
public class product {
    private int id;
    private String productName;
    private float price;
    private int quantity;

    private int supplierId;
    private String image;
    private String color;
    public product() {
        
    }

    public product(int id, String productName, float price, int quantity, int supplierId, String image,String color) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;

        this.supplierId = supplierId;
        this.image = image;
        this.color = color;
    }

    public product(String productName, float price, int quantity, int supplierId, String image, String color) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;

        this.supplierId = supplierId;
        this.image = image;
        this.color = color;
    }

    public product(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    
}

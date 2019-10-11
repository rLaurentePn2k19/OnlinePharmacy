/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;

/**
 *
 * @author 2ndyrGroupB
 */
public class Medicine {
    
    private int id;
    private String brandName;
    private String genericName;
    private int price;
    private String expirationDate;
    private String type;
    private int quantity;
    
    
    public Medicine() {
    }

    public Medicine(int id) {
        this.id = id;
    }
    
//    public Medicine(String brandName, String genericName,  int price, String type, String expirationDate, int quantity){
//        this.brandName = brandName;
//        this.genericName = genericName;
//        this.price = price;
//        this.expirationDate = expirationDate;
//        this.type = type;
//        this.quantity = quantity;
//    }
    
    public Medicine(int id, String brandName, String genericName, int price, String type, String expirationDate, int quantity) {
        this.id = id;
        this.brandName = brandName;
        this.genericName = genericName;
        this.price = price;
        this.expirationDate = expirationDate;
        this.type = type;
        this.quantity = quantity;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
      public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("\nBrand Name: %s\nGeneric Name: %s\nPrice: %d\nType: %s\nExpiration Date: %s\nQuantity: %d\n",brandName,genericName,price,type,expirationDate,quantity);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;


/**
 *
 * @author laurentera_sd2022
 */
public class MedicineForHeadache extends Medicine{
    

    public MedicineForHeadache() {
    }

    public MedicineForHeadache(int id) {
        super(id);
    }

    public MedicineForHeadache(int id, String brandName, String genericName, int price, String type, String expirationDate, int quantity) {
        super(id, brandName, genericName, price, type, expirationDate, quantity);
    }
    
    
}

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
public class MedicineForAllergies extends Medicine{
    
   
    public MedicineForAllergies() {
    }

    public MedicineForAllergies(int id) {
        super(id);
    }

    public MedicineForAllergies(int id, String brandName, String genericName, int price, String type, String expirationDate, int quantity) {
        super(id, brandName, genericName, price, type, expirationDate, quantity);
    }
    
    
    
}

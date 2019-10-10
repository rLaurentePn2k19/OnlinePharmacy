package pharmacyapp;

/**
 *
 * @author laurentera_sd2022
 */
public class MedicineForCough extends Medicine{
    
    
    public MedicineForCough() {
    }

    public MedicineForCough(int id) {
        super(id);
    }

    public MedicineForCough(int id, String brandName, String genericName, int price, String type, String expirationDate, int quantity) {
        super(id, brandName, genericName, price, type, expirationDate, quantity);
    }
    
    
}

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
public interface CustomerOperation {

    public void viewAvailableMedicines(Account a);

    public void purchaseMedicines(Account a);

    public void purchaseMedicineForCough();

    public void purchaseMedicineForHeadache();

    public void purchaseMedicineForBodyPain();

    public void purchaseMedicineForAllergies();

    public void viewPurchasedMedicines(Account a);

    public void CustomerMainTransaction(Account a);

    public void LoginAsAdult(Account a);

    public void LoginAsSeniorCitizen(Account a);
}

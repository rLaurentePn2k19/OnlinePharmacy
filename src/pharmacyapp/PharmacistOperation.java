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
public interface PharmacistOperation {

    // For Inventory of remaining medicines in a specific list of medicines
    public void inventoryMedicineForCough();

    public void inventoryMedicineForHeadache();

    public void inventoryMedicineForBodyPain();

    public void inventoryMedicineForAllergies();

    // For Adding Medicines to a specific list of Medicines
    public boolean addMedicineForCough(MedicineForCough m);

    public boolean addMedicineForHeadache(MedicineForHeadache m);

    public boolean addMedicineForBodyPain(MedicineForBodyPain m);

    public boolean addMedicineForAllergies(MedicineForAllergies m);

    // For Removing Medicines to a specific list of Medicines
    public void removeMedicineForCough(MedicineForCough m, int id);

    public void removeMedicineForHeadache(MedicineForHeadache m, int id);

    public void removeMedicineForBodyPain(MedicineForBodyPain m, int id);

    public void removeMedicineForAllergies(MedicineForAllergies m, int id);

    // For Displaying the available medicines in the specific list of medicines
    public void displayAvailableMedicinesForCough();

    public void displayAvailableMedicinesForHeadache();

    public void displayAvailableMedicinesForBodyPain();

    public void displayAvailableMedicinesForAllergies();

    // For choices of operation
    public void PharmacistMainTransaction(Account a);
    // customer 
    public void viewCustomers();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 2ndyrGroupB
 */
public class Pharmacy  {
    
    private String name;
    private static List<Pharmacist> pharmacist = new ArrayList<>();
    private static List<MedicineForCough> medicineForCough = new ArrayList<>();
    private static List<MedicineForHeadache> medicineForHeadache = new ArrayList<>();
    private static List<MedicineForBodyPain> medicineForBodyPain = new ArrayList<>();
    private static List<MedicineForAllergies> medicineForAllergies = new ArrayList<>();

    public Pharmacy() {

    }

    public static List<Pharmacist> getPharmacist() {
        return pharmacist;
    }

    public static void setPharmacist(List<Pharmacist> pharmacist) {
        Pharmacy.pharmacist = pharmacist;
    }

    public Pharmacy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<MedicineForCough> getMedicineForCough() {
        return medicineForCough;
    }

    public static void setMedicineForCough(List<MedicineForCough> medicineForCough) {
        Pharmacy.medicineForCough = medicineForCough;
    }

    public static List<MedicineForHeadache> getMedicineForHeadache() {
        return medicineForHeadache;
    }

    public static void setMedicineForHeadache(List<MedicineForHeadache> medicineForHeadache) {
        Pharmacy.medicineForHeadache = medicineForHeadache;
    }

    public static List<MedicineForBodyPain> getMedicineForBodyPain() {
        return medicineForBodyPain;
    }

    public static void setMedicineForBodyPain(List<MedicineForBodyPain> medicineForBodyPain) {
        Pharmacy.medicineForBodyPain = medicineForBodyPain;
    }

    public static List<MedicineForAllergies> getMedicineForAllergies() {
        return medicineForAllergies;
    }

    public static void setMedicineForAllergies(List<MedicineForAllergies> medicineForAllergies) {
        Pharmacy.medicineForAllergies = medicineForAllergies;
    }

    public void displayAllAvailableMedicinesForCough(Pharmacist p) {
        p.displayAvailableMedicinesForCough();
    }

    public void displayAllAvailableMedicinesForHeadache(Pharmacist p) {
        p.displayAvailableMedicinesForHeadache();
    }

    public void displayAllAvailableMedicinesForBodyPain(Pharmacist p) {
        p.displayAvailableMedicinesForBodyPain();
    }

    public void displayAllAvailableMedicinesForAllergies(Pharmacist p) {
        p.displayAvailableMedicinesForAllergies();
    }
    
    public void storedMedicineForCough(MedicineForCough m) {
        m.setId(User.getMedicineForCough().size() + 1);
        User.getMedicineForCough().add(m);
    }

    public void storedMedicineForHeadache(MedicineForHeadache m) {
        m.setId(User.getMedicineForHeadache().size() + 1);
        User.getMedicineForHeadache().add(m);
    }

    public void storedMedicineForBodyPain(MedicineForBodyPain m) {
        m.setId(User.getMedicineForBodyPain().size() + 1);
        User.getMedicineForBodyPain().add(m);
    }

    public void storedMedicineForAllergies(MedicineForAllergies m) {
        m.setId(User.getMedicineForAllergies().size() + 1);
        User.getMedicineForAllergies().add(m);
    }

}

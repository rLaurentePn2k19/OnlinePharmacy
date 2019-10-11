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
public class PharmacyApp {

    public static void main(String[] args) {
        
        User user = new User();
        Account newAccount = new Account();
        Pharmacy rose = new Pharmacy("Rose");
        
        // Stored medicines in the Pharamacy
        
        // Medicines for allergies
        MedicineForAllergies mfa1 = new MedicineForAllergies(0,"Azetic","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        MedicineForAllergies mfa2 = new MedicineForAllergies(0,"Alavert","Loratadine",20,"Capsul","March 11, 2020", 20);
        MedicineForAllergies mfa3 = new MedicineForAllergies(0,"Alrex","Etabonate",5,"Tablet","March 10, 2020", 20);
        MedicineForAllergies mfa4 = new MedicineForAllergies(0,"Haplas","Ointment",10,"Syrup","March 10, 2020", 20);
        MedicineForAllergies mfa5 = new MedicineForAllergies(0,"Bicks","Vapo Rub",8,"Capsule","March 10, 2020", 20);
        
        // Medicines for cough
        MedicineForCough mfc1 = new MedicineForCough(0,"Sulbotamol","Anti-Cough",45,"Syrup","March 10, 2020", 20);
        MedicineForCough mfc2 = new MedicineForCough(0,"Ambroxol","E+",5,"Tablet","March 10, 2020", 20);
        MedicineForCough mfc3 = new MedicineForCough(0,"Lagundi","Flemex",60,"Syrup","March 10, 2020", 20);
        MedicineForCough mfc4 = new MedicineForCough(0,"Tuseran","Forte",10,"Tablet","March 10, 2020", 20);
        MedicineForCough mfc5 = new MedicineForCough(0,"Carbo","Fresh",50,"Syrup","March 10, 2020", 20);
        
        // Medicines for headache
        MedicineForHeadache mfh1 = new MedicineForHeadache(0,"Biogesic","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        MedicineForHeadache mfh2 = new MedicineForHeadache(0,"Bioflu","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        MedicineForHeadache mfh3 = new MedicineForHeadache(0,"Alaxan","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        MedicineForHeadache mfh4 = new MedicineForHeadache(0,"Dolpenal","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        MedicineForHeadache mfh5 = new MedicineForHeadache(0,"Advil","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        
        // Medicines for body pain
        MedicineForBodyPain mfb1 = new MedicineForBodyPain(0,"Salonpas","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        MedicineForBodyPain mfb2 = new MedicineForBodyPain(0,"Omega+","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        MedicineForBodyPain mfb3 = new MedicineForBodyPain(0,"Alaxan Fr","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        MedicineForBodyPain mfb4 = new MedicineForBodyPain(0,"Eficascent","Anti-Katol",15,"Tablet","March 10, 2020", 20);
        MedicineForBodyPain mfb5 = new MedicineForBodyPain(0,"Vicks","Anti-Katol",15,"Tablet","March 10, 2020", 20);
       
        rose.storedMedicineForAllergies(mfa1);
        rose.storedMedicineForAllergies(mfa2);
        rose.storedMedicineForAllergies(mfa3);
        rose.storedMedicineForAllergies(mfa4);
        rose.storedMedicineForAllergies(mfa5);
        
        rose.storedMedicineForBodyPain(mfb1);
        rose.storedMedicineForBodyPain(mfb2);
        rose.storedMedicineForBodyPain(mfb3);
        rose.storedMedicineForBodyPain(mfb4);
        rose.storedMedicineForBodyPain(mfb5);
        
        rose.storedMedicineForCough(mfc1);
        rose.storedMedicineForCough(mfc2);
        rose.storedMedicineForCough(mfc3);
        rose.storedMedicineForCough(mfc4);
        rose.storedMedicineForCough(mfc5);
        
        rose.storedMedicineForHeadache(mfh1);
        rose.storedMedicineForHeadache(mfh2);
        rose.storedMedicineForHeadache(mfh3);
        rose.storedMedicineForHeadache(mfh4);
        rose.storedMedicineForHeadache(mfh5);
        
        user.Basic(newAccount);
    }
}

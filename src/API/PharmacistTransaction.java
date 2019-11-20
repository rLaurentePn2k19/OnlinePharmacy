/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import javax.swing.JOptionPane;
import pharmacyAppFrames.*;
import Db.*;

/**
 *
 * @author 2ndyrGroupB
 */
public class PharmacistTransaction {
    
    pharmacistOperation po = new pharmacistOperation();
    
    public void addMedicineForCough(String brandname, String genericname, String price, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || price.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.addMedicineForCough(brandname, genericname, Integer.valueOf(price), type, Integer.valueOf(quantity));
        }
    }

    public void addMedicineForHeadache(String brandname, String genericname, String price, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || price.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.addMedicineForHeadache(brandname, genericname, Integer.valueOf(price), type, Integer.valueOf(quantity));
        }
    }

    public void addMedicineForBodyPain(String brandname, String genericname, String price, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || price.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.addMedicineForBodyPain(brandname, genericname, Integer.valueOf(price), type, Integer.valueOf(quantity));
        }
    }

    public void addMedicineForAllergies(String brandname, String genericname, String price, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || price.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.addMedicineForAllergies(brandname, genericname, Integer.valueOf(price), type, Integer.valueOf(quantity));
        }
    }

    public void removeMedicineForCough(String brandname, String genericname, String quantity) {
        if (brandname.equals("") || genericname.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.removeMedicineForCough(brandname, genericname, Integer.valueOf(quantity));
        }
    }
}

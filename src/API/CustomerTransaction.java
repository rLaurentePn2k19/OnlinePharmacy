/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import javax.swing.JOptionPane;
import Db.*;
import static java.lang.Integer.parseInt;
import javax.swing.table.DefaultTableModel;
//import pharmacyAppFrames.CustomerDashboard;

/**
 *
 * @author 2ndyrGroupB
 */
public class CustomerTransaction {

    String[] columns = {"Brand name", "Generic name", "Price", "Type", "Quantity"};
//    int ecoin;
    customerOperation co = new customerOperation();

    public CustomerTransaction() {

    }

//    public void setEcoin(int ecoin) {
//        this.ecoin = ecoin;
//    }
//
//    public int getEcoin() {
//        System.out.println(ecoin + " is get");
//        return ecoin;
//    }

    public void purchaseMedicineForCough(String brandname, String genericname, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForCough(brandname, genericname, type, parseInt(quantity));
        }
    }

    public void purchaseMedicineForHeadache(String brandname, String genericname, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForHeadache(brandname, genericname, type, parseInt(quantity));
        }
    }

    public void purchaseMedicineForBodyPain(String brandname, String genericname, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForBodyPain(brandname, genericname, type, parseInt(quantity));
        }
    }

    public void purchaseMedicineForAllergies(String brandname, String genericname, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForAllergies(brandname, genericname, type, parseInt(quantity));
        }
    }

    public DefaultTableModel tableCough() {
        Object[][] medForCough = co.viewMedicineForCough();
        DefaultTableModel tableMedCough = new DefaultTableModel(medForCough, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedCough;
    }

    public DefaultTableModel tableHeadache() {
        Object[][] medHeadache = co.viewMedicineForHeadache();
        DefaultTableModel tableMedHeadache = new DefaultTableModel(medHeadache, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedHeadache;
    }

    public DefaultTableModel tableBodyPain() {
        Object[][] medAllergies = co.viewMedicineForCough();
        DefaultTableModel tableMedAllergies = new DefaultTableModel(medAllergies, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedAllergies;
    }

    public DefaultTableModel tableAllergies() {
        Object[][] medBodyPain = co.viewMedicineForCough();
        DefaultTableModel tableMedBodyPain = new DefaultTableModel(medBodyPain, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedBodyPain;
    }
}

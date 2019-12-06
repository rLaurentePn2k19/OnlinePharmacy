/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PharmacistOperations;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2ndyrGroupB
 */
public class PharmacistTransac {

    String[] columns = {"Brand name", "Generic name", "Price", "Type", "Quantity"};
    PharmacistOperations po = new PharmacistOperations();

    public void addMedForCough(String brandname, String genericname, String price, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || price.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.addMedicineForCough(brandname, genericname, Integer.valueOf(price), type, Integer.valueOf(quantity));
        }
    }

    public void addMedForHeadache(String brandname, String genericname, String price, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || price.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.addMedicineForHeadache(brandname, genericname, Integer.valueOf(price), type, Integer.valueOf(quantity));
        }
    }

    public void addMedForBodyPain(String brandname, String genericname, String price, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || price.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.addMedicineForBodyPain(brandname, genericname, Integer.valueOf(price), type, Integer.valueOf(quantity));
        }
    }

    public void addMedForAllergies(String brandname, String genericname, String price, String type, String quantity) {
        if (brandname.equals("") || genericname.equals("") || price.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.addMedicineForAllergies(brandname, genericname, Integer.valueOf(price), type, Integer.valueOf(quantity));
        }
    }

    public void removeMedForCough(String brandname, String genericname, String quantity) {
        if (brandname.equals("") || genericname.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.removeMedicineForCough(brandname, genericname, Integer.valueOf(quantity));
        }
    }

    public void removeMedForHeadache(String brandname, String genericname, String quantity) {
        if (brandname.equals("") || genericname.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.removeMedicineForHeadache(brandname, genericname, Integer.valueOf(quantity));
        }
    }

    public void removeMedForBodyPain(String brandname, String genericname, String quantity) {
        if (brandname.equals("") || genericname.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.removeMedicineForBodyPain(brandname, genericname, Integer.valueOf(quantity));
        }
    }

    public void removeMedForAllergies(String brandname, String genericname, String quantity) {
        if (brandname.equals("") || genericname.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.removeMedicineForAllergies(brandname, genericname, Integer.valueOf(quantity));
        }
    }

    public void updateMedForCough(String brandname, String genericname) {
        if (brandname.equals("") || genericname.equals("")) {
            JOptionPane.showMessageDialog(null, "Update failed", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.UpdateMedicineForCough(brandname, genericname);
        }
    }

    public void updateMedForHeadache(String brandname, String genericname) {
        if (brandname.equals("") || genericname.equals("")) {
            JOptionPane.showMessageDialog(null, "Update failed", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.UpdateMedicineForHeadache(brandname, genericname);
        }
    }

    public void updateMedForBodyPain(String brandname, String genericname) {
        if (brandname.equals("") || genericname.equals("")) {
            JOptionPane.showMessageDialog(null, "Update failed", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.UpdateMedicineForBodyPain(brandname, genericname);
        }
    }

    public void updateMedForAllergies(String brandname, String genericname) {
        if (brandname.equals("") || genericname.equals("")) {
            JOptionPane.showMessageDialog(null, "Update failed", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            po.UpdateMedicineForAllergies(brandname, genericname);
        }
    }

    public DefaultTableModel viewMedicinesForCough() {
        Object[][] medForCough = po.viewMedicineForCough();
        DefaultTableModel tableMedCough = new DefaultTableModel(medForCough, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedCough;
    }

    public DefaultTableModel viewMedicinesForHeadache() {
        Object[][] medHeadache = po.viewMedicineForHeadache();
        DefaultTableModel tableMedHeadache = new DefaultTableModel(medHeadache, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedHeadache;
    }

    public DefaultTableModel viewMedicinesForBodyPain() {
        Object[][] medAllergies = po.viewMedicineForBodyPain();
        DefaultTableModel tableMedAllergies = new DefaultTableModel(medAllergies, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedAllergies;
    }

    public DefaultTableModel viewMedicinesForAllergies() {
        Object[][] medBodyPain = po.viewMedicineForAllergies();
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

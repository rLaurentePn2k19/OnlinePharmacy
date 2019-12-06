/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CustomerOperation;
import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2ndyrGroupB
 */
public class CustomerTransaction {

    String[] columns = {"Brand name", "Generic name", "Price", "Type", "Quantity"};
    String[] columnForPurchased = {"Brandname","Genericname","Quantity","Amount paid","Date"};

    CustomerOperation co = new CustomerOperation();

    public void purchaseMedicineForCough(String brandname, String genericname, String type, String quantity, int user_id) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForCough(brandname, genericname, type, parseInt(quantity),user_id);
        }
    }

    public void purchaseMedicineForHeadache(String brandname, String genericname, String type, String quantity, int user_id) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForHeadache(brandname, genericname, type, parseInt(quantity),user_id);
        }
    }

    public void purchaseMedicineForBodyPain(String brandname, String genericname, String type, String quantity, int user_id) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForBodyPain(brandname, genericname, type, parseInt(quantity),user_id);
        }
    }

    public void purchaseMedicineForAllergies(String brandname, String genericname, String type, String quantity, int user_id) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForAllergies(brandname, genericname, type, parseInt(quantity),user_id);
        }
    }

    public DefaultTableModel viewMedicinesForCough() {
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

    public DefaultTableModel viewMedicinesForHeadache() {
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

    public DefaultTableModel viewMedicinesForBodyPain() {
        Object[][] medBodyPain = co.viewMedicineForBodyPain();
        DefaultTableModel tableMedBodyPain = new DefaultTableModel(medBodyPain, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedBodyPain;
    }

    public DefaultTableModel viewMedicinesForAllergies() {
        Object[][] medAllergies = co.viewMedicineForAllergies();
        DefaultTableModel tableMedAllergies = new DefaultTableModel(medAllergies, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedAllergies;
    }
    
    // This methods will return the table who has the data in specific type of medicine
    
    public DefaultTableModel purchasedMedCough(int user_id) {
        System.out.println(user_id + " user_id in CT");
        Object[][] medCough = co.viewPurchasedMedForCough(user_id);
        DefaultTableModel tablePurchasedMedCough= new DefaultTableModel(medCough, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedCough;
    }
    
    public DefaultTableModel purchasedMedHeadache(int user_id) {
        Object[][] medHeadache = co.viewPurchasedMedForHeadache(user_id);
        DefaultTableModel tablePurchasedMedHeadache= new DefaultTableModel(medHeadache, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedHeadache;
    }
    
    public DefaultTableModel purchasedMedBodyPain(int user_id) {
        Object[][] medBodyPain = co.viewPurchasedMedForBodyPain(user_id);
        DefaultTableModel tablePurchasedMedBodyPain= new DefaultTableModel(medBodyPain, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedBodyPain;
    }
    
    public DefaultTableModel purchasedMedAllergies(int user_id) {
        Object[][] medAllergies = co.viewPurchasedMedForAllergies(user_id);
        DefaultTableModel tablePurchasedMedAllergies= new DefaultTableModel(medAllergies, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedAllergies;
    }
    public DefaultTableModel purchasedMedCoughSC(int user_id) {
        System.out.println(user_id + " user_id in CT");
        Object[][] medCough = co.viewPurchasedMedForCough(user_id);
        DefaultTableModel tablePurchasedMedCough= new DefaultTableModel(medCough, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedCough;
    }
    
    public DefaultTableModel purchasedMedHeadacheSC(int user_id) {
        Object[][] medHeadache = co.viewPurchasedMedForHeadache(user_id);
        DefaultTableModel tablePurchasedMedHeadache= new DefaultTableModel(medHeadache, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedHeadache;
    }
    
    public DefaultTableModel purchasedMedBodyPainSC(int user_id) {
        Object[][] medBodyPain = co.viewPurchasedMedForBodyPain(user_id);
        DefaultTableModel tablePurchasedMedBodyPain= new DefaultTableModel(medBodyPain, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedBodyPain;
    }
    
    public DefaultTableModel purchasedMedAllergiesSC(int user_id) {
        Object[][] medAllergies = co.viewPurchasedMedForAllergies(user_id);
        DefaultTableModel tablePurchasedMedAllergies= new DefaultTableModel(medAllergies, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedAllergies;
    }
    
     public void purchaseMedicineForCoughSC(String brandname, String genericname, String type, String quantity, int user_id) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForCoughSC(brandname, genericname, type, parseInt(quantity),user_id);
        }
    }

    public void purchaseMedicineForHeadacheSC(String brandname, String genericname, String type, String quantity, int user_id) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForHeadacheSC(brandname, genericname, type, parseInt(quantity),user_id);
        }
    }

    public void purchaseMedicineForBodyPainSC(String brandname, String genericname, String type, String quantity, int user_id) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForBodyPainSC(brandname, genericname, type, parseInt(quantity),user_id);
        }
    }

    public void purchaseMedicineForAllergiesSC(String brandname, String genericname, String type, String quantity, int user_id) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForAllergiesSC(brandname, genericname, type, parseInt(quantity),user_id);
        }
    }
}

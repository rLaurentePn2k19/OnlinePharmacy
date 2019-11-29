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
    String[] columnForPurchased = {"Generic name","Amount paid","Category","Quantity","Date"};

    CustomerOperation co = new CustomerOperation();

    public void purchaseMedicineForCough(String brandname, String genericname, String type, String quantity, int user_id) {
        if (brandname.equals("") || genericname.equals("") || type.equals("") || quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            co.purchaseMedForCough(brandname, genericname, type, parseInt(quantity),user_id);
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

    public DefaultTableModel tableAllergies() {
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

    public DefaultTableModel purchasedMedCough() {
        Object[][] medCough = co.viewMedicineForCough();
        DefaultTableModel tablePurchasedMedCough= new DefaultTableModel(medCough, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedCough;
    }
    
    public DefaultTableModel purchasedMedHeadache() {
        Object[][] medHeadache = co.viewMedicineForAllergies();
        DefaultTableModel tablePurchasedMedHeadache= new DefaultTableModel(medHeadache, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedHeadache;
    }
    
    public DefaultTableModel purchasedMedBodyPain() {
        Object[][] medBodyPain = co.viewMedicineForAllergies();
        DefaultTableModel tablePurchasedMedBodyPain= new DefaultTableModel(medBodyPain, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedBodyPain;
    }
    
    public DefaultTableModel purchasedMedAllergies() {
        Object[][] medAllergies = co.viewMedicineForAllergies();
        DefaultTableModel tablePurchasedMedAllergies= new DefaultTableModel(medAllergies, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedAllergies;
    }
    
    public DefaultTableModel viewPurchasedMedicines() {
        Object[][] viewTable = co.viewPurchasedMedicines();
        DefaultTableModel tablePurchasedMedicines= new DefaultTableModel(viewTable, columnForPurchased) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tablePurchasedMedicines;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 2ndyrGroupB
 */
public class CustomerOperation implements DbConnect {

    public Object[][] viewMedicineForCough() {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[10][5];

        String selectQuery;

        selectQuery = "SELECT * from `medicineforcough`";
        try {
            int cols = 0;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectQuery);
            while (result.next()) {
                data[cols][0] = result.getString("brandname");
                data[cols][1] = result.getString("genericname");
                data[cols][2] = result.getString("price");
                data[cols][3] = result.getString("type");
                data[cols][4] = result.getString("quantity");
                ++cols;
            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewMedicineForHeadache() {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[10][5];

        String selectQuery;

        selectQuery = "SELECT * from `medicineforheadache`";
        try {
            int cols = 0;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectQuery);
            while (result.next()) {
                data[cols][0] = result.getString("brandname");
                data[cols][1] = result.getString("genericname");
                data[cols][2] = result.getString("price");
                data[cols][3] = result.getString("type");
                data[cols][4] = result.getString("quantity");
                ++cols;

            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewMedicineForAllergies() {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[10][5];

        String selectQuery;

        selectQuery = "SELECT * from `medicineforallergies`";
        try {
            int cols = 0;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectQuery);
            while (result.next()) {
                data[cols][0] = result.getString("brandname");
                data[cols][1] = result.getString("genericname");
                data[cols][2] = result.getString("price");
                data[cols][3] = result.getString("type");
                data[cols][4] = result.getString("quantity");
                ++cols;

            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewMedicineForBodyPain() {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[10][5];

        String selectQuery;

        selectQuery = "SELECT * from `medicineforbodypain`";
        try {
            int cols = 0;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectQuery);
            while (result.next()) {
                data[cols][0] = result.getString("brandname");
                data[cols][1] = result.getString("genericname");
                data[cols][2] = result.getString("price");
                data[cols][3] = result.getString("type");
                data[cols][4] = result.getString("quantity");
                ++cols;

            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public void purchaseMedForCough(String brandname, String genericname, String type, int quantity, int user_id) {

        Connection conn = null;
        Statement stmtSelect = null;
        Statement stmtDelete = null;
        Statement stmtUpdate = null;
        Statement stmtInsert = null;
        int medicine_id = 0;
        double amount_paid = 0;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        String insertPurchasedMed;
        selectQuery = "SELECT id,quantity,price from `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmtSelect = conn.createStatement();
            ResultSet select = stmtSelect.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                int price = select.getInt("price");
                amount_paid = quantity * price;
                medicine_id = select.getInt("id");
                if (qty == quantity) {
                    stmtDelete = conn.createStatement();
                    stmtDelete.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, "You purchased all " + genericname);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforcough` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, amount_paid);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforcough` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmtUpdate = conn.createStatement();
                    stmtUpdate.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "You purchased " + genericname + " a quantity of " + quantity);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforcough` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, amount_paid);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public void purchaseMedForHeadache(String brandname, String genericname, String type, int quantity, int user_id) {
        Connection conn = null;
        Statement stmtSelect = null;
        Statement stmtDelete = null;
        Statement stmtUpdate = null;
        Statement stmtInsert = null;
        int medicine_id = 0;
        double amount_paid = 0;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        String insertPurchasedMed;
        selectQuery = "SELECT id,quantity,price from `medicineforheadache` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforheadache` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmtSelect = conn.createStatement();
            ResultSet select = stmtSelect.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                int price = select.getInt("price");
                amount_paid = quantity * price;
                medicine_id = select.getInt("id");
                if (qty == quantity) {
                    stmtDelete = conn.createStatement();
                    stmtDelete.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, "You purchased all " + genericname);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforheadache` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, amount_paid);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforheadache` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmtUpdate = conn.createStatement();
                    stmtUpdate.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "You purchased " + genericname + " a quantity of " + quantity);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforheadache` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, amount_paid);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public void purchaseMedForBodyPain(String brandname, String genericname, String type, int quantity, int user_id) {
        Connection conn = null;
        Statement stmtSelect = null;
        Statement stmtDelete = null;
        Statement stmtUpdate = null;
        Statement stmtInsert = null;
        int medicine_id = 0;
        double amount_paid = 0;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        String insertPurchasedMed;
        selectQuery = "SELECT id,quantity,price from `medicineforbodypain` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforbodypain` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmtSelect = conn.createStatement();
            ResultSet select = stmtSelect.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                medicine_id = select.getInt("id");
                int price = select.getInt("price");
                amount_paid = quantity * price;
                if (qty == quantity) {
                    stmtDelete = conn.createStatement();
                    stmtDelete.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, "You purchased all " + genericname);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforbodypain` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, amount_paid);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforbodypain` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmtUpdate = conn.createStatement();
                    stmtUpdate.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "You purchased " + genericname + " a quantity of " + quantity);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforbodypain` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, amount_paid);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public void purchaseMedForAllergies(String brandname, String genericname, String type, int quantity, int user_id) {
        Connection conn = null;
        Statement stmtSelect = null;
        Statement stmtDelete = null;
        Statement stmtUpdate = null;
        Statement stmtInsert = null;
        int medicine_id = 0;
        double amount_paid = 0;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        String insertPurchasedMed;
        selectQuery = "SELECT id,quantity,price from `medicineforallergies` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforallergies` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmtSelect = conn.createStatement();
            ResultSet select = stmtSelect.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                medicine_id = select.getInt("id");
                int price = select.getInt("price");
                amount_paid = quantity * price;
                if (qty == quantity) {
                    stmtDelete = conn.createStatement();
                    stmtDelete.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, "You purchased all " + genericname);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforallergies` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, amount_paid);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforallergies` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmtUpdate = conn.createStatement();
                    stmtUpdate.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "You purchased " + genericname + " a quantity of " + quantity);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforallergies` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, amount_paid);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public Object[][] viewPurchasedMedForCough(int user_id) {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[20][5];

        String selectQuery;

        selectQuery = "SELECT * FROM `purchasedmedicinesforcough` as pmfc JOIN `medicineforcough` as mfc ON pmfc.medicine_id = mfc.id ";

        try {
            int cols = 0;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectQuery);
            while (result.next()) {

                data[cols][0] = result.getString("brandname");
                data[cols][1] = result.getString("genericname");
                data[cols][2] = result.getInt("quantity");
                data[cols][3] = result.getDouble("amount_paid");
                data[cols][4] = result.getString("date");
                ++cols;
            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewPurchasedMedForHeadache(int user_id) {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[20][5];

        String selectQuery;

        selectQuery = "SELECT * FROM `purchasedmedicinesforheadache` as pmfh JOIN `medicineforheadache` as mfh on pmfh.medicine_id = mfh.id";

        try {
            int cols = 0;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectQuery);
            while (result.next()) {
                data[cols][0] = result.getString("brandname");
                data[cols][1] = result.getString("genericname");
                data[cols][2] = result.getInt("quantity");
                data[cols][3] = result.getDouble("amount_paid");
                data[cols][4] = result.getString("date");
                ++cols;
            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewPurchasedMedForBodyPain(int user_id) {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[20][5];

        String selectQuery;

        selectQuery = "SELECT * FROM `purchasedmedicinesforbodypain` as pmfb JOIN `medicineforbodypain` as mfb on pmfb.medicine_id = mfb.id";

        try {
            int cols = 0;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectQuery);
            while (result.next()) {
                data[cols][0] = result.getString("brandname");
                data[cols][1] = result.getString("genericname");
                data[cols][2] = result.getInt("quantity");
                data[cols][3] = result.getDouble("amount_paid");
                data[cols][4] = result.getString("date");
                ++cols;
            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewPurchasedMedForAllergies(int user_id) {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[20][5];

        String selectQuery;

        selectQuery = "SELECT * FROM `purchasedmedicinesforallergies` as pmfa JOIN `medicineforallergies` as mfa on pmfa.medicine_id = mfa.id ";

        try {
            int cols = 0;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectQuery);
            while (result.next()) {
                data[cols][0] = result.getString("brandname");
                data[cols][1] = result.getString("genericname");
                data[cols][2] = result.getInt("quantity");
                data[cols][3] = result.getDouble("amount_paid");
                data[cols][4] = result.getString("date");
                ++cols;
            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public void purchaseMedForCoughSC(String brandname, String genericname, String type, int quantity, int user_id) {

        Connection conn = null;
        Statement stmtSelect = null;
        Statement stmtDelete = null;
        Statement stmtUpdate = null;
        Statement stmtInsert = null;
        int medicine_id = 0;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        String insertPurchasedMed;
        selectQuery = "SELECT id,quantity,price from `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmtSelect = conn.createStatement();
            ResultSet select = stmtSelect.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                int price = select.getInt("price");
                medicine_id = select.getInt("id");
                float discount = (float) (0.2 * price);
                float discountPercent = discount * quantity;
                float amount_paid = quantity * price;
                float total = amount_paid - discountPercent;
                if (qty == quantity) {
                    stmtDelete = conn.createStatement();
                    stmtDelete.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, "You purchased all " + genericname);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforcough` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, total);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforcough` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmtUpdate = conn.createStatement();
                    stmtUpdate.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "You purchased " + genericname + " a quantity of " + quantity);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforcough` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, total);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public void purchaseMedForHeadacheSC(String brandname, String genericname, String type, int quantity, int user_id) {
        Connection conn = null;
        Statement stmtSelect = null;
        Statement stmtDelete = null;
        Statement stmtUpdate = null;
        Statement stmtInsert = null;
        int medicine_id = 0;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        String insertPurchasedMed;
        selectQuery = "SELECT id,quantity,price from `medicineforheadache` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforheadache` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmtSelect = conn.createStatement();
            ResultSet select = stmtSelect.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                int price = select.getInt("price");
                medicine_id = select.getInt("id");
                float discount = (float) (0.2 * price);
                float discountPercent = discount * quantity;
                float amount_paid = quantity * price;
                float total = amount_paid - discountPercent;
                if (qty == quantity) {
                    stmtDelete = conn.createStatement();
                    stmtDelete.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, "You purchased all " + genericname);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforheadache` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, total);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforheadache` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmtUpdate = conn.createStatement();
                    stmtUpdate.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "You purchased " + genericname + " a quantity of " + quantity);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforheadache` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, total);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public void purchaseMedForBodyPainSC(String brandname, String genericname, String type, int quantity, int user_id) {
        Connection conn = null;
        Statement stmtSelect = null;
        Statement stmtDelete = null;
        Statement stmtUpdate = null;
        Statement stmtInsert = null;
        int medicine_id = 0;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        String insertPurchasedMed;
        selectQuery = "SELECT id,quantity,price from `medicineforbodypain` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforbodypain` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmtSelect = conn.createStatement();
            ResultSet select = stmtSelect.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                medicine_id = select.getInt("id");
                int price = select.getInt("price");
                float discount = (float) (0.2 * price);
                float discountPercent = discount * quantity;
                float amount_paid = quantity * price;
                float total = amount_paid - discountPercent;
                if (qty == quantity) {
                    stmtDelete = conn.createStatement();
                    stmtDelete.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, "You purchased all " + genericname);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforbodypain` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, total);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforbodypain` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmtUpdate = conn.createStatement();
                    stmtUpdate.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "You purchased " + genericname + " a quantity of " + quantity);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforbodypain` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, total);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public void purchaseMedForAllergiesSC(String brandname, String genericname, String type, int quantity, int user_id) {
        Connection conn = null;
        Statement stmtSelect = null;
        Statement stmtDelete = null;
        Statement stmtUpdate = null;
        Statement stmtInsert = null;
        int medicine_id = 0;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        String insertPurchasedMed;
        selectQuery = "SELECT id,quantity,price from `medicineforallergies` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforallergies` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmtSelect = conn.createStatement();
            ResultSet select = stmtSelect.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                medicine_id = select.getInt("id");
                int price = select.getInt("price");
                float discount = (float) (0.2 * price);
                float discountPercent = discount * quantity;
                float amount_paid = quantity * price;
                float total = amount_paid - discountPercent;
                if (qty == quantity) {
                    stmtDelete = conn.createStatement();
                    stmtDelete.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, "You purchased all " + genericname);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforallergies` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, total);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforallergies` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmtUpdate = conn.createStatement();
                    stmtUpdate.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "You purchased " + genericname + " a quantity of " + quantity);
                    insertPurchasedMed = String.format("INSERT INTO `purchasedmedicinesforallergies` (account_id,medicine_id,quantity,amount_paid)"
                            + "VALUES ('%d','%d','%d','%f')", user_id, medicine_id, quantity, total);
                    stmtInsert = conn.createStatement();
                    stmtInsert.executeUpdate(insertPurchasedMed);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }
}

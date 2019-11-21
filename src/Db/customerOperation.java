/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

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
public class customerOperation implements DbConnect {

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

    public void purchaseMedForCough(String brandname, String genericname, String type, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        selectQuery = "SELECT quantity from `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                if (qty == quantity) {
                    stmt.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, "You purchased all " + genericname);
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforcough` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmt.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "You purchased " + quantity + " of " + genericname);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        } 
        
    }

    public void purchaseMedForHeadache(String brandname, String genericname, String type, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        selectQuery = "SELECT quantity from `medicineforheadache` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforheadache` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                if (qty == quantity) {
                    stmt.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, genericname + " is succesfully removed");
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforheadache` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmt.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, genericname + " is deducted by " + quantity);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public void purchaseMedForBodyPain(String brandname, String genericname, String type, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        selectQuery = "SELECT quantity from `medicineforbodypain` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforbodypain` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                if (qty == quantity) {
                    stmt.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, genericname + " is succesfully removed");
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforbodypain` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmt.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, genericname + " is deducted by " + quantity);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public void purchaseMedForAllergies(String brandname, String genericname, String type, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String updateQuery;
        String selectQuery;
        selectQuery = "SELECT quantity from `medicineforallergies` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        deleteQuery = "DELETE FROM `medicineforallergies` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                int qty = select.getInt("quantity");
                if (qty == quantity) {
                    stmt.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, genericname + " is succesfully removed");
                } else if (qty > quantity) {
                    int upqty = qty - quantity;
                    updateQuery = "UPDATE `medicineforallergies` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmt.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, genericname + " is deducted by " + quantity);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }

    }
}

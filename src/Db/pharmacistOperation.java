/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.awt.HeadlessException;
import static java.lang.Integer.parseInt;
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
public class pharmacistOperation implements DbConnect {

    public void addMedicineForCough(String brandname, String genericname, int price, String type, int quantity) {

        Connection conn = null;
        Statement stmt = null;
        String insertQuery;

        insertQuery = String.format("INSERT INTO `medicineforcough` (brandname,genericname,price,type,quantity)"
                + "VALUES ('%s','%s','%d','%s','%d')", brandname, genericname, price, type, quantity);
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(insertQuery);
            JOptionPane.showMessageDialog(null, genericname + " is succesfully added to medicines for Cough.");
            System.out.println(result);
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void addMedicineForHeadache(String brandname, String genericname, int price, String type, int quantity) {

        Connection conn = null;
        Statement stmt = null;
        String insertQuery;

        insertQuery = String.format("INSERT INTO `medicineforheadache` (brandname,genericname,price,type,quantity)"
                + "VALUES ('%s','%s','%d','%s','%d')", brandname, genericname, price, type, quantity);
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(insertQuery);
            JOptionPane.showMessageDialog(null, genericname + " is succesfully added to medicines for Headache.");
            System.out.println(result);
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void addMedicineForBodyPain(String brandname, String genericname, int price, String type, int quantity) {

        Connection conn = null;
        Statement stmt = null;
        String insertQuery;

        insertQuery = String.format("INSERT INTO `medicineforbodypain` (brandname,genericname,price,type,quantity)"
                + "VALUES ('%s','%s','%d','%s','%d')", brandname, genericname, price, type, quantity);
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(insertQuery);
            JOptionPane.showMessageDialog(null, genericname + " is succesfully added to medicines for Body pain.");
            System.out.println(result);
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void addMedicineForAllergies(String brandname, String genericname, int price, String type, int quantity) {

        Connection conn = null;
        Statement stmt = null;
        String insertQuery;

        insertQuery = String.format("INSERT INTO `medicineforallergies` (brandname,genericname,price,type,quantity)"
                + "VALUES ('%s','%s','%d','%s','%d')", brandname, genericname, price, type, quantity);
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(insertQuery);
            JOptionPane.showMessageDialog(null, genericname + " is succesfully added to medicines for Allergies");
            System.out.println(result);
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public Object[][] removeMedicineForCough(String brandname, String genericname, int quantity) {
        Object[][] data = new Object[15][5];
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String selectQuery;
        String insertQuery;
        int upqty = 0;
        selectQuery = "SELECT * from `medicineforcough`";
        deleteQuery = "DELETE FROM `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        insertQuery = String.format("INSERT INTO `medicineforcough` (quantity)"
                + "VALUES ('%d')", upqty);
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet retrieve = stmt.executeQuery(selectQuery);
            int qty = retrieve.getInt("quantity");
            if (qty == quantity) {
                int result = stmt.executeUpdate(deleteQuery);
                System.out.println(result);
                JOptionPane.showMessageDialog(null, genericname + " is succesfully removed");
            } else if (qty > quantity) {
                upqty = qty - quantity;
                ResultSet res = stmt.executeQuery(insertQuery);
                JOptionPane.showMessageDialog(null, genericname + " is deducted by " + quantity);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewMedicineForCough() {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[15][5];

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
        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewMedicineForHeadache() {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[15][5];

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
        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewMedicineForAllergies() {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[15][5];

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
        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public Object[][] viewMedicineForBodyPain() {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[15][5];

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
        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
}

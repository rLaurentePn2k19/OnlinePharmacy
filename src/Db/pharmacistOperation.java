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
            JOptionPane.showMessageDialog(null, genericname + " is succesfully added.");
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
            JOptionPane.showMessageDialog(null, genericname + " is succesfully added.");
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
            JOptionPane.showMessageDialog(null, genericname + " is succesfully added.");
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
            JOptionPane.showMessageDialog(null, genericname + " is succesfully added.");
            System.out.println(result);
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void removeMedicineForCough(String brandname, String genericname, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String selectQuery;
        String updateQuery;

        selectQuery = "SELECT * FROM `medicineforcough` WHERE brandname ='" + brandname + "' and genericname= '" + genericname + "' and quantity= '" + quantity + "'";
        deleteQuery = "DELETE FROM `medicineforcough` WHERE brandname ='" + brandname + "' and genericname= '" + genericname + "' and quantity= '" + quantity + "'";
//        updateQuery = String.format("UPDATE `medicineforcough` SET (quantity)" + "VALUES('%d')", quantity);
        updateQuery = "UPDATE medicineforcough set quantity=? where brandname=?";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(selectQuery);
            while (res.next()) {
                String qty = res.getString("quantity");
                if (parseInt(qty) == quantity) {
                    int result = stmt.executeUpdate(deleteQuery);
                    JOptionPane.showMessageDialog(null, genericname + " is succesfully removed.");
                    System.out.println(result);
                } else if (parseInt(qty) < quantity) {
                    int result = stmt.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, genericname + " is deducted by "+quantity);
                }
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public Object[][] viewMedicineForCough() {
        Connection conn = null;
        Statement stmt = null;
        Object[][] data = new Object[100][5];

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
        Object[][] data = new Object[100][5];

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
        Object[][] data = new Object[100][5];

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
        Object[][] data = new Object[100][5];

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

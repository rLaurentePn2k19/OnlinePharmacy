/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

    public void removeMedicineForCough(String brandname, String genericname, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String selectQuery;
        String updateQuery;
        selectQuery = "SELECT quantity,brandname,genericname from `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
        deleteQuery = "DELETE FROM `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                if (brandname.equalsIgnoreCase(select.getString("brandname")) || genericname.equalsIgnoreCase(select.getString("genericname"))) {
                    int qty = select.getInt("quantity");
                    if (qty == quantity) {
                        stmt.executeUpdate(deleteQuery);
                        JOptionPane.showMessageDialog(null, genericname + " is succesfully removed");
                    } else if (qty > quantity) {
                        int upqty = qty - quantity;
                        updateQuery = "UPDATE `medicineforcough` SET quantity = '" + upqty + "' WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                        stmt.executeUpdate(updateQuery);
                        JOptionPane.showMessageDialog(null, genericname + " is deducted by " + quantity);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void removeMedicineForHeadache(String brandname, String genericname, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String selectQuery;
        String updateQuery;
        selectQuery = "SELECT quantity,brandname,genericname from `medicineforheadache` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
        deleteQuery = "DELETE FROM `medicineforheadache` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                if (brandname.equalsIgnoreCase(select.getString("brandname")) || genericname.equalsIgnoreCase(select.getString("genericname"))) {
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
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void removeMedicineForBodyPain(String brandname, String genericname, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String selectQuery;
        String updateQuery;
        selectQuery = "SELECT quantity,brandname,genericname from `medicineforbodypain` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
        deleteQuery = "DELETE FROM `medicineforbodypain` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                if (brandname.equalsIgnoreCase(select.getString("brandname")) || genericname.equalsIgnoreCase(select.getString("genericname"))) {
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
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void removeMedicineForAllergies(String brandname, String genericname, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        String deleteQuery;
        String selectQuery;
        String updateQuery;
        selectQuery = "SELECT quantity,brandname,genericname from `medicineforallergies` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
        deleteQuery = "DELETE FROM `medicineforallergies` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "' ";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                if (brandname.equalsIgnoreCase(select.getString("brandname")) || genericname.equalsIgnoreCase(select.getString("genericname"))) {
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
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
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

    public void UpdateMedicineForCough(String brandname, String genericname) {
        Connection conn = null;
        Statement stmt = null;
        String selectQuery;
        String updateQuery;
        selectQuery = "SELECT type,price,quantity,brandname,genericname from `medicineforcough` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                String bname = select.getString("brandname");
                String gname = select.getString("genericname");
                if (bname.equalsIgnoreCase(brandname) && gname.equalsIgnoreCase(genericname)) {
                    JTextField Price = new JTextField();
                    JTextField Type = new JTextField();
                    JTextField Quantity = new JTextField();
                    Object[] message = {
                        "Price:", Price,
                        "Type:", Type,
                        "Quantity:", Quantity
                    };
                    JOptionPane.showConfirmDialog(null, message, "Update Medicine", JOptionPane.OK_CANCEL_OPTION);
                    String Updatedprice = Price.getText();
                    String Updatedtype = Type.getText();
                    String Updatedquantity = Quantity.getText();
                    updateQuery = "UPDATE `medicineforcough` SET quantity = '" + Updatedquantity + "', price = '" + Updatedprice + "' "
                            + ", type = '" + Updatedtype + "'WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmt.executeUpdate(updateQuery);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void UpdateMedicineForAllergies(String brandname, String genericname) {
        Connection conn = null;
        Statement stmt = null;
        String selectQuery;
        String updateQuery;
        selectQuery = "SELECT type,price,quantity,brandname,genericname from `medicineforallergies` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                String bname = select.getString("brandname");
                String gname = select.getString("genericname");
                if (bname.equalsIgnoreCase(brandname) && gname.equalsIgnoreCase(genericname)) {
                    JTextField Price = new JTextField();
                    JTextField Type = new JTextField();
                    JTextField Quantity = new JTextField();
                    Object[] message = {
                        "Price:", Price,
                        "Type:", Type,
                        "Quantity:", Quantity
                    };
                    JOptionPane.showConfirmDialog(null, message, "Update Medicine", JOptionPane.OK_CANCEL_OPTION);
                    String Updatedprice = Price.getText();
                    String Updatedtype = Type.getText();
                    String Updatedquantity = Quantity.getText();
                    updateQuery = "UPDATE `medicineforallergies` SET quantity = '" + Updatedquantity + "', price = '" + Updatedprice + "' "
                            + ", type = '" + Updatedtype + "'WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmt.executeUpdate(updateQuery);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void UpdateMedicineForHeadache(String brandname, String genericname) {
        Connection conn = null;
        Statement stmt = null;
        String selectQuery;
        String updateQuery;
        selectQuery = "SELECT type,price,quantity,brandname,genericname from `medicineforheadache` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                String bname = select.getString("brandname");
                String gname = select.getString("genericname");
                if (bname.equalsIgnoreCase(brandname) && gname.equalsIgnoreCase(genericname)) {
                    JTextField Price = new JTextField();
                    JTextField Type = new JTextField();
                    JTextField Quantity = new JTextField();
                    Object[] message = {
                        "Price:", Price,
                        "Type:", Type,
                        "Quantity:", Quantity
                    };
                    JOptionPane.showConfirmDialog(null, message, "Update Medicine", JOptionPane.OK_CANCEL_OPTION);
                    String Updatedprice = Price.getText();
                    String Updatedtype = Type.getText();
                    String Updatedquantity = Quantity.getText();
                    updateQuery = "UPDATE `medicineforheadache` SET quantity = '" + Updatedquantity + "', price = '" + Updatedprice + "' "
                            + ", type = '" + Updatedtype + "'WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmt.executeUpdate(updateQuery);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void UpdateMedicineForBodyPain(String brandname, String genericname) {
        Connection conn = null;
        Statement stmt = null;
        String selectQuery;
        String updateQuery;
        selectQuery = "SELECT type,price,quantity,brandname,genericname from `medicineforbodypain` WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet select = stmt.executeQuery(selectQuery);
            while (select.next()) {
                String bname = select.getString("brandname");
                String gname = select.getString("genericname");

                if (bname.equalsIgnoreCase(brandname) && gname.equalsIgnoreCase(genericname)) {
                    JTextField Price = new JTextField();
                    JTextField Type = new JTextField();
                    JTextField Quantity = new JTextField();
                    Object[] message = {
                        "Price:", Price,
                        "Type:", Type,
                        "Quantity:", Quantity
                    };
                    JOptionPane.showConfirmDialog(null, message, "Update Medicine", JOptionPane.OK_CANCEL_OPTION);
                    String Updatedprice = Price.getText();
                    String Updatedtype = Type.getText();
                    String Updatedquantity = Quantity.getText();
                    updateQuery = "UPDATE `medicineforbodypain` SET quantity = '" + Updatedquantity + "', price = '" + Updatedprice + "' "
                            + ", type = '" + Updatedtype + "'WHERE brandname = '" + brandname + "' and genericname = '" + genericname + "'";
                    stmt.executeUpdate(updateQuery);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
    }
}

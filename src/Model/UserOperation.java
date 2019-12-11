/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.PurchasedMedicines;
import View.SeniorCDashboard;
import View.PharmacistDashboard;
import View.Register;
import View.AdultDashboard;
import View.Login;
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
public class UserOperation implements DbConnect {

    public void CreateAccount(String name, int age, String email, String password) {
        Connection conn = null;
        Statement stmtInsert = null;
        Statement stmtRetrieve = null;
        String insertQuery;

        insertQuery = String.format("INSERT INTO `accounts` (name,age,email,password) "
                + "VALUES ('%s','%d','%s','%s')", name, age, email, password);
        String retrieveUser;
        retrieveUser = "SELECT id from `accounts` where email = '" + email
                + "' and password = '" + password + "'";
        if (age < 18) {
            Register reg = new Register();
            JOptionPane.showMessageDialog(null, "Minors are not allowed", "Error", JOptionPane.ERROR_MESSAGE);
            reg.setVisible(true);
        } else {
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmtInsert = conn.createStatement();
                int result = stmtInsert.executeUpdate(insertQuery);
                if (age > 60) {
                    stmtRetrieve = conn.createStatement();
                    ResultSet res = stmtRetrieve.executeQuery(retrieveUser);
                    if (res.next()) {
                        int account_id = 0;
                        account_id = res.getInt("id");
                        SeniorCDashboard scd = new SeniorCDashboard(account_id);
                        scd.setVisible(true);
                        PurchasedMedicines pm = new PurchasedMedicines();
                        pm.setUser_id(account_id);
                    }
                    JOptionPane.showMessageDialog(null, "Welcome to Rangie Drug Store", null, JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(null, "You can purchase our medicine with 20% discount..", null, JOptionPane.PLAIN_MESSAGE);
                } else {
                    stmtRetrieve = conn.createStatement();
                    ResultSet res = stmtRetrieve.executeQuery(retrieveUser);
                    if (res.next()) {
                        int account_id = 0;
                        account_id = res.getInt("id");
                        AdultDashboard customer = new AdultDashboard(account_id);
                        customer.setVisible(true);
                        PurchasedMedicines pm = new PurchasedMedicines();
                        pm.setUser_id(account_id);
                    }
                    JOptionPane.showMessageDialog(null, "Welcome to Rangie Drug Store", null, JOptionPane.PLAIN_MESSAGE);
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void getUser(String email, String password) {
        Connection conn = null;
        Statement stmt = null;
        String retrievetQuery;
        int account_id = 0;
        String em = "";
        String pass = "";
        int age = 0;
        retrievetQuery = "SELECT * from `accounts` where email = '" + email
                + "' and password = '" + password + "'";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(retrievetQuery);
            if (result.next()) {
                em = result.getString("email");
                pass = result.getString("password");
                age = result.getInt("age");
            }
            if (email.equals(em) && password.equals(pass)) {
                account_id = result.getInt("id");
                if (age < 60) {
                    AdultDashboard cd = new AdultDashboard(account_id);
                    cd.setVisible(true);
                    PurchasedMedicines pm = new PurchasedMedicines();
                    pm.setUser_id(account_id);
                    JOptionPane.showMessageDialog(null, "Welcome to Rangie Drug Store", null, JOptionPane.PLAIN_MESSAGE);
                } else if (age > 60) {
                    SeniorCDashboard sc = new SeniorCDashboard(account_id);
                    sc.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Welcome to Rangie Drug Store", null, JOptionPane.PLAIN_MESSAGE);
                }
            } else if (email.equals("pharma") && password.equals("pharma")) {
                PharmacistDashboard pd = new PharmacistDashboard();
                pd.setVisible(true);
                JOptionPane.showMessageDialog(null, "Welcome to Rangie Drug Store", null, JOptionPane.PLAIN_MESSAGE);
            } else {
                Login login = new Login();
                JOptionPane.showMessageDialog(null, "Incorrect email or password.", "Error", JOptionPane.ERROR_MESSAGE);
                login.setVisible(true);
            }
            System.out.println(result);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

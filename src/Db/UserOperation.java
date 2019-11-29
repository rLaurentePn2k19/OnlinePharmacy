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
import pharmacyAppFrames.*;

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
        int e = 0;
        int account_id = 0;
        insertQuery = String.format("INSERT INTO `accounts` (name,age,email,password,ecoin) "
                + "VALUES ('%s','%d','%s','%s','%d')", name, age, email, password, 3000);
        String retrieveUser;
        retrieveUser = "SELECT id,ecoin from `accounts` where email = '" + email
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
                        e = res.getInt("ecoin");
                        System.out.println(e + " Ecoin given");
                    }
                    SeniorCDashboard scd = new SeniorCDashboard();
                    scd.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Welcome to Rangie Drug Store", null, JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(null, "You can purchase our medicine with 20% discount..", null, JOptionPane.PLAIN_MESSAGE);
                } else {
                    stmtRetrieve = conn.createStatement();
                    ResultSet res = stmtRetrieve.executeQuery(retrieveUser);
                    if (res.next()) {
                        e = res.getInt("ecoin");
                        account_id = res.getInt("id");
                        System.out.println(res.getInt("ecoin") + " Ecoin given");
                    }
                    CustomerDashboard customer = new CustomerDashboard(e,account_id);
                    customer.setVisible(true);
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
        retrievetQuery = "SELECT age,ecoin,email,password from `accounts` where email = '" + email
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
                int e = result.getInt("ecoin");
                account_id = result.getInt("id");
                if (age < 60) {
                    CustomerDashboard cd = new CustomerDashboard(e,account_id);
                    cd.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Welcome to Rangie Drug Store", null, JOptionPane.PLAIN_MESSAGE);
                } else if (age > 60) {
                    SeniorCDashboard sc = new SeniorCDashboard();
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

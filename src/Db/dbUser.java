/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import API.CustomerTransaction;
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
public class dbUser implements DbConnect {

    public void CreateAccount(String name, int age, String email, String password) {
        Connection conn = null;
        Statement stmt = null;
        String insertQuery;
        CustomerDashboard customer = new CustomerDashboard();
        SeniorCDashboard scd = new SeniorCDashboard();
        insertQuery = String.format("INSERT INTO `accounts` (name,age,email,password,ecoin) "
                + "VALUES ('%s','%d','%s','%s','%d')", name, age, email, password, 2000);
        String retrieveUser;

        retrieveUser = "SELECT ecoin from `accounts` where email = '" + email
                + "' and password = '" + password + "'";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(insertQuery);
            if (age > 60) {
                ResultSet res = stmt.executeQuery(retrieveUser);
                while (res.next()) {
                    CustomerTransaction ct = new CustomerTransaction();
                    int e = res.getInt("ecoin");
                    System.out.println(e);
                    ct.setEcoin(e);
                }
                scd.setVisible(true);
                JOptionPane.showMessageDialog(null, "Welcome to Rangie Drug Store", null, JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "You can purchase our medicine with 20% discount..", null, JOptionPane.PLAIN_MESSAGE);
                
            } else {
                ResultSet res = stmt.executeQuery(retrieveUser);
                while (res.next()) {
                    CustomerTransaction ct = new CustomerTransaction();
                    int e = res.getInt("ecoin");
                    System.out.println(e);
                    ct.setEcoin(e);
                }
                customer.setVisible(true);
                JOptionPane.showMessageDialog(null, "Welcome to Rangie Drug Store", null, JOptionPane.PLAIN_MESSAGE);
                
            }
//            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getUser(String email, String password) {
        Connection conn = null;
        Statement stmt = null;
        String retrievetQuery;
        String em = "";
        String pass = "";
        int age = 0;
        retrievetQuery = "SELECT age,ecoin,email,password from `accounts` where email = '" + email
                + "' and password = '" + password + "'";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(retrievetQuery);
            while (result.next()) {
                em = result.getString("email");
                pass = result.getString("password");
                age = result.getInt("age");
            }
            if (email.equals(em) && password.equals(pass)) {
//                int e = result.getInt("ecoin");
                if (age < 60) {
                    CustomerDashboard cd = new CustomerDashboard();
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
//            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

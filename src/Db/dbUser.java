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
public class dbUser implements DbConnect {

    public void CreateAccount(String name, int age, String email, String password) {

        Connection conn = null;
        Statement stmt = null;
        String insertQuery;
        CustomerDashboard customer = new CustomerDashboard();
        SeniorCDashboard scd = new SeniorCDashboard();

        insertQuery = String.format("INSERT INTO `accounts` (name,age,email,password) "
                + "VALUES ('%s','%d','%s','%s')", name, age, email, password);
        try {
            System.out.println("asdsadsad");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(insertQuery);
            if (age > 60) {
                JOptionPane.showMessageDialog(null, "You can purchase our medicine with 20% discount..", null, JOptionPane.PLAIN_MESSAGE);
                scd.setVisible(true);
            }else{
                customer.setVisible(true);
            }
            System.out.println(result);
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

        retrievetQuery = "SELECT email,password from `accounts` where email = '" + email
                + "' and password = '" + password + "'";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(retrievetQuery);
            while (result.next()) {
                em = result.getString("email");
                pass = result.getString("password");
            }
            if (email.equals(em) && password.equals(pass)) {
                CustomerDashboard cd = new CustomerDashboard();
                cd.setVisible(true);
            } else if(email.equals("pharma") && password.equals("pharma")) {
                PharmacistDashboard pd = new PharmacistDashboard();
                pd.setVisible(true);
            }else{
                Login login = new Login();
                JOptionPane.showMessageDialog(null, "Incorrect email or password.", "Error", JOptionPane.ERROR_MESSAGE);
                login.setVisible(true);
            }
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

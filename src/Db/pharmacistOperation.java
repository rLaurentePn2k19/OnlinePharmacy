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
import pharmacyAppFrames.CustomerDashboard;
import pharmacyAppFrames.PharmacistDashboard;

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
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Object[][] viewMedicineForCough() {
        Connection conn = null;
        Statement stmt = null;
        String brandname = null;
        String genericname = null;
        String price = null;
        String type = null;
        String quantity = null;
        Object[][] data = new Object[500][5];

        String selectQuery;

        selectQuery = "SELECT * `medicineforcough` (brandname,genericname,price,type,quantity)";
        try {
            int cols = 0;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectQuery);
            while (result.next()) {
//                brandname = result.getString("brandname");
//                genericname = result.getString("genericname");
//                price = result.getString("price");
//                type = result.getString("type");
//                quantity = result.getString("quantity");
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
}

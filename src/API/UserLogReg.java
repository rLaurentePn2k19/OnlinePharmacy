/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import javax.swing.JOptionPane;
import pharmacyAppFrames.*;
import Db.*;

/**
 *
 * @author 2ndyrGroupB
 */
public class UserLogReg {

    Login loginFrame = new Login();
    Register registerFrame = new Register();

    public void userLogin(String email, String password) {
        if (email.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Please input username and password.", "Error", JOptionPane.ERROR_MESSAGE);
            loginFrame.setVisible(true);
        } else {
            UserOperation db = new UserOperation();
            db.getUser(email, password);
            loginFrame.dispose();
        }
    }

    public void userRegister(String email, String password, String age, String name) {
        if (name.equals("") || email.equals("") || password.equals("") || age.equals("")) {
            JOptionPane.showMessageDialog(null, "Please input the given fields to register.", "Error", JOptionPane.ERROR_MESSAGE);
            registerFrame.setVisible(true);
        }else{
            UserOperation db = new UserOperation();
            db.CreateAccount(name, Integer.valueOf(age), email, password);
            registerFrame.dispose();
        }
    }
}

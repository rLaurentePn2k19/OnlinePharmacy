/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author 2ndyrGroupB
 */
public class User implements UserTransaction {

    JButton LoginBtn = new JButton("Login");
    JButton RegisterBtn = new JButton("Register");
    JFrame Frame = new JFrame("Rangie's Drug Store");
    JPanel Panel = new JPanel();
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static List<Account> RegisteredPharmacists = new ArrayList<>();
    private static List<Account> RegisteredCustomers = new ArrayList<>();
    private static List<MedicineForCough> medicineForCough = new ArrayList<>();
    private static List<MedicineForHeadache> medicineForHeadache = new ArrayList<>();
    private static List<MedicineForBodyPain> medicineForBodyPain = new ArrayList<>();
    private static List<MedicineForAllergies> medicineForAllergies = new ArrayList<>();

    Scanner user_input = new Scanner(System.in);
    Scanner int_input = new Scanner(System.in);

    public User() {

    }

    public static List<Account> getRegisteredPharmacists() {
        return RegisteredPharmacists;
    }

    public static void setRegisteredPharmacists(List<Account> RegisteredPharmacists) {
        User.RegisteredPharmacists = RegisteredPharmacists;
    }

    public static List<Account> getRegisteredCustomers() {
        return RegisteredCustomers;
    }

    public static void setRegisteredCustomers(List<Account> RegisteredCustomers) {
        User.RegisteredCustomers = RegisteredCustomers;
    }

    public static List<MedicineForCough> getMedicineForCough() {
        return medicineForCough;
    }

    public static void setMedicineForCough(List<MedicineForCough> medicineForCough) {
        User.medicineForCough = medicineForCough;
    }

    public static List<MedicineForHeadache> getMedicineForHeadache() {
        return medicineForHeadache;
    }

    public static void setMedicineForHeadache(List<MedicineForHeadache> medicineForHeadache) {
        User.medicineForHeadache = medicineForHeadache;
    }

    public static List<MedicineForBodyPain> getMedicineForBodyPain() {
        return medicineForBodyPain;
    }

    public static void setMedicineForBodyPain(List<MedicineForBodyPain> medicineForBodyPain) {
        User.medicineForBodyPain = medicineForBodyPain;
    }

    public static List<MedicineForAllergies> getMedicineForAllergies() {
        return medicineForAllergies;
    }

    public static void setMedicineForAllergies(List<MedicineForAllergies> medicineForAllergies) {
        User.medicineForAllergies = medicineForAllergies;
    }

    @Override
    public void AfterLoggedout(Account a) {
        System.out.println("\n1. Register\n2. Log in\n");
        System.out.print("-> ");
        String des = user_input.nextLine();
        switch (des) {
            case "1":
                User a1 = new User();
                Account newAcc = new Account();
                a1.Register(newAcc);
                break;
            case "2":
                this.LoginAs(a);
                break;
            default:
                this.AfterLoggedout(a);
                break;
        }
    }

    @Override
    public void LoginAs(Account a) {
        System.out.print("\n1. Customer\n2. Pharmacist\n\nLogin as: ");
        String log = user_input.nextLine();
        switch (log) {
            case "1":
                this.LoginAsCustomer(a);
                break;
            case "2":
                this.LoginAsPharmacist(a);
                break;
            default:
                this.Login(a);
                break;
        }
    }

    @Override
    public void Login(Account a) {
        System.out.print("\n1. Customer\n2. Pharmacist\n\nLogin as: ");
        String log = user_input.nextLine();
        switch (log) {
            case "1":
                this.LoginAsCustomer(a);
                break;
            case "2":
                this.LoginAsPharmacist(a);
                break;
            default:
                this.Login(a);
                break;
        }
    }

    @Override
    public void Basic(Account a) {
        JLabel loginText, username, password;
        JTextField inputField;
        JPasswordField passwordField;

        loginText = new JLabel("Login");
        loginText.setFont(new Font("Serif", Font.BOLD, 20));

        
        username = new JLabel("Username");
        password = new JLabel("Password");
        inputField = new JTextField();
        passwordField = new JPasswordField();


        loginText.setBounds(180, 30, 400, 30);
        username.setBounds(50, 70, 200, 30);
        password.setBounds(50, 110, 200, 30);
        inputField.setBounds(120, 70, 200, 30);
        passwordField.setBounds(120, 110, 200, 30);
        LoginBtn.setBounds(150, 160, 100, 30);

        LoginBtn.addActionListener((ActionEvent e) -> {
            String uname = inputField.getText();
            String pass = passwordField.getText();
            if (uname.equals("rangie") && pass.equals("gwapo")) {
                JLabel label = new JLabel("Welcome:" + uname );
                JOptionPane.showMessageDialog(Frame,"Welcome to Rangie's Drug Store",
                "Success",JOptionPane.PLAIN_MESSAGE);  
            } else {
                JOptionPane.showMessageDialog(Frame,"Incorrect login or password",
                "Error",JOptionPane.ERROR_MESSAGE);  
            }

        });
        
        Panel.add(RegisterBtn);
        Frame.add(Panel);
        Frame.add(loginText);
        Frame.add(username);
        Frame.add(inputField);
        Frame.add(password);
        Frame.add(passwordField);
        Frame.add(LoginBtn);
        Frame.setSize(400, 400);
        Frame.setLayout(null);
        Frame.setVisible(true);

//        RegisterBtn.addActionListener((ActionEvent e) -> {
//            JPanel popUpReg = new JPanel(new BorderLayout(5, 5));
//            JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
//            label.add(new JLabel("Username", SwingConstants.RIGHT));
//            label.add(new JLabel("Password", SwingConstants.RIGHT));
//            popUpReg.add(label, BorderLayout.WEST);
//            JPanel InputFields = new JPanel(new GridLayout(3, 1, 2, 2));
//            JTextField username = new JTextField();
//            InputFields.add(username);
//            JPasswordField password = new JPasswordField();
//            InputFields.add(password);
//            popUpReg.add(InputFields, BorderLayout.CENTER);
//            JOptionPane.showMessageDialog(Frame, popUpReg, "Register", JOptionPane.PLAIN_MESSAGE);
//        });
//        LoginBtn.addActionListener((ActionEvent e) -> {
//            JPanel popUpLogin = new JPanel(new BorderLayout(5, 5));
//            JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
//            label.add(new JLabel("Username", SwingConstants.RIGHT));
//            label.add(new JLabel("Password", SwingConstants.RIGHT));
//            popUpLogin.add(label, BorderLayout.WEST);
//            JPanel InputFields = new JPanel(new GridLayout(3, 1, 2, 2));
//            JTextField username = new JTextField();
//            InputFields.add(username);
//            JPasswordField password = new JPasswordField();
//            InputFields.add(password);
//            popUpLogin.add(InputFields, BorderLayout.CENTER);
//            JOptionPane.showMessageDialog(Frame, popUpLogin, "Login", JOptionPane.PLAIN_MESSAGE);
//        });
//        RegisterBtn.setVisible(true);
//        LoginBtn.setVisible(true);
//        Frame.setSize(400, 400);
//        Frame.setVisible(true);
//        Panel.add(LoginBtn);
//        Panel.add(RegisterBtn);
//        Frame.add(Panel);
//        Frame.add(Panel);
        int x = (int) ((dimension.getWidth() - Frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Frame.getHeight()) / 2);
        Frame.setLocation(x, y);

        //        System.err.println(ANSI_CYAN + "Notice to the users: \n\t\tJust type the number assigned to the transaction that you will do later in the program.\n\t\t" + ANSI_YELLOW + "Example: 1.Purchase\n" + ANSI_RESET);
        //        System.out.print("\nAlready have an account? yes/no : ");
        //        String log = user_input.nextLine();
        //        switch (log) {
        //            case "yes":
        //                this.Login(a);
        //                break;
        //            case "no":
        //                this.Register(a);
        //                break;
        //            default:
        //                this.Basic(a);
        //                break;
        //        }
    }

    @Override
    public void Register(Account a) {
        System.out.println("\n--- REGISTER HERE ---");
        System.out.print("\n1. Customer\n2. Pharmacist\n");
        System.out.print("\nRegister as: ");
        String register = user_input.nextLine();
        switch (register) {
            case "1": {
                this.RegisterAsCustomer(a);
                break;
            }
            case "2": {
                this.RegisterAsPharmacist(a);
                break;
            }
            default:
                this.Register(a);
                System.err.println("\nInvalid Input!");
                break;
        }
    }

    @Override
    public void LoginAsPharmacist(Account a) {
        Pharmacist pharmacist = new Pharmacist();
        pharmacist.Login(a);

    }

    @Override
    public void LoginAsCustomer(Account a) {
        if (a.getAge() < 60) {
            Adult adult = new Adult();
            adult.setEcoin(5000); // Default ecoin for adult
            adult.LoginAsAdult(a);
        } else if (a.getAge() > 60) {
            SeniorCitizen senior = new SeniorCitizen();
            senior.setEcoin(5000); // Default ecoin for senior citizen
            senior.LoginAsSeniorCitizen(a);
        } else if (a.getAge() < 1) {
            System.err.println("\nInvalid Age!");
        }
    }

    @Override
    public void Logout(Account a) {
        while (true) {
            System.out.println("\nYou are now logged out.\n");
            System.out.print(ANSI_CYAN + "Do you want to exit the program? yes/no: " + ANSI_RESET);
            String exit = user_input.nextLine();
            switch (exit) {
                case "no":
                    this.AfterLoggedout(a);
                    break;
                case "yes":
                    System.out.println("\nExit");
                    Runtime.getRuntime().exit(0);
                default:
                    this.Logout(a);
                    break;
            }
        }
    }

    @Override
    public void RegisterAsCustomer(Account a) {
        System.out.print(ANSI_YELLOW + "\nEnter first name: " + ANSI_RESET);
        String fname = user_input.nextLine();
        a.setFname(fname);
        System.out.print(ANSI_YELLOW + "Enter last name: " + ANSI_RESET);
        String lname = user_input.nextLine();
        a.setLname(lname);
        System.out.print(ANSI_YELLOW + "Enter age: " + ANSI_RESET);
        int age = int_input.nextInt();
        if (age < 18) {
            System.err.println("\nMinor is restricted.");
            this.AfterLoggedout(a);
        } else {
            a.setAge(age);
        }
        System.out.print(ANSI_YELLOW + "Enter username: " + ANSI_RESET);
        String uname = user_input.nextLine();
        a.setUserName(uname);
        System.out.print(ANSI_YELLOW + "Enter password: " + ANSI_RESET);
        String pass = user_input.nextLine();
        a.setPassWord(pass);
        System.out.print(ANSI_YELLOW + "Enter address: " + ANSI_RESET);
        String address = user_input.nextLine();
        a.setAddress(address);
        this.addRegisteredCustomer(a);
        this.LoginAsCustomer(a);
    }

    @Override
    public void RegisterAsPharmacist(Account a) {
        System.out.print(ANSI_YELLOW + "\nEnter first name: " + ANSI_RESET);
        String fname = user_input.nextLine();
        a.setFname(fname);
        System.out.print(ANSI_YELLOW + "Enter last name: " + ANSI_RESET);
        String lname = user_input.nextLine();
        a.setLname(lname);
        System.out.print(ANSI_YELLOW + "Enter age : " + ANSI_RESET);
        int age = int_input.nextInt();
        if (age < 18) {
            System.err.println("\nMinor is restricted.");
            this.AfterLoggedout(a);
        } else {
            a.setAge(age);
        }
        System.out.print(ANSI_YELLOW + "Enter username: " + ANSI_RESET);
        String uname = user_input.nextLine();
        a.setUserName(uname);
        System.out.print(ANSI_YELLOW + "Enter password: " + ANSI_RESET);
        String pass = user_input.nextLine();
        a.setPassWord(pass);
        System.out.print(ANSI_YELLOW + "Enter Licensed No: " + ANSI_RESET);
        String licensed = user_input.nextLine();
        a.setPharLicensedNo(Integer.valueOf(licensed));
        System.out.print(ANSI_YELLOW + "Enter address: " + ANSI_RESET);
        String address = user_input.nextLine();
        a.setAddress(address);
        this.addRegisteredPharmacist(a);
        this.LoginAsPharmacist(a);
    }

    public void addRegisteredPharmacist(Account a) {
        RegisteredPharmacists.add(a);
    }

    public void addRegisteredCustomer(Account a) {
        RegisteredCustomers.add(a);
    }
}

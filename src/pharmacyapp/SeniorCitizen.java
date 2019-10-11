/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;

import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupB
 */
public class SeniorCitizen extends Customer {

    Scanner input = new Scanner(System.in);
    Scanner int_input = new Scanner(System.in);

    public SeniorCitizen() {
    }

    public SeniorCitizen(int ecoin) {
        super(ecoin);
    }

    @Override
    public void viewAvailableMedicines(Account a) {
        Pharmacist p = new Pharmacist();
        System.out.println("\n1. Medicines for cough\n2. Medicines for headache\n3. Medicines for body pain\n4. Medicines for allergies\n5. Back");
        System.out.print("\nWhat specific list medicines you want to view?: ");
        String choose = input.nextLine();
        switch (choose) {
            case "1":
                p.displayAvailableMedicinesForCough();
                break;
            case "2":
                p.displayAvailableMedicinesForHeadache();
                break;
            case "3":
                p.displayAvailableMedicinesForBodyPain();
                break;
            case "4":
                p.displayAvailableMedicinesForAllergies();
                break;
            case "5":
                this.CustomerMainTransaction(a);
                break;
            default:
                break;
        }
    }

    @Override
    public void purchaseMedicines(Account a) {

        System.out.println("\nSelect a specific list of medicines you want to buy of. ");
        System.out.println("\n1. Medicines For Cough\n2. Medicines For Headache\n3. Medicines For Body Pain\n4. Medicines For Allergies\n5. Back");
        System.out.print("\nWhat specific list medicines the medicine you want to buy?: ");
        String selection = input.nextLine();
        switch (selection) {
            case "1":
                this.purchaseMedicineForCough();
                break;
            case "2":
                this.purchaseMedicineForHeadache();
                break;
            case "3":
                this.purchaseMedicineForBodyPain();
                break;
            case "4":
                this.purchaseMedicineForAllergies();
                break;
            case "5":
                this.CustomerMainTransaction(a);
                break;
            default:
                break;
        }
    }

    @Override
    public void purchaseMedicineForHeadache() {
        Pharmacist p = new Pharmacist();
        p.displayAvailableMedicinesForHeadache();
        System.out.print("\nSelect the ID of the medicine you want to buy: ");
        int id = int_input.nextInt();
        for (int i = 0; i < User.getMedicineForHeadache().size(); i++) {
            if (User.getMedicineForHeadache().get(i).getId() == id) {
                System.out.print("\nHow many " + User.getMedicineForHeadache().get(i).getBrandName() + " do you want to buy? : ");
                int buy = int_input.nextInt();
                if (buy == User.getMedicineForHeadache().get(i).getQuantity()) {
                    User.getMedicineForHeadache().remove(User.getMedicineForHeadache().get(i));
                    for (int x = 0; x < User.getMedicineForHeadache().size(); x++) {
                        User.getMedicineForHeadache().get(x).setId(x + 1);
                    }
                    super.getPurchased_med().put(User.getMedicineForHeadache().get(i).getBrandName(), buy);
                    System.out.println("\nReciept: ");
                    int money = super.getEcoin();
                    int price = User.getMedicineForHeadache().get(i).getPrice();
                    float discount = (float) (0.2 * price);
                    int remaining = (int) (money - discount * buy);
                    super.setEcoin(remaining);
                    System.out.println(User.getMedicineForHeadache().get(i).getBrandName() + ": " + User.getMedicineForHeadache().get(i).getPrice() + " * " + buy);
                    System.out.println("______________\nTotal: " + discount * buy);
                    System.out.println("You availed 20% discount.");
                    System.out.println("\nAccount money: " + remaining);
                } else if (buy < User.getMedicineForHeadache().get(i).getQuantity()) {
                    User.getMedicineForHeadache().get(i).setQuantity(User.getMedicineForHeadache().get(i).getQuantity() - buy);
                    System.out.println("Successfully Purchased!");
                    if (super.getPurchased_med().containsKey(User.getMedicineForHeadache().get(i).getBrandName())) {
                        super.getPurchased_med().put(User.getMedicineForHeadache().get(i).getBrandName(), super.getPurchased_med().get(User.getMedicineForHeadache().get(i).getBrandName()) + buy);
                    } else {
                        super.getPurchased_med().put(User.getMedicineForHeadache().get(i).getBrandName(), buy);
                    }
                    System.out.println("\nReciept: ");
                    int money = super.getEcoin();
                    int price = User.getMedicineForHeadache().get(i).getPrice();
                    float discount = (float) (0.2 * price);
                    float discounted = (buy * price) - (discount * buy);
                    int remaining = (int) (money - discounted);
                    super.setEcoin(remaining);
                    System.out.println(User.getMedicineForHeadache().get(i).getBrandName() + ": " + User.getMedicineForHeadache().get(i).getPrice() + " * " + buy);
                    System.out.println("______________\nTotal: " + discounted);
                    System.out.println("You availed 20% discount.");
                    System.out.println("\nAccount money: " + remaining);
                } else if (buy > User.getMedicineForCough().get(i).getQuantity()) {
                    System.err.println("\nThe quantity of the medicine you want to buy is only " + User.getMedicineForCough().get(i).getQuantity());
                }
            }
        }
    }

    @Override
    public void purchaseMedicineForBodyPain() {
        Pharmacist p = new Pharmacist();
        p.displayAvailableMedicinesForBodyPain();
        System.out.print("\nSelect the ID of the medicine you want to buy: ");
        int id = int_input.nextInt();
        for (int i = 0; i < User.getMedicineForBodyPain().size(); i++) {
            if (User.getMedicineForBodyPain().get(i).getId() == id) {
                System.out.print("\nHow many " + User.getMedicineForBodyPain().get(i).getBrandName() + " do you want to buy? : ");
                int buy = int_input.nextInt();
                if (buy == User.getMedicineForBodyPain().get(i).getQuantity()) {
                    User.getMedicineForBodyPain().remove(User.getMedicineForBodyPain().get(i));
                    for (int x = 0; x < User.getMedicineForBodyPain().size(); x++) {
                        User.getMedicineForBodyPain().get(x).setId(x + 1);
                    }
                    super.getPurchased_med().put(User.getMedicineForHeadache().get(i).getBrandName(), buy);
                    System.out.println("\nReciept: ");
                    int money = super.getEcoin();
                    int price = User.getMedicineForBodyPain().get(i).getPrice();
                    float discount = (float) (0.2 * price);
                    int remaining = (int) (money - discount * buy);
                    super.setEcoin(remaining);
                    System.out.println(User.getMedicineForBodyPain().get(i).getBrandName() + ": " + User.getMedicineForBodyPain().get(i).getPrice() + " * " + buy);
                    System.out.println("______________\nTotal: " + discount * buy);
                    System.out.println("You availed 20% discount.");
                    System.out.println("\nAccount money: " + remaining);
                } else if (buy < User.getMedicineForBodyPain().get(i).getQuantity()) {
                    User.getMedicineForBodyPain().get(i).setQuantity(User.getMedicineForBodyPain().get(i).getQuantity() - buy);
                    System.out.println("Successfully Purchased!");
                    if (super.getPurchased_med().containsKey(User.getMedicineForBodyPain().get(i).getBrandName())) {
                        super.getPurchased_med().put(User.getMedicineForBodyPain().get(i).getBrandName(), super.getPurchased_med().get(User.getMedicineForBodyPain().get(i).getBrandName()) + buy);
                    } else {
                        super.getPurchased_med().put(User.getMedicineForBodyPain().get(i).getBrandName(), buy);
                    }
                    System.out.println("\nReciept: ");
                    int money = super.getEcoin();
                    int price = User.getMedicineForBodyPain().get(i).getPrice();
                    float discount = (float) (0.2 * price);
                    float discounted = (buy * price) - (discount * buy);
                    int remaining = (int) (money - discounted);
                    super.setEcoin(remaining);
                    System.out.println(User.getMedicineForBodyPain().get(i).getBrandName() + ": " + User.getMedicineForBodyPain().get(i).getPrice() + " * " + buy);
                    System.out.println("______________\nTotal: " + discounted);
                    System.out.println("You availed 20% discount.");
                    System.out.println("\nAccount money: " + remaining);
                } else if (buy > User.getMedicineForCough().get(i).getQuantity()) {
                    System.err.println("\nThe quantity of the medicine you want to buy is only " + User.getMedicineForCough().get(i).getQuantity());
                }
            }
        }
    }

    @Override
    public void purchaseMedicineForAllergies() {
        Pharmacist p = new Pharmacist();
        p.displayAvailableMedicinesForAllergies();
        System.out.print("\nSelect the ID of the medicine you want to buy: ");
        int id = int_input.nextInt();
        for (int i = 0; i < User.getMedicineForAllergies().size(); i++) {
            if (User.getMedicineForAllergies().get(i).getId() == id) {
                System.out.print("\nHow many " + User.getMedicineForAllergies().get(i).getBrandName() + " do you want to buy? : ");
                int buy = int_input.nextInt();
                if (buy == User.getMedicineForAllergies().get(i).getQuantity()) {
                    User.getMedicineForAllergies().remove(User.getMedicineForAllergies().get(i));
                    for (int x = 0; x < User.getMedicineForAllergies().size(); x++) {
                        User.getMedicineForAllergies().get(x).setId(x + 1);
                    }
                    super.getPurchased_med().put(User.getMedicineForHeadache().get(i).getBrandName(), buy);
                    System.out.println("\nReciept: ");
                    int money = super.getEcoin();
                    int price = User.getMedicineForAllergies().get(i).getPrice();
                    float discount = (float) (0.2 * price);
                    float discounted = (buy * price) - (discount * buy);
                    int remaining = (int) (money - discounted);
                    super.setEcoin(remaining);
                    System.out.println(User.getMedicineForAllergies().get(i).getBrandName() + ": " + User.getMedicineForAllergies().get(i).getPrice() + " * " + buy);
                    System.out.println("______________\nTotal: " + discount * buy);
                    System.out.println("You availed 20% discount.");
                    System.out.println("\nAccount money: " + remaining);
                } else if (buy < User.getMedicineForAllergies().get(i).getQuantity()) {
                    User.getMedicineForAllergies().get(i).setQuantity(User.getMedicineForAllergies().get(i).getQuantity() - buy);
                    System.out.println("Successfully Purchased!");
                    if (super.getPurchased_med().containsKey(User.getMedicineForAllergies().get(i).getBrandName())) {
                        super.getPurchased_med().put(User.getMedicineForAllergies().get(i).getBrandName(), super.getPurchased_med().get(User.getMedicineForAllergies().get(i).getBrandName()) + buy);
                    } else {
                        super.getPurchased_med().put(User.getMedicineForAllergies().get(i).getBrandName(), buy);
                    }
                    System.out.println("\nReciept: ");
                    int money = super.getEcoin();
                    int price = User.getMedicineForAllergies().get(i).getPrice();
                    float discount = (float) (0.2 * price);
                    float discounted = (buy * price) - (discount * buy);
                    int remaining = (int) (money - discounted);
                    super.setEcoin(remaining);
                    System.out.println(User.getMedicineForAllergies().get(i).getBrandName() + ": " + User.getMedicineForAllergies().get(i).getPrice() + " * " + buy);
                    System.out.println("______________\nTotal: " + discounted);
                    System.out.println("You availed 20% discount.");
                    System.out.println("\nAccount money: " + remaining);
                } else if (buy > User.getMedicineForCough().get(i).getQuantity()) {
                    System.err.println("\nThe quantity of the medicine you want to buy is only " + User.getMedicineForCough().get(i).getQuantity());
                }
            }
        }
    }

    @Override
    public void purchaseMedicineForCough() {
        Pharmacist p = new Pharmacist();
        p.displayAvailableMedicinesForCough();
        System.out.print("\nSelect the ID of the medicine you want to buy: ");
        int id = int_input.nextInt();
        for (int i = 0; i < User.getMedicineForCough().size(); i++) {
            if (User.getMedicineForCough().get(i).getId() == id) {
                System.out.print("\nHow many " + User.getMedicineForCough().get(i).getBrandName() + " do you want to buy? : ");
                int buy = int_input.nextInt();
                if (buy == User.getMedicineForCough().get(i).getQuantity()) {
                    User.getMedicineForCough().remove(User.getMedicineForCough().get(i));
                    for (int x = 0; x < User.getMedicineForCough().size(); x++) {
                        User.getMedicineForCough().get(x).setId(x + 1);
                    }
                    super.getPurchased_med().put(User.getMedicineForHeadache().get(i).getBrandName(), buy);
                    System.out.println("\nReciept: ");
                    int money = super.getEcoin();
                    int price = User.getMedicineForCough().get(i).getPrice();
                    float discount = (float) (0.2 * price);
                    int remaining = (int) (money - discount * buy);
                    super.setEcoin(remaining);
                    System.out.println(User.getMedicineForCough().get(i).getBrandName() + ": " + User.getMedicineForCough().get(i).getPrice() + " * " + buy);
                    System.out.println("______________\nTotal: " + discount * buy);
                    System.out.println("You availed 20% discount.");
                    System.out.println("\nAccount money: " + remaining);
                } else if (buy < User.getMedicineForCough().get(i).getQuantity()) {
                    User.getMedicineForCough().get(i).setQuantity(User.getMedicineForCough().get(i).getQuantity() - buy);
                    System.out.println("Successfully Purchased!");
                    if (super.getPurchased_med().containsKey(User.getMedicineForCough().get(i).getBrandName())) {
                        super.getPurchased_med().put(User.getMedicineForCough().get(i).getBrandName(), super.getPurchased_med().get(User.getMedicineForCough().get(i).getBrandName()) + buy);
                    } else {
                        super.getPurchased_med().put(User.getMedicineForCough().get(i).getBrandName(), buy);
                    }
                    System.out.println("\nReciept: ");
                    int money = super.getEcoin();
                    int price = User.getMedicineForCough().get(i).getPrice();
                    float discount = (float) (0.2 * price);
                    float discounted = (buy * price) - (discount * buy);
                    int remaining = (int) (money - discounted);
                    super.setEcoin(remaining);
                    System.out.println(User.getMedicineForCough().get(i).getBrandName() + ": " + User.getMedicineForCough().get(i).getPrice() + " * " + buy);
                    System.out.println("______________\nTotal: " + discounted);
                    System.out.println("You availed 20% discount.");
                    System.out.println("\nAccount money: " + remaining);
                } else if (buy > User.getMedicineForCough().get(i).getQuantity()) {
                    System.err.println("\nThe quantity of the medicine you want to buy is only " + User.getMedicineForCough().get(i).getQuantity());
                }
            }
        }
    }

    @Override
    public void viewPurchasedMedicines(Account a) {
        System.out.println("\nPurchased Medicines: \n");
        System.out.println(super.getPurchased_med());
    }

    @Override
    public void LoginAsSeniorCitizen(Account a) {
        System.out.println("\n--- LOGIN ---\nYou have 3 trials to Login");
        int trial = 0;
        while (trial != 3) {
            System.out.print(ANSI_YELLOW + "\nEnter Username: " + ANSI_RESET);
            String username = input.nextLine();
            System.out.print(ANSI_YELLOW + "Enter Password: " + ANSI_RESET);
            String password = input.nextLine();
            for (Account registeredCustomer : User.getRegisteredCustomers()) {
                if (registeredCustomer.getUserName().equals(username) && registeredCustomer.getPassWord().equals(password)) {
                    System.out.println("\n--- WELCOME to ROSE PHARMACY ---\n\n" + a.getUserName() + " you are now logged in.\n");
                    System.out.println("\nYou can now purchase medicines.");
                    System.out.println(ANSI_GREEN+"\nYou can avail 20% discount in every medicine you want to buy."+ ANSI_RESET);
                    this.CustomerMainTransaction(a);
                }
                trial++;
            }
        }
        if (trial == 3) {
            System.err.println("\nYou've exceed the number of trials.");
            Runtime.getRuntime().exit(0);
        }
    }

    @Override
    public void CustomerMainTransaction(Account a) {
        while (true) {
            System.out.println("\n--- CHOOSE OPERATION ---");
            System.out.println("\n1. View Available Medicines\n2. Purchase Medicines\n3. View Purchased Medicines\n4. My Account\n5. Account Money\n6. Logout");
            System.out.print(ANSI_CYAN + "\nSelect Transaction: " + ANSI_RESET);
            String selection = input.nextLine();
            switch (selection) {
                case "1":
                    this.viewAvailableMedicines(a);
                    break;
                case "2":
                    this.purchaseMedicines(a);
                    break;
                case "3":
                    this.viewPurchasedMedicines(a);
                    break;
                case "4":
                    for (int i = 0; i < User.getRegisteredCustomers().size(); i++) {
                        if (User.getRegisteredCustomers().get(i).equals(a)) {
                            System.out.println("\nPersonal Profile:");
                            User.getRegisteredCustomers().get(i).myAccountC();
                            System.out.println("\n");
                        }
                    }
                    break;
                case "5":
                    System.out.println("\nYou have ₱" + super.getEcoin()+ " ecoin.");
                    break;
                case "6":
                    System.out.print(ANSI_CYAN + "\nAre you sure to Logout? " + ANSI_WHITE + "yes/no : " + ANSI_RESET);
                    String logout = input.nextLine();
                    switch (logout) {
                        case "yes":
                            this.Logout(a);
                            break;
                        case "no":
                            this.CustomerMainTransaction(a);
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void Logout(Account a) {
        super.Logout(a);
    }

    @Override
    public void LoginAsAdult(Account a) {

    }
}

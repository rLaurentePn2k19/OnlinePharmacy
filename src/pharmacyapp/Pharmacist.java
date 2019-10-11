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
public class Pharmacist extends User implements PharmacistOperation {

    Scanner input = new Scanner(System.in);
    Scanner int_input = new Scanner(System.in);

    public Pharmacist() {
        super();
    }

    @Override
    public void inventoryMedicineForCough() {
        System.out.println("\n\t--- INVENTORY OF MEDICINES FOR COUGH ---");
        System.out.println("____________________________________________________________");
        System.out.printf("%-12s \t| %-11s \t| %-6s \t| %-8s", ANSI_GREEN + "Brand Name", "Generic Name", "Type", "Quantity\n" + ANSI_RESET);
        System.out.println("____________________________________________________________");
        for (int i = 0; i < User.getMedicineForCough().size(); i++) {
            System.out.printf("%-12s \t| %-11s \t| %-6s \t| %-8d \n", User.getMedicineForCough().get(i).getBrandName(), User.getMedicineForCough().get(i).getGenericName(), User.getMedicineForCough().get(i).getType(), User.getMedicineForCough().get(i).getQuantity());
            System.out.println("____________________________________________________________");
        }
    }

    @Override
    public void inventoryMedicineForHeadache() {
        System.out.println("\n\t--- INVENTORY OF MEDICINES FOR HEAD ACHE ---");
        System.out.println("____________________________________________________________");
        System.out.printf("%-12s \t| %-11s \t| %-6s \t| %-8s", ANSI_GREEN + "Brand Name", "Generic Name", "Type", "Quantity\n" + ANSI_RESET);
        System.out.println("____________________________________________________________");
        for (int i = 0; i < User.getMedicineForHeadache().size(); i++) {
            System.out.printf("%-12s \t| %-11s \t| %-6s \t| %-8d \n", User.getMedicineForHeadache().get(i).getBrandName(), User.getMedicineForHeadache().get(i).getGenericName(), User.getMedicineForHeadache().get(i).getType(), User.getMedicineForHeadache().get(i).getQuantity());
            System.out.println("____________________________________________________________");
        }
    }

    @Override
    public void inventoryMedicineForBodyPain() {
        System.out.println("\n\t--- INVENTORY OF MEDICINES FOR BODY PAIN ---");
        System.out.println("____________________________________________________________");
        System.out.printf("%-12s \t| %-11s \t| %-6s \t| %-8s", ANSI_GREEN + "Brand Name", "Generic Name", "Type", "Quantity\n" + ANSI_RESET);
        System.out.println("____________________________________________________________");
        for (int i = 0; i < User.getMedicineForBodyPain().size(); i++) {
            System.out.printf("%-12s \t| %-11s \t| %-6s \t| %-8d \n", User.getMedicineForBodyPain().get(i).getBrandName(), User.getMedicineForBodyPain().get(i).getGenericName(), User.getMedicineForBodyPain().get(i).getType(), User.getMedicineForBodyPain().get(i).getQuantity());
            System.out.println("____________________________________________________________");
        }
    }

    @Override
    public void inventoryMedicineForAllergies() {
        System.out.println("\n\t--- INVENTORY OF MEDICINES FOR ALLERGIES ---");
        System.out.println("____________________________________________________________");
        System.out.printf("%-12s \t| %-11s \t| %-6s \t| %-8s", ANSI_GREEN + "Brand Name", "Generic Name", "Type", "Quantity\n" + ANSI_RESET);
        System.out.println("____________________________________________________________");
        for (int i = 0; i < User.getMedicineForAllergies().size(); i++) {
            System.out.printf("%-12s \t| %-11s \t| %-6s \t| %-8d \n", User.getMedicineForAllergies().get(i).getBrandName(), User.getMedicineForAllergies().get(i).getGenericName(), User.getMedicineForAllergies().get(i).getType(), User.getMedicineForAllergies().get(i).getQuantity());
            System.out.println("____________________________________________________________");
        }
    }

    @Override
    public void addMedicineForCough(MedicineForCough m) {
        m.setId(User.getMedicineForCough().size() + 1);
        User.getMedicineForCough().add(m);
        System.out.println(ANSI_GREEN + m.getBrandName() + " is successfully added.");
    }

    @Override
    public void addMedicineForHeadache(MedicineForHeadache m) {
        m.setId(User.getMedicineForHeadache().size() + 1);
        User.getMedicineForHeadache().add(m);
        System.out.println(ANSI_GREEN + m.getBrandName() + " is successfully added.");
    }

    @Override
    public void addMedicineForBodyPain(MedicineForBodyPain m) {
        m.setId(User.getMedicineForBodyPain().size() + 1);
        User.getMedicineForBodyPain().add(m);
        System.out.println(ANSI_GREEN + m.getBrandName() + " is successfully added.");
    }

    @Override
    public void addMedicineForAllergies(MedicineForAllergies m) {
        m.setId(User.getMedicineForAllergies().size() + 1);
        User.getMedicineForAllergies().add(m);
        System.out.println(ANSI_GREEN + m.getBrandName() + " is successfully added.");
    }

    @Override
    public void removeMedicineForCough(MedicineForCough m, int id) {
        System.out.print("\nHow many " + m.getBrandName() + " do you want to remove?: ");
        int rem = int_input.nextInt();
        for (int i = 0; i < User.getMedicineForCough().size(); i++) {
            if (User.getMedicineForCough().get(i).getId() == id) {
                if (User.getMedicineForCough().get(i).getQuantity() == rem) {
                    System.out.println("\n" + User.getMedicineForCough().get(i).getBrandName() + " has been removed.");
                    User.getMedicineForCough().remove(User.getMedicineForCough().get(i));
                    for (int x = 0; x < User.getMedicineForCough().size(); x++) {
                        User.getMedicineForCough().get(x).setId(x + 1);
                    }
                } else if (User.getMedicineForCough().get(i).getQuantity() > rem) {
                    User.getMedicineForCough().get(i).setQuantity(User.getMedicineForCough().get(i).getQuantity() - rem);
                    System.out.println(ANSI_CYAN+"\n" + User.getMedicineForCough().get(i).getBrandName() + " is deducted by " + rem+ ANSI_RESET);
                } else {
                    System.err.println("You can only remove less amount of the quantity of medicine.");
                }
            }
        }

    }

    @Override
    public void removeMedicineForHeadache(MedicineForHeadache m, int id) {
        System.out.print("\nHow many " + m.getBrandName() + " do you want to remove?: ");
        int rem = int_input.nextInt();
        for (int i = 0; i < User.getMedicineForHeadache().size(); i++) {
            if (User.getMedicineForHeadache().get(i).getId() == id) {
                if (User.getMedicineForHeadache().get(i).getQuantity() == rem) {
                    System.out.println("\n" + User.getMedicineForHeadache().get(i).getBrandName() + " has been removed.");
                    User.getMedicineForHeadache().remove(User.getMedicineForHeadache().get(i));
                    for (int x = 0; x < User.getMedicineForHeadache().size(); x++) {
                        User.getMedicineForHeadache().get(x).setId(x + 1);
                    }
                } else if (User.getMedicineForHeadache().get(i).getQuantity() > rem) {
                    User.getMedicineForHeadache().get(i).setQuantity(User.getMedicineForHeadache().get(i).getQuantity() - rem);
                    System.out.println(ANSI_CYAN+"\n" + User.getMedicineForHeadache().get(i).getBrandName() + " is deducted by " + rem+ ANSI_RESET);
                } else {
                    System.err.println("You can only remove less amount of the quantity of medicine.");
                }
            }
        }
    }

    @Override
    public void removeMedicineForBodyPain(MedicineForBodyPain m, int id) {
        System.out.print("\nHow many " + m.getBrandName() + " do you want to remove?: ");
        int rem = int_input.nextInt();
        for (int i = 0; i < User.getMedicineForBodyPain().size(); i++) {
            if (User.getMedicineForBodyPain().get(i).getId() == id) {
                if (User.getMedicineForBodyPain().get(i).getQuantity() == rem) {
                    System.out.println("\n" + User.getMedicineForBodyPain().get(i).getBrandName() + " has been removed.");
                    User.getMedicineForBodyPain().remove(User.getMedicineForBodyPain().get(i));
                    for (int x = 0; x < User.getMedicineForBodyPain().size(); x++) {
                        User.getMedicineForBodyPain().get(x).setId(x + 1);
                    }
                } else if (User.getMedicineForBodyPain().get(i).getQuantity() > rem) {
                    User.getMedicineForBodyPain().get(i).setQuantity(User.getMedicineForBodyPain().get(i).getQuantity() - rem);
                    System.out.println(ANSI_CYAN+"\n" + User.getMedicineForBodyPain().get(i).getBrandName() + " is deducted by " + rem+ ANSI_RESET);
                } else {
                    System.err.println("You can only remove less amount of the quantity of medicine.");
                }
            }
        }
    }

    @Override
    public void removeMedicineForAllergies(MedicineForAllergies m, int id) {
        System.out.print("\nHow many " + m.getBrandName() + " do you want to remove?: ");
        int rem = int_input.nextInt();
        for (int i = 0; i < User.getMedicineForAllergies().size(); i++) {
            if (User.getMedicineForAllergies().get(i).getId() == id) {
                if (User.getMedicineForAllergies().get(i).getQuantity() == rem) {
                    System.out.println("\n" + User.getMedicineForAllergies().get(i).getBrandName() + " has been removed.");
                    User.getMedicineForAllergies().remove(User.getMedicineForAllergies().get(i));
                    for (int x = 0; x < User.getMedicineForAllergies().size(); x++) {
                        User.getMedicineForAllergies().get(x).setId(x + 1);
                    }
                } else if (User.getMedicineForAllergies().get(i).getQuantity() > rem) {
                    User.getMedicineForAllergies().get(i).setQuantity(User.getMedicineForAllergies().get(i).getQuantity() - rem);
                    System.out.println(ANSI_CYAN+"\n" + User.getMedicineForAllergies().get(i).getBrandName() + " is deducted by " + rem + ANSI_RESET);
                } else {
                    System.err.println("You can only remove less amount of the quantity of medicine.");
                }
            }
        }
    }

    @Override
    public void displayAvailableMedicinesForCough() {
        System.out.println(ANSI_CYAN + "\n\t\t\t\t\t--- MEDICINES FOR COUGH ---" + ANSI_RESET);
        System.out.println("__________________________________________________________________________________________________________");
        System.out.printf(" %-1s \t| %-10s \t| %-10s \t| %-2s | %-2s \t\t| %10s \t| %3s", ANSI_YELLOW + "Id", "Brand Name", "Generic Name", "Price", "Type", "Expiration Date", "Quantity\n" + ANSI_RESET);
        System.out.println("__________________________________________________________________________________________________________");
        for (int i = 0; i < User.getMedicineForCough().size(); i++) {
            System.out.printf(" %-1d \t| %-10s \t| %-10s \t| %-2d \t| %-2s \t| %-10s \t| %3d\n", User.getMedicineForCough().get(i).getId(), User.getMedicineForCough().get(i).getBrandName(), User.getMedicineForCough().get(i).getGenericName(), User.getMedicineForCough().get(i).getPrice(), User.getMedicineForCough().get(i).getType(), User.getMedicineForCough().get(i).getExpirationDate(), User.getMedicineForCough().get(i).getQuantity());
            System.out.println("__________________________________________________________________________________________________________");
        }
    }

    @Override
    public void displayAvailableMedicinesForHeadache() {
        System.out.println(ANSI_CYAN + "\n\t\t\t\t\t--- MEDICINES FOR HEADACHE ---" + ANSI_RESET);
        System.out.println("__________________________________________________________________________________________________________");
        System.out.printf(" %-1s \t| %-10s \t| %-10s \t| %-2s | %-2s \t\t| %10s \t| %3s", ANSI_YELLOW + "Id", "Brand Name", "Generic Name", "Price", "Type", "Expiration Date", "Quantity\n" + ANSI_RESET);
        System.out.println("__________________________________________________________________________________________________________");
        for (int i = 0; i < User.getMedicineForHeadache().size(); i++) {
            System.out.printf(" %-1d \t| %-10s \t| %-10s \t| %-2d \t| %-2s \t| %-10s \t| %3d\n", User.getMedicineForHeadache().get(i).getId(), User.getMedicineForHeadache().get(i).getBrandName(), User.getMedicineForHeadache().get(i).getGenericName(), User.getMedicineForHeadache().get(i).getPrice(), User.getMedicineForHeadache().get(i).getType(), User.getMedicineForHeadache().get(i).getExpirationDate(), User.getMedicineForHeadache().get(i).getQuantity());
            System.out.println("__________________________________________________________________________________________________________");
        }
    }

    @Override
    public void displayAvailableMedicinesForBodyPain() {
        System.out.println(ANSI_CYAN + "\n\t\t\t\t\t--- MEDICINES FOR BODY PAIN ---" + ANSI_RESET);
        System.out.println("__________________________________________________________________________________________________________");
        System.out.printf(" %-1s \t| %-10s \t| %-10s \t| %-2s | %-2s \t\t| %10s \t| %3s", ANSI_YELLOW + "Id", "Brand Name", "Generic Name", "Price", "Type", "Expiration Date", "Quantity\n" + ANSI_RESET);
        System.out.println("__________________________________________________________________________________________________________");
        for (int i = 0; i < User.getMedicineForBodyPain().size(); i++) {
            System.out.printf(" %-1d \t| %-10s \t| %-10s \t| %-2d \t| %-2s \t| %-10s \t| %3d\n", User.getMedicineForBodyPain().get(i).getId(), User.getMedicineForBodyPain().get(i).getBrandName(), User.getMedicineForBodyPain().get(i).getGenericName(), User.getMedicineForBodyPain().get(i).getPrice(), User.getMedicineForBodyPain().get(i).getType(), User.getMedicineForBodyPain().get(i).getExpirationDate(), User.getMedicineForBodyPain().get(i).getQuantity());
            System.out.println("__________________________________________________________________________________________________________");
        }
    }

    @Override
    public void displayAvailableMedicinesForAllergies() {
        System.out.println(ANSI_CYAN + "\n\t\t\t\t\t--- MEDICINES FOR ALLERGIES ---" + ANSI_RESET);
        System.out.println("__________________________________________________________________________________________________________");
        System.out.printf(" %-1s \t| %-10s \t| %-10s \t| %-2s | %-2s \t\t| %10s \t| %3s", ANSI_YELLOW + "Id", "Brand Name", "Generic Name", "Price", "Type", "Expiration Date", "Quantity\n" + ANSI_RESET);
        System.out.println("__________________________________________________________________________________________________________");
        for (int i = 0; i < User.getMedicineForAllergies().size(); i++) {
            System.out.printf(" %-1d \t| %-10s \t| %-10s \t| %-2d \t| %-2s \t| %-10s \t| %3d\n", User.getMedicineForAllergies().get(i).getId(), User.getMedicineForAllergies().get(i).getBrandName(), User.getMedicineForAllergies().get(i).getGenericName(), User.getMedicineForAllergies().get(i).getPrice(), User.getMedicineForAllergies().get(i).getType(), User.getMedicineForAllergies().get(i).getExpirationDate(), User.getMedicineForAllergies().get(i).getQuantity());
            System.out.println("__________________________________________________________________________________________________________");
        }
    }

    @Override
    public void PharmacistMainTransaction(Account a) {
        while (true) {
            System.out.println("\n--- CHOOSE OPERATION ---");
            System.out.println("\n1. Add Medicine\n2. Remove Medicine\n3. Display Medicines\n4. Inventory\n5. View Customers\n6. Logout");
            System.out.print(ANSI_CYAN + "\nSelect Operation: " + ANSI_RESET);
            String operation = input.nextLine();
            switch (operation) {
                case "1": {
                    System.out.println("\nIn what list of medicine do you want to add medicine?");
                    System.out.println("\n1. Medicine For Cough\n2. Medicine For Headache\n3. Medicine For Body Pain\n4. Medicine For Allergies\n5. Back");
                    System.out.print(ANSI_CYAN + "\nSelect List: " + ANSI_RESET);
                    String select = input.nextLine();
                    switch (select) {
                        case "1": {
                            MedicineForCough mfc = new MedicineForCough(0);
                            System.out.print("\nBrand Name: ");
                            String brandname = input.nextLine();
                            mfc.setBrandName(brandname);
                            System.out.print("Generic Name: ");
                            String genericname = input.nextLine();
                            mfc.setGenericName(genericname);
                            System.out.print("Type(Capsule/Tablet/Syrup): ");
                            String type = input.nextLine();
                            mfc.setType(type);
                            System.out.print("Price: ");
                            String price = input.nextLine();
                            mfc.setPrice(Integer.valueOf(price));
                            System.out.print("Expiration Date: ");
                            String exp = input.nextLine();
                            mfc.setExpirationDate(exp);
                            System.out.print("Quantity: ");
                            int qty = int_input.nextInt();
                            mfc.setQuantity(qty);
                            this.addMedicineForCough(mfc);
                            break;
                        }
                        case "2": {
                            MedicineForHeadache mfh = new MedicineForHeadache(0);
                            System.out.print("\nBrand Name: ");
                            String brandname = input.nextLine();
                            mfh.setBrandName(brandname);
                            System.out.print("Generic Name: ");
                            String genericname = input.nextLine();
                            mfh.setGenericName(genericname);
                            System.out.print("Type(Capsule/Tablet/Syrup): ");
                            String type = input.nextLine();
                            mfh.setType(type);
                            System.out.print("Price: ");
                            String price = input.nextLine();
                            mfh.setPrice(Integer.valueOf(price));
                            System.out.print("Expiration Date: ");
                            String exp = input.nextLine();
                            mfh.setExpirationDate(exp);
                            System.out.print("Quantity: ");
                            int qty = int_input.nextInt();
                            mfh.setQuantity(qty);
                            this.addMedicineForHeadache(mfh);
                            break;
                        }
                        case "3": {
                            MedicineForBodyPain mfb = new MedicineForBodyPain(0);
                            System.out.print("\nBrand Name: ");
                            String brandname = input.nextLine();
                            mfb.setBrandName(brandname);
                            System.out.print("Generic Name: ");
                            String genericname = input.nextLine();
                            mfb.setGenericName(genericname);
                            System.out.print("Type(Capsule/Tablet/Syrup): ");
                            String type = input.nextLine();
                            mfb.setType(type);
                            System.out.print("Price: ");
                            String price = input.nextLine();
                            mfb.setPrice(Integer.valueOf(price));
                            System.out.print("Expiration Date: ");
                            String exp = input.nextLine();
                            mfb.setExpirationDate(exp);
                            System.out.print("Quantity: ");
                            int qty = int_input.nextInt();
                            mfb.setQuantity(qty);
                            this.addMedicineForBodyPain(mfb);
                            break;
                        }
                        case "4": {
                            MedicineForAllergies mfa = new MedicineForAllergies(0);
                            System.out.print("\nBrand Name: ");
                            String brandname = input.nextLine();
                            mfa.setBrandName(brandname);
                            System.out.print("Generic Name: ");
                            String genericname = input.nextLine();
                            mfa.setGenericName(genericname);
                            System.out.print("Type(Capsule/Tablet/Syrup): ");
                            String type = input.nextLine();
                            mfa.setType(type);
                            System.out.print("Price: ");
                            String price = input.nextLine();
                            mfa.setPrice(Integer.valueOf(price));
                            System.out.print("Expiration Date: ");
                            String exp = input.nextLine();
                            mfa.setExpirationDate(exp);
                            System.out.print("Quantity: ");
                            int qty = int_input.nextInt();
                            mfa.setQuantity(qty);
                            this.addMedicineForAllergies(mfa);
                            break;
                        }
                        case "5": {
                            this.PharmacistMainTransaction(a);
                        }
                        default:
                            break;
                    }
                    break;
                }
                case "2": {
                    System.out.println("\nIn what list of medicine do you want to remove medicine?");
                    System.out.println("\n1. Medicine For Cough\n2. Medicine For Headache\n3. Medicine For Body Pain\n4. Medicine For Allergies\n5. Back");
                    System.out.print(ANSI_CYAN + "\nSelect List: " + ANSI_RESET);
                    String select = input.nextLine();
                    switch (select) {
                        case "1": {
                            this.displayAvailableMedicinesForCough();
                            System.out.print("\nEnter the id of the medicine you want to remove: ");
                            int med_id = int_input.nextInt();
                            for (int i = 0; i < User.getMedicineForCough().size(); i++) {
                                if (User.getMedicineForCough().get(i).getId() == med_id) {
                                    this.removeMedicineForCough(User.getMedicineForCough().get(i), med_id);
                                }
                            }
                            break;
                        }
                        case "2": {
                            this.displayAvailableMedicinesForHeadache();
                            System.out.print("\nEnter the id of the medicine you want to remove: ");
                            int med_id = int_input.nextInt();
                            for (int i = 0; i < User.getMedicineForHeadache().size(); i++) {
                                if (User.getMedicineForHeadache().get(i).getId() == med_id) {
                                    this.removeMedicineForHeadache(User.getMedicineForHeadache().get(i), med_id);
                                }
                            }
                            break;
                        }
                        case "3": {
                            this.displayAvailableMedicinesForBodyPain();
                            System.out.print("\nEnter the id of the medicine you want to remove: ");
                            int med_id = int_input.nextInt();
                            for (int i = 0; i < User.getMedicineForBodyPain().size(); i++) {
                                if (User.getMedicineForBodyPain().get(i).getId() == med_id) {
                                    this.removeMedicineForBodyPain(User.getMedicineForBodyPain().get(i), med_id);
                                }
                            }
                            break;
                        }
                        case "4": {
                            this.displayAvailableMedicinesForAllergies();
                            System.out.print("\nEnter the id of the medicine you want to remove: ");
                            int med_id = int_input.nextInt();
                            for (int i = 0; i < User.getMedicineForAllergies().size(); i++) {
                                if (User.getMedicineForAllergies().get(i).getId() == med_id) {
                                    this.removeMedicineForAllergies(User.getMedicineForAllergies().get(i), med_id);
                                }
                            }
                            break;
                        }
                        case "5": {
                            this.PharmacistMainTransaction(a);
                        }
                        default:
                            break;
                    }
                    break;
                }
                case "3":
                    System.out.println("\nWhat list of medicine you want to display?");
                    System.out.println("\n1. Medicine For Cough\n2. Medicine For Headache\n3. Medicine For Body Pain\n4. Medicine For Allergies\n5. Back");
                    System.out.print(ANSI_CYAN + "\nSelect List: " + ANSI_RESET);
                    String dis = input.nextLine();
                    switch (dis) {
                        case "1":
                            this.displayAvailableMedicinesForCough();
                            break;
                        case "2":
                            this.displayAvailableMedicinesForHeadache();
                            break;
                        case "3":
                            this.displayAvailableMedicinesForBodyPain();
                            break;
                        case "4":
                            this.displayAvailableMedicinesForAllergies();
                            break;
                        case "5":
                            this.PharmacistMainTransaction(a);
                            break;
                        default:
                            break;
                    }
                    break;
                case "4":
                    System.out.println("\nWhat list of medicine you want to display the inventory?");
                    System.out.println("\n1. Medicine For Cough\n2. Medicine For Headache\n3. Medicine For Body Pain\n4. Medicine For Allergies\n5. Back");
                    System.out.print(ANSI_CYAN + "\nSelect List: " + ANSI_RESET);
                    String inv = input.nextLine();
                    switch (inv) {
                        case "1":
                            this.inventoryMedicineForCough();
                            break;
                        case "2":
                            this.inventoryMedicineForHeadache();
                            break;
                        case "3":
                            this.inventoryMedicineForBodyPain();
                            break;
                        case "4":
                            this.inventoryMedicineForAllergies();
                            break;
                        case "5":
                            this.PharmacistMainTransaction(a);
                            break;
                        default:
                            break;
                    }
                    break;

                case "5":
                    this.viewCustomers();
                    break;
                case "6":
                    System.out.print(ANSI_CYAN + "\nAre you sure to Logout? " + ANSI_WHITE + "yes/no : " + ANSI_RESET);
                    String logout = input.nextLine();
                    switch (logout) {
                        case "yes":
                            this.Logout(a);
                            break;
                        case "no":
                            this.PharmacistMainTransaction(a);
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void Login(Account a) {
        System.out.println("\n--- LOGIN ---\nYou have 3 trials to Login");
        int trial = 0;
        while (trial != 3) {
            System.out.print(ANSI_YELLOW + "\nEnter Username: " + ANSI_RESET);
            String username = input.nextLine();
            System.out.print(ANSI_YELLOW + "Enter Password: " + ANSI_RESET);
            String password = input.nextLine();
            for (Account registeredPharmacist : User.getRegisteredPharmacists()) {
                if (registeredPharmacist.getUserName().equals(username) && registeredPharmacist.getPassWord().equals(password)) {
                    System.out.println("\n" + a.getUserName() + " You are now logged in.\n");
                    System.out.println("You can now do the transaction.");
                    this.PharmacistMainTransaction(a);
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
    public void Logout(Account a) {
        super.Logout(a);

    }

    @Override
    public void Register(Account a) {

    }

    @Override
    public void viewCustomers() {
        System.out.println("\n\t\t--- CUSTOMERS ---");
        System.out.println("_____________________________________________________");
        System.out.printf("%-10s \t| %-8s \t| %-6s \t| %-1s ", "First name", "Last name", "Address", "Age\n");
        System.out.println("_____________________________________________________");
        for (int i = 0; i < User.getRegisteredCustomers().size(); i++) {
            System.out.printf("%-10s \t| %-8s \t| %-6s \t| %-1d\n", User.getRegisteredCustomers().get(i).getFname(), User.getRegisteredCustomers().get(i).getLname(), User.getRegisteredCustomers().get(i).getAddress(), getRegisteredCustomers().get(i).getAge());
            System.out.println("_____________________________________________________");
        }
    }

}

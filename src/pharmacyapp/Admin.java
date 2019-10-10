/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;

/**
 *
 * @author 2ndyrGroupB
 */
public class Admin extends User{
    
    public Admin() {
        
    }
    
    public void removeCustomer(){
        System.out.println("Enter the username of the ");
    }
    
    public void displayAccountsOfCustomers() {
        System.out.println("\n\t\t--- REGISTERED CUSTOMERS ---");
        System.out.println("____________________________________________________________________________________________________________________");
        System.out.printf("  %-10s  | %-10s   |   %-10s   |   %-10s   |  %-10s   |  %10s ", "First name", "Last name", "Username", "Password", "Address", "Age\n");
        System.out.println("____________________________________________________________________________________________________________________");
        for (int i = 0; i < Admin.getRegisteredCustomers().size(); i++) {
            System.out.printf(" %-10s  |  %-10s  |  %-10s  |  %-10s   |  %-10s  | %10d\n", Admin.getRegisteredCustomers().get(i).getFname(),Admin.getRegisteredCustomers().get(i).getLname(), Admin.getRegisteredCustomers().get(i).getUserName(), Admin.getRegisteredCustomers().get(i).getPassWord(), Admin.getRegisteredCustomers().get(i).getAddress(), Admin.getRegisteredCustomers().get(i).getAge());
            System.out.println("____________________________________________________________________________________________________________________");
        }
    }

    public void displayAccountsOfPharmacist() {
        System.out.println("\n\t\t--- REGISTERED Pharmacist ---");
        System.out.println("____________________________________________________________________________________________________________________");
        System.out.printf("  %-10s  | %-10s   |   %-10s   |   %-10s   |  %-10s   |  %-10s   |  %10s ", "First name", "Last name", "Username", "Password", "Licensed No", "Address", "Age\n");
        System.out.println("____________________________________________________________________________________________________________________");
        for (int i = 0; i < Admin.getRegisteredPharmacists().size(); i++) {
            System.out.printf(" %-10s  |  %-10s  |  %-10s  |  %-10s   |  %-10d   |  %-10s  | %10d\n", Admin.getRegisteredPharmacists().get(i).getFname(), Admin.getRegisteredPharmacists().get(i).getLname(), Admin.getRegisteredPharmacists().get(i).getUserName(), Admin.getRegisteredPharmacists().get(i).getPassWord(), Admin.getRegisteredPharmacists().get(i).getPharLicensedNo(), Admin.getRegisteredPharmacists().get(i).getAddress(), Admin.getRegisteredPharmacists().get(i).getAge());
            System.out.println("____________________________________________________________________________________________________________________");
        }
    }
}

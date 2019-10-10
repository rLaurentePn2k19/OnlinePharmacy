/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;

import java.util.HashMap;



/**
 *
 * @author 2ndyrGroupB
 */
public abstract class Customer extends User implements CustomerOperation {
    
    private int ecoin;
    private HashMap<String,Integer> purchased_med = new HashMap<>();

    public Customer() {
        
    }

    public Customer(int ecoin) {
        this.ecoin = ecoin;
    }

    public HashMap<String, Integer> getPurchased_med() {
        return purchased_med;
    }

    public void setPurchased_med(HashMap<String, Integer> purchased_med) {
        this.purchased_med = purchased_med;
    }

    public int getEcoin() {
        return ecoin;
    }

    public void setEcoin(int ecoin) {
        this.ecoin = ecoin;
    }

  
}

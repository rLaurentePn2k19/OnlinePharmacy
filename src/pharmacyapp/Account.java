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
public class Account {


    private String fname;
    private String lname;
    private String userName;
    private String passWord;
    private String address;
    private int pharLicensedNo;
    private int age;

    public Account() {
    }

    public Account(String fname, String lname, String userName, String passWord, String address, int age) {
        this.fname = fname;
        this.lname = lname;
        this.userName = userName;
        this.passWord = passWord;
        this.address = address;
        this.age = age;
    }

    public Account(String fname, String lname, String userName, String passWord, int pharLicensedNo, String address, int age) {
        this.fname = fname;
        this.lname = lname;
        this.userName = userName;
        this.passWord = passWord;
        this.pharLicensedNo = pharLicensedNo;
        this.address = address;
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPharLicensedNo() {
        return pharLicensedNo;
    }

    public void setPharLicensedNo(int pharLicensedNo) {
        this.pharLicensedNo = pharLicensedNo;
    }
    
    public void myAccountP(){
        System.out.printf("\t> First name: %s\n\t> Last name: %s\n\t> Address: %s\n\t> Username: %s\n\t> Password: %s\n\t> Age: %d\n\t> Licensed No: %d",fname,lname,address,userName,passWord,age,pharLicensedNo);
    }
    
    public void myAccountC(){
        System.out.printf("\t> First name: %s\n\t> Last name: %s\n\t> Address: %s\n\t> Username: %s\n\t> Password: %s\n\t> Age: %d",fname,lname,address,userName,passWord,age);
    }
    
}

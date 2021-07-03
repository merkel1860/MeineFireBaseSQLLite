package com.example.meinefirebasesqllite.model;

import com.example.meinefirebasesqllite.model.Address;

import java.io.Serializable;
import java.util.Locale;

public class User implements Serializable {
    private String fname;
    private String laname;
    private int yob;
    private Address myAddress;
    private Login login;

    public User() {
        login = new Login();
        myAddress = new Address();
        fname = "";
        laname = "";
    }

    public User(String username, String pass) {
        this.login = new Login(username, pass);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLaname() {
        return laname;
    }

    public void setLaname(String laname) {
        this.laname = laname;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public Address getMyAddress() {
        return myAddress;
    }

    public void setMyAddress(Address myAddress) {
        this.myAddress = myAddress;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String makeFullname(){
        return fname+" "+laname;
    }
}

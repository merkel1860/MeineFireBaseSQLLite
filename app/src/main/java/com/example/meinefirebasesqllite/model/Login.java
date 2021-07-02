package com.example.meinefirebasesqllite.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
    private String username;
    private String password;

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = encodingPass(password);
    }

    private String encodingPass(String pass){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        BigInteger bi = new BigInteger(digest);
        String hashtext = bi.toString(16);

        return hashtext;
    }

    private boolean checkPass(String pass){
        return 0 == password.compareToIgnoreCase(encodingPass(pass));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = encodingPass(password);
    }
}

package com.twu.biblioteca;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String username, String password, String name, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return this.name + " | " + this.email + " | " + this.phoneNumber;
    }
}


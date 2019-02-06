package com.twu.biblioteca;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Item> items;
    private List<User> users;
    private User loggedUser;

    public Biblioteca() {
        this.items = new ArrayList<Item>();
        this.users = new ArrayList<User>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<? extends Item> getItems() {
        return items;
    }

    public List<? extends Item> availableItems() {
        return this.findAll("", true, null);
    }

    public List<? extends Item> unAvailableItems() {
        return this.findAll("", false, null);
    }

    public List<? extends Item> findAll(String query, boolean available, Class<? extends Item> type) {
        return this.items.stream()
                         .filter(item -> type == null || type.isInstance(item))
                         .filter(item -> item.isAvailable() == available)
                         .filter(item -> item.getTitle().toLowerCase().contains(query))
                         .collect(Collectors.toList());
    }

    public List<? extends Item> findUserBooks(Class<? extends Item> type) {
        return this.items.stream()
                         .filter(item -> type == null || type.isInstance(item))
                         .filter(item -> item.getBorrower() == this.loggedUser)
                         .collect(Collectors.toList());
    }

    public boolean isLoggedIn() {
        return this.loggedUser != null ? true : false;
    }

    public User getCurrentUser() {
        return this.loggedUser;
    }

    public void logout() {
        this.loggedUser = null;
    }

    public boolean login(String username, String password) {
        User match =  this.users.stream()
            .filter(user -> user.getUsername().equals(username) && user.getPasswordHash().equals(password))             
            .findFirst()
            .orElse(null);

        if (match != null) {
            this.loggedUser = match;
            return true;
        } else {
            return false;
        }
    }
}


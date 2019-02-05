package com.twu.biblioteca;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Item> items;

    public Biblioteca() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<? extends Item> getItems() {
        return items;
    }

    public List<? extends Item> availableItems() {
        return this.findAll("", false, null);
    }

    public List<? extends Item> unAvailableItems() {
        return this.findAll("", true, null);
    }

    public List<? extends Item> findAll(String query, boolean borrowed, Class<? extends Item> type) {
        return this.items.stream()
                         .filter(item -> type == null || type.isInstance(item))
                         .filter(item -> item.getBorrowed() == borrowed)
                         .filter(item -> item.getTitle().toLowerCase().contains(query))
                         .collect(Collectors.toList());
    }
}


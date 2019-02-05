package com.twu.biblioteca;

import java.util.List;

public class Item {
    String title;
    String year;
    Boolean borrowed;

    public Item(String title, String year, Boolean borrowed) {
        this.title = title;
        this.year = year;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public void checkoutItem() {
        this.borrowed = true;
    }

    public void returnItem() {
        this.borrowed = false;
    }

    public static String formatItems(List<? extends Item> items) {
        return items.stream()
                    .map(Item::toString)
                    .reduce("", (String a, String b) -> String.format(a + "%n" + b));
    }
}

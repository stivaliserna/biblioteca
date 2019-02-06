package com.twu.biblioteca;

import java.util.List;

public class Item {
    String title;
    String year;
    User borrower;

    public Item(String title, String year, User user) {
        this.title = title;
        this.year = year;
        this.borrower = user;
    }

    public User getBorrower() {
        return borrower;
    }

    public String getTitle() {
        return title;
    }

    public Boolean isAvailable() {
        return this.borrower == null;
    }

    public void checkoutItem(User user) {
        this.borrower = user;
    }

    public void returnItem() {
        this.borrower = null;
    }

    public static String formatItems(List<? extends Item> items) {
        return items.stream()
                    .map(Item::toString)
                    .reduce("", (String a, String b) -> String.format(a + "%n" + b));
    }
}

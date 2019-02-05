package com.twu.biblioteca;

import java.util.List;

public class ShowItems {
    public static void execute(Biblioteca library, Class<? extends Item> type) {
        List<? extends Item> kek = library.findAll("", false, type);
        System.out.println(Item.formatItems(kek));
        System.out.println();
    }
}

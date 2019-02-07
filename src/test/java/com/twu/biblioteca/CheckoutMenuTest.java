package com.twu.biblioteca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.util.Scanner;

public class CheckoutMenuTest {
    // Output and Input streams to be used to mock the environment for the tests.
    private OutputStream outBytes;

    // Store references to the original System.in and System.out to restore them after the tests.
    private final PrintStream sysOut = System.out;

    private final String ENTER = System.getProperty("line.separator");

    private String[] getOutputLines() {
        return outBytes.toString().split(ENTER);
    }

    @BeforeEach public void beforeEach() {
        outBytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBytes));
    }

    @AfterEach public void afterEach() {
        System.setOut(sysOut);
    }

    @Test public void shouldBeLoggedInToCheckoutAnItem() {
        String input = "";
        Biblioteca library = new Biblioteca();
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        CheckoutMenu.execute(library, scanner, Book.class);

        String[] lines = getOutputLines();
        
        String expected = "You must be logged to checkout an item.";
        
        assertEquals(expected, lines[1]);
    }

    @Test public void shouldCheckoutAnItemIfIsLoggedIn() {
        String input = "asy" + ENTER;

        Book book = new Book("Lisa Halliday", "Asymmetry", "2018", null);
        User user = new User("333-1234", "huehuehue", null, null, null);
        Biblioteca library = new Biblioteca();
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        library.addItem(book);
        library.addUser(user);

        library.login(user.getUsername(), user.getPasswordHash());

        CheckoutMenu.execute(library, scanner, Book.class);

        String[] lines = getOutputLines();
        
        String expected = "Thank you! Enjoy the item.";
        
        assertEquals(expected, lines[lines.length - 3]);
    }

    @Test public void shouldReturnUnsuccessfulMessage() {
        String input = "kek" + ENTER;

        Book book = new Book("Lisa Halliday", "Asymmetry", "2018", null);
        User user = new User("333-1234", "huehuehue", null, null, null);
        Biblioteca library = new Biblioteca();
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        library.addItem(book);
        library.addUser(user);

        library.login(user.getUsername(), user.getPasswordHash());

        CheckoutMenu.execute(library, scanner, Book.class);

        String[] lines = getOutputLines();
        
        String expected = "Sorry, that item is not available!";
        
        assertEquals(expected, lines[3]);
    }
}

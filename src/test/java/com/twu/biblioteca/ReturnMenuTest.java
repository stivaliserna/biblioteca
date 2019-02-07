package com.twu.biblioteca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.util.Scanner;

public class ReturnMenuTest {
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

    @Test public void shouldBeLoggedInToReturnABook() {
        String input = "3";
        Biblioteca library = new Biblioteca();
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        ReturnMenu.execute(library, scanner, Book.class);

        String[] lines = getOutputLines();
        
        String expected = "You must be logged to return a book.";
        
        assertEquals(expected, lines[1]);
    }

    @Test public void shouldReturnABookIfIsLoggedIn() {
        String input = "asy" + ENTER;

        User user = new User("333-1234", "huehuehue", null, null, null);
        Book book = new Book("Lisa Halliday", "Asymmetry", "2018", user);
        Biblioteca library = new Biblioteca();
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        library.addItem(book);
        library.addUser(user);

        library.login(user.getUsername(), user.getPasswordHash());

        ReturnMenu.execute(library, scanner, Book.class);

        String[] lines = getOutputLines();
        
        String expected = "Thank you for returning the book!";
        
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

        ReturnMenu.execute(library, scanner, Book.class);

        String[] lines = getOutputLines();
        
        String expected = "That is not a valid book to return.";
        
        assertEquals(expected, lines[lines.length - 3]);
    }
}

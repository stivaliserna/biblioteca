package com.twu.biblioteca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.util.Scanner;

public class AccountMenuTest {
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

    @Test public void shouldListCheckedOutBooks() {
        Biblioteca library = new Biblioteca();

        User user = new User("333-1234", "huehuehue", "Ana", "ana@kek.com", "5555555");
        Book book = new Book("Lisa Halliday", "Asymmetry", "2018", user);

        library.addItem(book);
        library.addUser(user);

        library.login(user.getUsername(), user.getPasswordHash());

        AccountMenu.showCheckedOutBooks(library, Book.class);

        String[] lines = getOutputLines();
        
        String expected = "Asymmetry | Lisa Halliday | 2018";
        
        assertEquals(expected, lines[1]);
    }

    @Test public void shouldListUserInfo() {
        Biblioteca library = new Biblioteca();
        Scanner scanner = new Scanner(new ByteArrayInputStream("2".getBytes()));

        User user = new User("333-1234", "huehuehue", "Ana", "ana@kek.com", "5555555");

        library.addUser(user);

        library.login(user.getUsername(), user.getPasswordHash());

        AccountMenu.execute(library, scanner);

        String[] lines = getOutputLines();
        
        String expected = "Ana | ana@kek.com | 5555555";
        
        assertEquals(expected, lines[lines.length - 8]);
    }

    @Test public void shouldLogout() {
        Biblioteca library = new Biblioteca();
        Scanner scanner = new Scanner(new ByteArrayInputStream("3".getBytes()));

        User user = new User("333-1234", "huehuehue", "Ana", "ana@kek.com", "5555555");
        library.addUser(user);

        library.login(user.getUsername(), user.getPasswordHash());

        AccountMenu.execute(library, scanner);
        
        assertEquals(false, library.isLoggedIn());
    }
}

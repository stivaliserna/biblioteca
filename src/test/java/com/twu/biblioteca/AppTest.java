package com.twu.biblioteca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;

public class AppTest {
    // Output and Input streams to be used to mock the environment for the tests.
    private OutputStream outBytes;
    private InputStream inBytes;

    // Store references to the original System.in and System.out to restore them after the tests.
    private final InputStream sysIn = System.in;
    private final PrintStream sysOut = System.out;

    private final String ENTER = System.getProperty("line.separator");

    private void setInput(String input) {
        inBytes = new ByteArrayInputStream(input.getBytes());
        System.setIn(inBytes);
    }

    private String[] getOutputLines() {
        return outBytes.toString().split(ENTER);
    }

    @BeforeEach public void beforeEach() {
        outBytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBytes));
    }

    @AfterEach public void afterEach() {
        System.setIn(sysIn);
        System.setOut(sysOut);
    }

    @Test public void testWelcomeMessage() {
        setInput("");

        App.main(new String[0]);

        String[] lines = getOutputLines();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore.", lines[0]);
    }

    @Test public void testBookList() {
        Biblioteca library = new Biblioteca();
        library.addItem(new Book("Lisa Halliday", "Asymmetry", "2018", null));

        MainMenu.showItems(library, Book.class);

        String[] lines = getOutputLines();

        assertEquals("Asymmetry | Lisa Halliday | 2018", lines[1]);
    }

    @Test public void testInvalidOption() {
        setInput("9");

        App.main(new String[0]);

        String[] lines = getOutputLines();

        assertEquals("Wrong option! Please select a valid one.", lines[lines.length - 19]);
    }

    @Test public void testQuitOption() {
        setInput("7");

        App.main(new String[0]);

        String[] lines = getOutputLines();

        assertEquals("Bye!", lines[lines.length - 1]);
    }

    @Test public void testMovieList() {
        setInput("4");

        App.main(new String[0]);

        String[] lines = getOutputLines();

        assertEquals("The Silence of the Lambs | Jonathan Demme | 1991 | 10", lines[lines.length - 20]);
        assertEquals("Roma | Alfonso Cuarón | 2018 | 9", lines[lines.length - 19]);
    }
}

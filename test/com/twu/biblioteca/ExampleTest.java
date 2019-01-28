package com.twu.biblioteca;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;

public class ExampleTest {
    private static final String EOL = System.getProperty("line.separator");

    @Test
    public void testWelcomeMessage() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream console = System.out;
        try {
           System.setOut(new PrintStream(bytes));
           BibliotecaApp.main();
        } finally {
           System.setOut(console);
        }
        assertEquals(String.format(
              "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore%n"),
              bytes.toString());
     }
}

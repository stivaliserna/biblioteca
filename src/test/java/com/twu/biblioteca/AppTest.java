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
         assertEquals("Select an option:", lines[2]);
         assertEquals("  1) List all books", lines[3]);
         assertEquals("  2) Checkout a book", lines[4]);
         assertEquals("  3) Return a book", lines[5]);
         assertEquals("  4) Quit", lines[6]);
    }

    @Test public void testBookList() {
         setInput("1");

         App.main(new String[0]);

         String[] lines = getOutputLines();

         assertEquals("Asymmetry | Lisa Halliday | 2018", lines[lines.length - 8]);
         assertEquals("The Great Believers | Rebecca Makkai | 2018", lines[lines.length - 7]);
    }

    @Test public void testInvalidOption() {
      setInput("9");

      App.main(new String[0]);

      String[] lines = getOutputLines();

      assertEquals("Wrong option! Please select a valid one.", lines[lines.length - 6]);
    }

    @Test public void testQuitOption() {
      setInput("4");

      App.main(new String[0]);

      String[] lines = getOutputLines();

      assertEquals("Bye!", lines[lines.length - 1]);
    }

    @Test public void testCheckoutMenu() {
      setInput(
         "2" +
         ENTER +
         "asy" +
         ENTER +
         "Y"
      );

      App.main(new String[0]);

      String[] lines = getOutputLines();

      assertEquals("  4) Quit", lines[lines.length - 1]);
    }

    @Test public void testCheckoutSuccessMessage() {
      setInput(
         "2" +
         ENTER +
         "asy"
      );

      App.main(new String[0]);

      String[] lines = getOutputLines();

      assertEquals("Thank you! Enjoy the book.", lines[lines.length - 3]);
    }

    @Test public void testCheckoutUnsuccessfulMessage() {
      setInput(
         "2" +
         ENTER +
         "asy" +
         ENTER +
         "Y" +
         ENTER +
         "2" +
         ENTER +
         "asy"
      );

      App.main(new String[0]);

      String[] lines = getOutputLines();

      assertEquals("Sorry, that book is not available!", lines[lines.length - 2]);
    }

    @Test public void testReturnMenu() {
      setInput(
         "2" +
         ENTER +
         "asy" +
         ENTER +
         "Y"
      );

      App.main(new String[0]);

      String[] lines = getOutputLines();

      assertEquals("  4) Quit", lines[lines.length - 1]);
    }

    @Test public void testReturnSuccessMessage() {
      setInput(
         "3" +
         ENTER +
         "asy"
      );

      App.main(new String[0]);

      String[] lines = getOutputLines();

      assertEquals("Thank you for returning the book!", lines[lines.length - 3]);
    }
}

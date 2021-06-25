package com.josh.massey.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

  private Contact c;

  @BeforeEach
  void setup() {
    c = new Contact("1", "first", "last", "1234567890", "1212 Somewhere St");
  }

  @Test
  void createTest() {
    assertAll(
        () -> assertEquals("first", c.getFirstName()),
        () -> assertEquals("last", c.getLastName()),
        () -> assertEquals("1234567890", c.getPhone()),
        () -> assertEquals("1212 Somewhere St", c.getAddress())
    );
  }

  @Test
  void updateTest() {
    assertAll(
        () -> assertTrue(c.setAddress("121211")),
        // address breaks validation
        () -> assertFalse(c.setAddress("pawiyr gp;iqgueboiuhgsadoifb a[orusghfa piurpiqogrf[ gquerfgqr gvuqrvg; be")),
        () -> assertTrue(c.setFirstName("Joe")),
        () -> assertTrue(c.setLastName("Schmo")),
        // name breaks validation
        () -> assertFalse(c.setLastName("piuwqhgrgpivhqrpgv9pu rp9gr9gvw uvguw vhb")),
        // name breaks validation
        () -> assertFalse(c.setFirstName("piuwqhgrgpivhqrpgv9pu rp9gr9gvw uvguw vhb")),
        () -> assertTrue(c.setPhone("2222222222")),
        // phone number breaks validation
        () -> assertFalse(c.setPhone("13681354348401543450435464068"))
    );
  }

}

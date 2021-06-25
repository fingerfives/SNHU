package com.josh.massey.service;

import static org.junit.jupiter.api.Assertions.assertAll;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

  private ContactService service;

  @BeforeEach
  void setup() {
    service = new ContactService();
  }

  @Test
  void addTest() {
    assertAll(
        () -> assertTrue(service.addContact("1", "Jolene", "Joestar", "5255998708", "Kent, GB")),
        () -> assertTrue(service.addContact("2", "Nancy", "Drew", "5255998708", "Kent, GB")),
        () -> assertTrue(service.addContact("3", "Joe", "Hardy", "5255998708", "Kent, GB")),
        // address too long
        () -> assertFalse(service.addContact("4", "Isabelle", "Islander", "5641023489",
            "Super Duper Funtime Fishtank, 4242 Wallaby Way, Sydney, AU, Earth, Milky Way")),
        // id already exists
        () -> assertFalse(service.addContact("1", "Chief", "Azoroth", "12345688888", "Nowhere, NM")),
        // first name too long
        () -> assertFalse(service.addContact("5", "Juxtapositioning", "Q", "1094829584", "Somewhere, AZ")),
        // last name too long
        () -> assertFalse(service.addContact("5", "Dean", "Snufflepantso", "12122", "AAA")),
        // invalid phone number
        () -> assertFalse(service.addContact("5", "TK", "Momo", "111", "Princetown"))
    );
  }

  @Test
  void updateTest() {
    assertAll(
        () -> assertTrue(service.addContact("1", "Dante", "Inferno", "1234567890", "Unknown")),
        () -> assertTrue(service.updateContact("1", "firstName", "Virgil")),
        () -> assertTrue(service.updateContact("1", "lastName", "Demonslay")),
        () -> assertTrue(service.updateContact("1", "phone", "6666666666")),
        () -> assertTrue(service.updateContact("1", "address", "still unknown"))
    );
  }

  @Test
  void deleteTest() {
    assertAll(
        () -> assertTrue(service.addContact("1", "Jeff", "Parsavella", "4184635010", "Somewhere, WA")),
        // id already exists, does not add
        () -> assertFalse(service.addContact("1", "Jeff", "Parsavella", "4184635010", "Somewhere, WA")),
        // removes contact
        () -> assertTrue(service.deleteContact("1")),
        // re-adds contact
        () -> assertTrue(service.addContact("1", "Jeff", "Parsavella", "4184635010", "Somewhere, WA"))
    );
  }
}


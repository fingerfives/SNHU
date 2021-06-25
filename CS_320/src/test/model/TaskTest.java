package com.josh.massey.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TaskTest {

  @Test
  void createTest() {
    Task t = new Task("1", "this is a sample task", "example");
    assertAll(
        () -> assertEquals("1", t.getId()),
        () -> assertEquals("example", t.getName()),
        () -> assertEquals("this is a sample task", t.getDescription())
    );
  }

  @Test
  void updateTest() {
    StringBuffer tooLongName = new StringBuffer();
    StringBuffer tooLongDescrip = new StringBuffer();
    for (int i = 0; i < 60; i++) {
      tooLongDescrip.append('a');
      tooLongName.append('z');
    }
    Task t = new Task("1", "example", "this is a sample task");
    assertAll(
        () -> assertTrue(t.setName("new name")),
        () -> assertTrue(t.setDescription("new description")),
        () -> assertFalse(t.setDescription(tooLongDescrip.toString())),
        () -> assertFalse(t.setName(tooLongName.toString()))
    );
  }

}

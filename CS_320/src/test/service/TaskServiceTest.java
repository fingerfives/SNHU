package com.josh.massey.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

  private TaskService service;
  private StringBuilder tooLongDescription;
  private StringBuilder tooLongName;

  @BeforeEach
  void setup() {
    service = new TaskService();
    tooLongDescription = new StringBuilder();
    tooLongName = new StringBuilder();
    for (int i = 0; i < 60; i++) {
      tooLongDescription.append("a");
      tooLongName.append("z");
    }
  }

  @Test
  void addTest() {
    assertAll(
        () -> assertTrue(service.addTask("123456789", "name", "desc")),
        () -> assertTrue(service.addTask("987654321", "another", "desc")),
        // id is null
        () -> assertFalse(service.addTask(null, "too", "yyyy")),
        // name is null
        () -> assertFalse(service.addTask("px4j@rh", null, "kutib")),
        // description is null
        () -> assertFalse(service.addTask("id", "name", null)),
        // name and description break validation
        () -> assertFalse(service.addTask("id", tooLongName.toString(), tooLongDescription.toString())),
        // name breaks validation
        () -> assertFalse(service.addTask("id", tooLongName.toString(), "desc")),
        // id already exists
        () -> assertFalse(service.addTask("123456789", "instan", "tttt")),
        // description breaks validation
        () -> assertFalse(service.addTask("18fnb3", "sfwe", tooLongDescription.toString()))
    );
  }

  @Test
  void updateTest() {
    service.addTask("12345678", "name", "desc");
    service.addTask("98765432", "another", "desc");
    assertAll(
        () -> assertTrue(service.updateTask("98765432", "name", "new name")),
        // name breaks validation
        () -> assertFalse(service.updateTask("98765432", "name", tooLongName.toString())),
        // name is null
        () -> assertFalse(service.updateTask("98765432", "name", null)),
        // id is null
        () -> assertFalse(service.updateTask(null, "name", "new name")),
        // id doesn't exist
        () -> assertFalse(service.updateTask("p9n7b6c5s", "name", "llll")),
        () -> assertTrue(service.updateTask("12345678", "description", "new desc")),
        // description is null
        () -> assertFalse(service.updateTask("12345678", "description", null)),
        // description breaks validation
        () -> assertFalse(service.updateTask("12345678", "description", tooLongDescription.toString())),
        // id doesn't exist
        () -> assertFalse(service.updateTask("01@*ntCBkgiy", "description", "jjjj"))
    );
  }

  @Test
  void deleteTest() {
    service.addTask("12345678", "name", "desc");
    service.addTask("98765432", "another", "desc");
    assertAll(
        () -> assertTrue(service.deleteTask("12345678")),
        // id doesn't exist
        () -> assertFalse(service.deleteTask("1Sowi@@j")),
        () -> assertTrue(service.deleteTask("98765432"))
    );
  }

}

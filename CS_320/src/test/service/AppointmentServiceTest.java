package com.josh.massey.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

  private AppointmentService service;
  private final LocalDate today = LocalDate.now();
  private StringBuffer tooLongDescription = new StringBuffer();
  private StringBuffer tooLongId = new StringBuffer();

  @BeforeEach
  void setup() {
    service = new AppointmentService();
    tooLongId = new StringBuffer();
    tooLongDescription = new StringBuffer();
    for (int i = 0; i < 55; i++) {
      tooLongDescription.append("a");
      tooLongId.append("z");
    }
  }

  @Test
  void addTest() {
    assertAll(
        () -> assertTrue(service.addAppointment("testID", today, "test description")),
        // description doesn't pass validation
        () -> assertFalse(service.addAppointment(tooLongId.toString(), today.minusYears(1), tooLongDescription.toString())),
        // id already exists
        () -> assertFalse(service.addAppointment("testID", today, "desc")),
        // id doesn't pass validation
        () -> assertFalse(service.addAppointment(tooLongId.toString(), today, "desc")),
        // date is before current date
        () -> assertFalse(service.addAppointment("sfaoaunb", today.minusYears(1), "desc")),
        // description doesn't pass validation
        () -> assertFalse(service.addAppointment("jdjdjdkd", today, tooLongDescription.toString())),
        // id is null
        () -> assertFalse(service.addAppointment(null, today, tooLongDescription.toString())),
        // date is null
        () -> assertFalse(service.addAppointment("21f#@23", null, "ssssss")),
        // description is null
        () -> assertFalse(service.addAppointment("aswefff", today, null))
    );
  }

  @Test
  void deleteTest() {
    assertAll(
        () -> assertTrue(service.addAppointment("testID1", today, "test description")),
        () -> assertTrue(service.addAppointment("testID2", today, "test description")),
        () -> assertTrue(service.deleteAppointment("testID2")),
        // id doesn't exist
        () -> assertFalse(service.deleteAppointment("testID2")),
        // id value is null
        () -> assertFalse(service.deleteAppointment(null)),
        // empty id value
        () -> assertFalse(service.deleteAppointment("")),
        () -> assertTrue(service.deleteAppointment("testID1"))
    );
  }

}

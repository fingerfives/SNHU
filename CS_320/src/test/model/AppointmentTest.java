package com.josh.massey.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
  @Test
  void createTest() {
    Appointment a = new Appointment("lsjbnrf", LocalDate.now(), "sef");
    Assertions.assertAll(
        () -> assertEquals("lsjbnrf", a.getId()),
        () -> assertEquals(LocalDate.now(), a.getDate()),
        () -> assertEquals("sef", a.getDescription())
    );
  }

}

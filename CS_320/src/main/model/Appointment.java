package com.josh.massey.model;

import java.time.LocalDate;

public class Appointment {

  private String id;
  private LocalDate date;
  private String description;

  private Appointment() {} // disallow use of the default constructor

  public Appointment (String id, LocalDate date, String description) {
    if (isValidId(id) && isValidDate(date) && isValidDescription(description)) {
      this.id = id;
      this.date = date;
      this.description = description;
    }
  }

  public String getId() {
    return id;
  }
  public LocalDate getDate() {
    return date;
  }
  public String getDescription() {
    return description;
  }

  private boolean isValidId(String id) {
    return id != null && !id.isEmpty() && id.length() < 11;
  }

  private boolean isValidDate(LocalDate date) {
    return date != null && !date.isBefore(LocalDate.now());
  }

  private boolean isValidDescription(String description) {
    return description != null && description.length() < 51;
  }

}

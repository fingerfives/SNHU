package com.josh.massey.service;

import com.josh.massey.model.Appointment;
import java.time.LocalDate;
import java.util.HashMap;

public class AppointmentService {

  private final HashMap<String, Appointment> appointments = new HashMap<>();

  public boolean addAppointment(String id, LocalDate date, String desc) {
    boolean added = false;
    Appointment appointment = new Appointment(id, date, desc);
    if (appointment.getDate() != null && !appointments.containsKey(id)) {
      appointments.put(id, appointment);
      added = true;
    }
    return added;
  }

  public boolean deleteAppointment(String id) {
    boolean deleted = false;
    if (id != null && appointments.containsKey(id)) {
      appointments.remove(id);
      deleted = true;
    }
    return deleted;
  }

}

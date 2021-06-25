package com.josh.massey.service;

import com.josh.massey.model.Contact;
import java.util.HashMap;

public class ContactService {

  private final HashMap<String, Contact> contacts = new HashMap<>();

  public boolean addContact(String id, String first, String last, String phone, String address) {
    boolean added = false;
    Contact c = new Contact(id, first, last, phone, address);
    if (!contacts.containsKey(id) && c.getAddress() != null) {
      contacts.put(id, c);
      added = true;
    }
    return added;
  }

  public boolean updateContact(String id, String param, String value) {
    boolean updated = false;
    if (id != null && contacts.containsKey(id)) {
      // process the update request
      Contact c = contacts.get(id);
      switch (param) {
        case "firstName":
          updated = c.setFirstName(value);
          break;
        case "lastName":
          updated = c.setLastName(value);
          break;
        case "phone":
          updated = c.setPhone(value);
          break;
        case "address":
          updated = c.setAddress(value);
          break;
      }
      contacts.replace(id, c);
    }
    return updated;
  }

  public boolean deleteContact(String id) {
    boolean successfulDelete = false;
    if (id != null && contacts.containsKey(id)) {
      contacts.remove(id);
      successfulDelete = true;
    }
    return successfulDelete;
  }

}

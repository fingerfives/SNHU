package com.josh.massey.model;

public class Task {

  private String name;
  private String description;
  private String id;

  private Task() {} //disallow use of the default constructor

  public Task (
      String id, String description, String name
  ) {
    if (nameIsValid(name) && descriptionIsValid(description) && idIsValid(id)) {
      this.name = name;
      this.description = description;
      this.id = id;
    }
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean setName(String name) {
    boolean set = false;
    if (nameIsValid(name)) {
      this.name = name;
      set = true;
    }
    return set;
  }

  public boolean setDescription(String description) {
    boolean set = false;
    if (descriptionIsValid(description)) {
      this.description = description;
      set = true;
    }
    return set;
  }

  public String getId() {
    return id;
  }

  private boolean nameIsValid(String name) {
    return name != null && !name.isEmpty() && name.length() < 11;
  }

  private boolean descriptionIsValid(String des) {
    return des != null && !des.isEmpty() && des.length() < 51;
  }

  private boolean idIsValid(String id) {
    return id != null && !id.isEmpty() && id.length() < 10;
  }

}

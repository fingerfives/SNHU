package com.josh.massey.model;

public class Contact {

  private String id;
  private String firstName;
  private String lastName;
  private String phone;
  private String address;

  private Contact() {} //disallow use of the default constructor

  public Contact(String id, String firstName, String lastName, String phone, String address) {
    if (
        idPassesVerification(id)
            && namePassesVerification(firstName)
            && namePassesVerification(lastName)
            && phonePassesVerification(phone)
            && addressPassesVerification(address)
    ) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.phone = phone;
    }
  }

  public boolean setAddress(String address) {
    boolean set = false;
    if (addressPassesVerification(address)) {
      this.address = address;
      set = true;
    }
    return set;
  }

  public boolean setFirstName(String firstName) {
    boolean set = false;
    if (namePassesVerification(firstName)) {
      this.firstName = firstName;
      set = true;
    }
    return set;
  }

  public boolean setLastName(String lastName) {
    boolean set = false;
    if (namePassesVerification(lastName)) {
      this.lastName = lastName;
      set = true;
    }
    return set;
  }

  public boolean setPhone(String phone) {
    boolean set = false;
    if (phonePassesVerification(phone)) {
      this.phone = phone;
      set = true;
    }
    return set;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }

  public String getAddress() {
    return address;
  }

  private boolean idPassesVerification(String id) {
    return id.length() < 11 && !id.isEmpty();
  }

  private boolean namePassesVerification(String name) {
    return !(name == null || name.isEmpty() || name.length() > 10);
  }

  private boolean phonePassesVerification(String number) {
    return !(number == null || number.length() != 10);
  }

  private boolean addressPassesVerification(String location) {
    return !(location == null || location.isEmpty() || location.length() > 30);
  }

}

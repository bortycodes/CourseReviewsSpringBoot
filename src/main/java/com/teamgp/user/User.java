package com.teamgp.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamgp.core.BaseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
  private String firstName;
  private String lastName;
  private String userName;
  @JsonIgnore
  private String password;
  @JsonIgnore
  private String[] roles;

  protected User(){
    super();
  }

  public User(String firstName, String lastName, String userName, String password,
              String[] roles) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    setPassword(password);
    this.roles = roles;
  }

  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }
}

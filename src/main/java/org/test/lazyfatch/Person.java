package org.test.lazyfatch;

import org.test.a_test.User;

import java.util.List;

public class Person {
  private int id;
  private String name;
  private String addr;

  List<User> userList;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  @Override
  public String toString() {
    return "Person{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", addr='" + addr + '\'' +
      ", userList=" + userList +
      '}';
  }
}

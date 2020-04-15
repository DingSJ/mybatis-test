package org.test.a_test;

public class User2 {
  private int id;
  private String name;
  private String addr;
  private String desc;

  User user;

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

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  @Override
  public String toString() {
    return "User2{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", addr='" + addr + '\'' +
      ", desc='" + desc + '\'' +
      ", user=" + user +
      '}';
  }
}

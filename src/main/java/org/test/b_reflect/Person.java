package org.test.b_reflect;

import java.io.Serializable;

public class Person implements Serializable {
  private int age;
  private String name;

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public Person() {
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void say(String msg) {
    System.out.println(this.name + " : " + msg);
  }

  @Override
  public String toString() {
    return "Person{" +
      "age=" + age +
      ", name='" + name + '\'' +
      '}';
  }
}

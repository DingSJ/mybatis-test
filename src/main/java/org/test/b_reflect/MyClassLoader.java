package org.test.b_reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {
  @Override
  public Class<?> loadClass(String name) throws ClassNotFoundException {
    System.out.println("自定义类加载器");
    return super.loadClass(name);
  }

  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
    Class aClass = Class.forName("org.test.b_reflect.Person", false, new MyClassLoader());

    Person person = (Person) aClass.newInstance();
    person.setName("MegGee");
    person.say("studying reflect ...");


    Object clazz = Class.forName("org.test.b_reflect.Person", false, new MyClassLoader()).newInstance();
    Method method = clazz.getClass().getMethod("say", String.class);
    Field field = clazz.getClass().getDeclaredField("name");
    field.setAccessible(true);
    field.set(clazz,"MG");
    method.invoke(clazz, "CCCCCCCCCCCC");
  }
}

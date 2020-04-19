/**
 *    Copyright 2010-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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

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
package org.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy<T> implements InvocationHandler {
  private T object;

  public JDKProxy(T object) {
    this.object = object;
  }

  @Override
  public T invoke(Object proxy, Method method, Object[] args) throws Throwable {
//    Object obj = Proxy.newProxyInstance(object.getClass().getClassLoader(),
//      object.getClass().getInterfaces(), this);

    T obj = (T)method.invoke(object, args);
    return obj;
  }

  public T getInstantce(){
    return (T)Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(), this);
  }
}

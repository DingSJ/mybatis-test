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

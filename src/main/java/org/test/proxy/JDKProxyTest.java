package org.test.proxy;

import java.lang.reflect.Proxy;

public class JDKProxyTest {
  public static void main(String[] args) {
    JDKProxy<MyServiceImpl> proxy = new JDKProxy(new MyServiceImpl());
    MyService instantce = proxy.getInstantce();
    instantce.say();

    JDKProxy<MyServiceImpl> proxy1 = new JDKProxy(new MyServiceImpl2());
    MyService instantce1 = proxy1.getInstantce();
    instantce1.say();

    System.out.println("++++++++++++++++");
    JDKProxy2 proxy2 = new JDKProxy2(new MyServiceImpl());
    MyService instantce2 = (MyService) Proxy.newProxyInstance(MyServiceImpl.class.getClassLoader(),
      MyServiceImpl.class.getInterfaces(),proxy2);
    instantce2.say();
  }
}

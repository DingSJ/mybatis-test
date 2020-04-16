package org.test.proxy;

public class CglibProxyTest {
    public static void main(String[] args) {
      CglibProxy proxy = new CglibProxy();
      MyService myService = (MyService) proxy.getProxyObj(MyServiceImpl.class);
      myService.say();
    }
}

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

package org.test.proxy;

/**
 * 动态代理接口
 */
public class MyServiceImpl2 implements MyService{
  /**
   * 发言
   */
  @Override
  public void say(){
    System.out.println("-----------------------------");
    System.out.println("发言-2.....");
    System.out.println("-----------------------------");
  }
}

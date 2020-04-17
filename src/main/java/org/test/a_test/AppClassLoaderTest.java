package org.test.a_test;

import sun.misc.Launcher;

public class AppClassLoaderTest{


  Launcher launcher = new Launcher();
//      -- 静态内部类
//  ExtClassLoader、AppClassLoader


  /**
   * 在虚拟机启动的时候会初始化BootstrapClassLoader，然后在Launcher类中去加载 ExtClassLoader、AppClassLoader，
   * 并将AppClassLoader的parent设置为ExtClassLoader，并设置线程上下文类加载器。
   *
   *
   * Launcher是JRE中用于启动程序入口main()的类，让我们看下Launcher的代码
   * */
}

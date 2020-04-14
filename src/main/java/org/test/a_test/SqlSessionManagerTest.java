package org.test.a_test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionManagerTest {
    public static void main(String[] args) throws IOException {
      String res = "org/test/mapper/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(res);
//      SqlSession session = SqlSessionManager.newInstance(inputStream);
//      for (int i = 0; i < 3; i++) {
//        new Thread(()->{
//          UserMapper mapper = session.getMapper(UserMapper.class);
//          User user = mapper.selectUser(1);
//          System.out.println(user);
//        },"My-Thread-"+i).start();
//      }
//
//      try {
//        Thread.sleep(2);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
      System.out.println("========================");

      for (int i = 0; i < 100; i++) {
        new Thread(()->{
          String res1 = "org/test/mapper/mybatis-config.xml";
          InputStream inputStream1 = null;
          try {
            inputStream1 = Resources.getResourceAsStream(res1);
          } catch (IOException e) {
            e.printStackTrace();
          }
          SqlSession session1 = SqlSessionManager.newInstance(inputStream1);
          UserMapper mapper = session1.getMapper(UserMapper.class);
          User user = mapper.selectUser(1);
          System.out.println(user);
        },"My-Thread-"+i).start();
      }
    }
}

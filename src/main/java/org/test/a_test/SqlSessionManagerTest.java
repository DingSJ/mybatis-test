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

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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlTest {
    public static void main(String[] args) throws IOException {

      String resource = "org/test/mapper/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      try (SqlSession session = sqlSessionFactory.openSession()) {
        User user = session.selectOne(
          "org.test.a_test.UserMapper.selectUser", 1);
        System.out.println(user);

        List<User> userList = session.selectList("org.test.a_test.UserMapper.selectUserList", 10000);

        long s = System.nanoTime();
        userList.parallelStream().forEach(System.out::println);
        long e = System.nanoTime();
        System.out.printf("parallelStream-1 耗时：%d" , (e-s)/1000/1000);


        long s1 = System.nanoTime();
        for (User u : userList) {
          System.out.println(u);
        }
        long e1 = System.nanoTime();
        System.out.printf("parallelStream-2 耗时：%d" , (e1-s1)/1000/1000);

        try (InputStream inputStream1 = new FileInputStream("")) {

        } catch (IOException | NullPointerException u) {
            u.printStackTrace();
        }


        Logger.getLogger(SqlTest.class.getName()).log(Level.INFO,"xxxxxxxxxxxxx");

      }
    }
}

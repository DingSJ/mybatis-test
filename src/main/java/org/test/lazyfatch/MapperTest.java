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
package org.test.lazyfatch;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.test.a_test.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试懒加载
 * */
public class MapperTest {
    public static void main(String[] args) throws IOException {

      String res = "org/test/mapper/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(res);
      SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"prod");
      inputStream.close();
      try (SqlSession sqlSession = sessionFactory.openSession()) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 注意 resultMap 不要重复引用
//        List<User> users = mapper.queryUserInfo();


        List<Person> users = mapper.queryPersonList();

        // 懒加载，用到指定的数据，再去查，用一条查一条
        System.out.println("==============================  ");
        Person person = users.get(2);
        System.out.println(person.getUserList());

        System.out.println("==============================  ");
        Person person2 = users.get(6);
        System.out.println(person2.getUserList());
      }
    }
}

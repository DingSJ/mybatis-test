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

import java.io.IOException;
import java.io.InputStream;

/**
 * 根据日志顺序学习 mybatis 一条SQL的执行过程
 * */
public class ExecProcessTest {
    public static void main(String[] args) throws IOException {

      String res = "org/test/mapper/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(res);
      SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"prod");
      inputStream.close();
      try (SqlSession sqlSession = sessionFactory.openSession()) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 级联查询传递多个参数 column="{id=template_id,name=template_name}"
        User2 user1 = mapper.selectUser2(1,"AAA");


//        User2 user2 = mapper.selectUser3(new QueryUserParam(1,"AAA"));

        System.out.println("[MAIN] : user1 - >>" + user1);
//        System.out.println("[MAIN] : user2 - >>" + user2);
      }
    }
}

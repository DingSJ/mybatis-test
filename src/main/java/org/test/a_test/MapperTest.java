package org.test.a_test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MapperTest {
    public static void main(String[] args) {

      String res = "org/test/mapper/mybatis-config.xml";
      try (InputStream inputStream = Resources.getResourceAsStream(res)) {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUser(1);
        System.out.println(user);
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
}

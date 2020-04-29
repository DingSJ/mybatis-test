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
package org.test.queryPage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.test.a_test.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试分页
 * */
public class MapperTest {
    public static void main(String[] args) throws IOException {

      String res = "org/test/mapper/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(res);
      SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"prod");
      inputStream.close();
      try (SqlSession sqlSession = sessionFactory.openSession()) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //分页处理，显示第一页的10条数据
//        PageHelper.startPage(1, 15);
//        PageHelper.offsetPage(1, 10);
//        List<User> list = mapper.selectUsersWithPage();//查询

        User user = mapper.selectUserById(199);
        System.out.println(user);

        List<User> list = mapper.selectUsersWithPage2(new RowBounds(0,15));//查询
        // 取商品列表
        for(User item : list) {
          System.out.println(item.getName());
        }
        // 取分页信息
        PageInfo<User> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal(); //获取总记录数
        System.out.println("共有商品信息：" + total);
      }
    }
}

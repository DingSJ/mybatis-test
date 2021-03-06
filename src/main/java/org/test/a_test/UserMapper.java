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

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.test.lazyfatch.Person;

import java.util.List;

public interface UserMapper {

//  @Select("SELECT * FROM blog WHERE id = #{id}")
  User selectUser(@Param("id") int id);

  List<User> selectUserList(int limit);


  User2 selectUser2(@Param("id") int id,@Param("name") String name);

  User2 selectUser3(QueryUserParam user);

  User selectUser4(UserParam aaa);

  /** 查询用户信息 */
  List<org.test.lazyfatch.User> queryUserInfo();

  List<Person> queryPersonList();

  /**
   * 分页查询
   * */
  List<org.test.queryPage.User> selectUsersWithPage();

  List<org.test.queryPage.User> selectUsersWithPage2(RowBounds rowBounds);
  org.test.queryPage.User selectUserById(int id);
}

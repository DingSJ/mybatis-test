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

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Clinton Begin
 */
public class MyStringTypeHandler implements TypeHandler<String> {

  @Override
  public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
    System.out.println(" set - 运行自定义字符串类型处理器");
    ps.setString(i,parameter);
  }

  @Override
  public String getResult(ResultSet rs, String columnName) throws SQLException {
    System.out.println(" rs-name - 运行自定义字符串类型处理器");
    return rs.getString(columnName);
  }

  @Override
  public String getResult(ResultSet rs, int columnIndex) throws SQLException {
    System.out.println(" rs-index - 运行自定义字符串类型处理器");
    return rs.getString(columnIndex);
  }

  @Override
  public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
    System.out.println(" cs - 运行自定义字符串类型处理器");
    return cs.getString(columnIndex);
  }
}

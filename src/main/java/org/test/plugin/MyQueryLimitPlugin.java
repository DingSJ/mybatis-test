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
package org.test.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * 注意：注解式必须的
 */

@Intercepts(
  {
    @Signature(
      type = StatementHandler.class,
      method = "prepare",
      args = {Connection.class, Integer.class}
    )
  }
)
public class MyQueryLimitPlugin implements Interceptor {

  /**
   * 配置文件添加参数
   */
  private int limit;
  private String type;

  @Override
  public Object intercept(Invocation invocation) throws Throwable {

    System.out.println("MyQueryLimitPlugin - 自定义插件运行");

    StatementHandler stmtHandler = (StatementHandler) invocation.getTarget();

    MetaObject metaObject = SystemMetaObject.forObject(stmtHandler);

    // 分离代理对象
    while (metaObject.hasGetter("h")) {
      Object object = metaObject.hasGetter("h");
      metaObject = SystemMetaObject.forObject(object);
    }

    while (metaObject.hasGetter("target")) {
      Object object = metaObject.hasGetter("target");
      metaObject = SystemMetaObject.forObject(object);
    }

    String sql = (String) metaObject.getValue("delegate.boundSql.sql");

    String limitSql = null;

    /** 判断sql 执行条件
     * 1. mysql 类型数据库
     * 2. 该语句是查询语句 select
     * 3. 当前SQL没有被重复处理
     * */
    if ("mysql".equals(this.type) &&
      sql != null && sql.trim().toLowerCase().trim().indexOf("select") == 0 &&
      sql.indexOf("QUERY_LIMIT_TABLE_PLUGIN") == -1) {

      limitSql = "select * from (" + sql.trim() + ") QUERY_LIMIT_TABLE_PLUGIN limit " + this.limit;
    }
    metaObject.setValue("delegate.boundSql.sql", limitSql);

    // 调用原来对象的方法，进入责任链下一个层级
    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  /**
   * 获取配置参数
   */
  @Override
  public void setProperties(Properties properties) {
    System.out.println("MyQueryLimitPlugin - 设置插件属性");
    String limitStr = properties.getProperty("limit", "50");
    this.limit = Integer.valueOf(limitStr);
    this.type = properties.getProperty("type", "mysql");
  }
}

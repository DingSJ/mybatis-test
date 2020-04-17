package org.test.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

@Intercepts(
    {
        @Signature(
            type = StatementHandler.class,
            method = "prepare",
            args = {Connection.class,Integer.class}
        )
    }
)
public class MyQueryLimitPlugin implements Interceptor {

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
    if ("mysql".equals(this.type) && sql.indexOf("QUERY_LIMIT_TABLE_PLUGIN") == -1) {

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

package org.test.a_test;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举测试类， 获取枚举值的不同方式
 * */
public enum StatusEnum {

  STARTED("1", "开始运行"),
  RUNNING("2", "正在运行"),
  STOPED("3", "结束运行");

  private String code;
  private String msg;

  StatusEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  private static Map<String,StatusEnum> statusMap = new HashMap<>(16);
  static {
    for (StatusEnum e : StatusEnum.values()) {
      statusMap.put(e.code, e);
    }
  }

  public static StatusEnum getStatusEnum(String code) {
    return statusMap.get(code);
  }

  public static String getStatusMsg(String code) {
    return statusMap.get(code).msg;
  }

  public static void main(String[] args) {
    System.out.println(StatusEnum.RUNNING);

    StatusEnum statusEnum = StatusEnum.STARTED;

    System.out.println(StatusEnum.getStatusMsg(statusEnum.code));

    System.out.println(StatusEnum.getStatusMsg("2"));
  }
}

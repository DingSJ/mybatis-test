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

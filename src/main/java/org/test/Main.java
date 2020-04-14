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
package org.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
      System.out.println("xXXXXXX");

      String res = "test.txt";
      URL resourceAsStream = Main.class.getResource(res);
      System.out.println(resourceAsStream.toString());

      InputStream resourceAsStream1 = Main.class.getResourceAsStream(res);
      System.out.println(resourceAsStream1.available());

      InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream1);

      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }


      System.out.println("============");
      String resource = "org/test/test.txt";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
      String l;
      while ((l = br.readLine()) != null) {
        System.out.println(l);
      }
    }
}

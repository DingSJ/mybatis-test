package org.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumRegexTest {

  public static void main(String[] args) {
    String regex = "\\d{8}";

    Pattern p = Pattern.compile(regex);
    Matcher matcher = p.matcher("20200102");
    boolean matches = matcher.find();
    System.out.println(matches);
    boolean m2 = matcher.matches();
    System.out.println(m2);

  }
}

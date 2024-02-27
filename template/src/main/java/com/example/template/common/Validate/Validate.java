package com.example.template.common.Validate;

import java.util.List;

public class Validate {

  public static boolean isNotEmptyAndNull(List<?> objectList) {
    return !isEmptyAndNull(objectList);
  }

  public static boolean isEmptyAndNull(List<?> objectList) {
    if (objectList == null || objectList.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean checkEven(Integer result) {
    if (result == null) {
      return true;
    }

    return result % 2 == 0;
  }
}

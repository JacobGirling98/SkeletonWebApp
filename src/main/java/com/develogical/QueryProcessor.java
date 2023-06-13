package com.develogical;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryProcessor {

  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }

    else if (query.toLowerCase().contains("what is your name")) {
      return "David Brent";
    }

    else if (query.toLowerCase().contains("numbers is the largest")) {
      String[] split = query.split(":");
      String[] numbers = split[1].trim().replace("?", "").split(",");
      List<Integer> ints = Arrays.stream(numbers).map(n -> Integer.parseInt(n.trim())).collect(Collectors.toList());
      Collections.sort(ints);
      return ints.get(ints.size() - 1).toString();
    }

    else if (query.toLowerCase().contains("plus")) {
      String[] split = query.replace("?", "").split("plus");
      int firstNum = Integer.parseInt(split[0].split("What is ")[1].trim());
      int secondNum = Integer.parseInt(split[1].trim());
      return String.valueOf(firstNum + secondNum);
    }

    else if (query.toLowerCase().contains("multiplied")) {
      String[] split = query.replace("?", "").split("multiplied by");
      int firstNum = Integer.parseInt(split[0].split("What is ")[1].trim());
      int secondNum = Integer.parseInt(split[1].trim());
      return String.valueOf(firstNum * secondNum);
    }

    return "";
  }
}

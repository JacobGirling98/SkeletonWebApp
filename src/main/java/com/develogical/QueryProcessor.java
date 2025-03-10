package com.develogical;

import java.math.BigDecimal;
import java.math.BigInteger;
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

    else if (query.toLowerCase().contains("minus")) {
      String[] split = query.replace("?", "").split("minus");
      int firstNum = Integer.parseInt(split[0].split("What is ")[1].trim());
      int secondNum = Integer.parseInt(split[1].trim());
      return String.valueOf(firstNum - secondNum);
    }

    else if (query.toLowerCase().contains("multiplied")) {
      String[] split = query.replace("?", "").split("multiplied by");
      int firstNum = Integer.parseInt(split[0].split("What is ")[1].trim());
      int secondNum = Integer.parseInt(split[1].trim());
      return String.valueOf(firstNum * secondNum);
    }

    else if (query.toLowerCase().contains("square and a cube")) {
      String numbers = query.replace("?", "").split(":")[1];
      String[] nums = numbers.split(",");
      List<Integer> ints = Arrays.stream(nums).map(n -> Integer.parseInt(n.trim())).collect(Collectors.toList());
      Collections.sort(ints);

      List<Integer> answers = ints.stream().filter(s -> {
        double square = Math.pow(s, 0.5);
        double cube = Math.cbrt(s);
        return square % 1 == 0 && cube % 1 == 0;
      }).collect(Collectors.toList());

      return answers.stream().map(x -> x.toString()).collect(Collectors.joining(",", "", ""));
    }

    else if (query.toLowerCase().contains("primes")) {
      String numbers = query.replace("?", "").split(":")[1];
      String[] nums = numbers.split(",");
      List<Integer> ints = Arrays.stream(nums).map(n -> Integer.parseInt(n.trim())).collect(Collectors.toList());
      Collections.sort(ints);

      List<Integer> answers = ints.stream().filter(s -> {
        BigInteger bigInt = BigInteger.valueOf(s);
        return bigInt.isProbablePrime(100);

      }).collect(Collectors.toList());

      return answers.stream().map(x -> x.toString()).collect(Collectors.joining(",", "", ""));
    }

    else if (query.toLowerCase().contains("power of")) {
      String[] split = query.replace("?", "").split(" to the power of ");
      int first = Integer.parseInt(split[0].split("What is ")[1]);
      int second = Integer.parseInt(split[1]);
      return new BigDecimal(Math.pow(first, second)).toPlainString();
    }



    return "";
  }
}

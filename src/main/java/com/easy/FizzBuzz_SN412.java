package com.easy;

import java.util.*;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */
public class FizzBuzz_SN412
{
  public static void main(String[] args)
  {
    fizzBuzz(20).forEach(System.out::print);
  }

  public static List<String> fizzBuzz(int n)
  {
    List<String> result = new ArrayList<>();
    for (int i = 1; i <= n; i++)
    {
      String val;
      if (i % 15 == 0)
      {
        val = "FizzBuzz";
      }
      else if (i % 5 == 0)
      {
        val = "Buzz";
      }
      else if (i % 3 == 0)
      {
        val = "Fizz";
      }
      else
      {
        val = String.valueOf(i);
      }
      result.add(val);
    }
    return result;
  }
}

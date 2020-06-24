package com.dp.learning;

/**
 * Find sum of digits of number using recursive function.
 */
public class SumOfInteger
{
  public static void main(String[] args)
  {
    long input = 123456789L;
    System.out.println(sumInteger(input, 0));
  }

  private static long sumInteger(long input, long sum)
  {
    return input == 0 ? sum : sum + sumInteger(input / 10, input % 10);
  }

}

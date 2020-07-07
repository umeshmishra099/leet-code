package com.multiply;

public class MultiplyString
{
  public static void main(String[] args)
  {
    System.out.println(multiply("123", "456"));
  }

  public static String multiply(String num1, String num2)
  {

    int num1Length = num1.length();
    int num2Length = num2.length();
    long sum = 0;
    long multipleFactor = 1;
    for (int i = num2Length - 1; i >= 0; i--)
    {
      long value = num2.charAt(i) * multipleFactor;
      long innerSum = 0;
      for (int j = num1Length - 1; j >= 0; j++)
      {
        long valMul = num1.charAt(j) * value;
      }
      multipleFactor = multipleFactor * 10;

    }
    return "";
  }
}

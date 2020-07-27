package com.explore.arrays;

public class FindNumbersWithEvenNumberOfDigits
{
  public static void main(String[] args)
  {
    int[] input = {12, 345, 2, 6, 7896};
    System.out.println(findNumbers(input));
  }

  private static int findNumbers(int[] nums)
  {
    int result = 0;
    for (int num : nums)
    {
      int numLength = 0;
      int temp = 1;
      while (temp <= num)
      {
        numLength = numLength + 1;
        temp = temp * 10;
      }
      if (numLength % 2 == 0)
      {
        result = result + 1;
      }
    }
    return result;
  }
}

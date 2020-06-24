package com.missing;

import java.util.Arrays;

public class FirstMissingPositiveNumber
{
  public static void main(String[] args)
  {
    int[] input = {1, 2, 3, 10, 2147483647, 9};
    System.out.println(firstMissingPositive(input));
  }

  private static int firstMissingPositive(int[] nums)
  {
    int result = 1;
    long max = Arrays.stream(nums).max().orElse(1);
    for (long i = 1; i <= max + 1; i++)
    {
      boolean found = false;
      for (int num : nums)
      {
        if (num == i)
        {
          found = true;
          break;
        }
      }
      if (!found)
      {
        result = (int)i;
        break;
      }
    }
    return result;
  }

}

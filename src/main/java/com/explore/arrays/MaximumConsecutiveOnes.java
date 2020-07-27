package com.explore.arrays;

public class MaximumConsecutiveOnes
{
  public static void main(String[] args)
  {
    int[] input = {1, 1, 0, 1, 1, 1};
    System.out.println(findMaxConsecutiveOnes(input));
  }

  private static int findMaxConsecutiveOnes(int[] nums)
  {
    int result = 0;
    int tempMax = 0;
    for (int num : nums)
    {
      if (num == 1)
      {
        tempMax = tempMax + 1;
        result = Math.max(tempMax, result);
      }
      else
      {
        tempMax = 0;
      }
    }
    return result;
  }

}

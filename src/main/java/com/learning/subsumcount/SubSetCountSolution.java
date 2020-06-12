package com.learning.subsumcount;

public class SubSetCountSolution
{
  public static void main(String[] args)
  {
    int[] input = {3, 4, 7, 2, -3, 1, 4, 2};
    System.out.println(subarraySum(input, 7));
  }

  private static int subarraySum(int[] nums, int sum)
  {
    int count = 0;

    for (int i = 0; i < nums.length; i++)
    {
      int innerSum = 0;
      for (int j = i; j < nums.length; j++)
      {
        innerSum = innerSum + nums[j];
        if (innerSum == sum)
        {
          count = count + 1;
        }
      }
    }
    return count;
  }
}

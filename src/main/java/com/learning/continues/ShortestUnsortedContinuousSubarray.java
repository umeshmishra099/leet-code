package com.learning.continues;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray
{
  public static void main(String[] args)
  {
    int[] input = {2, 6, 4, 8, 10, 9, 15};
    System.out.println(findUnsortedSubarray(input));
  }

  private static int findUnsortedSubarray(int[] nums)
  {
    int firsIndexChange = -1;
    int lastIndexChange = -1;
    int[] sortArray = nums.clone();
    Arrays.sort(sortArray);
    for (int i = 0; i < nums.length; i++)
    {
      if (sortArray[i] != nums[i])
      {
        if (firsIndexChange == -1)
        {
          firsIndexChange = i;
        }
        lastIndexChange = i;
      }
    }
    return lastIndexChange == -1 ? 0 : lastIndexChange - firsIndexChange + 1;
  }
}

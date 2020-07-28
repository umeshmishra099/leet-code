package com.explore.arrays;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray
{
  public static void main(String[] args)
  {
    int[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.out.println(removeDuplicates(input));
    Arrays.stream(input).forEach(System.out::println);
  }

  private static int removeDuplicates(int[] nums)
  {
    int j = 0;
    if (nums.length == 0)
    {
      return 0;
    }

    for (int i = 1; i < nums.length; i++)
    {
      if (nums[i] != nums[j])
      {
        j = j + 1;
        nums[j] = nums[i];
      }
    }
    return j;
  }
}

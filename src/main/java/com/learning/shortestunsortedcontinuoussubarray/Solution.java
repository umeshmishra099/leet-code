package com.learning.shortestunsortedcontinuoussubarray;

import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class Solution
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

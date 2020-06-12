package com.subarray;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubArray
{
  public static void main(String[] args)
  {
    int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(input));
  }

  public static int maxSubArray(int[] nums)
  {
    int[] result = new int[nums.length];
    if (nums.length == 0)
    {
      return 0;
    }
    result[0] = nums[0];
    for (int i = 1; i < nums.length; i++)
    {
      result[i] = Math.max(nums[i], result[i - 1] + nums[i]);
    }
    int max = result[0];
    for (int value : result)
    {
      max = Math.max(max, value);
    }
    return max;
  }
}

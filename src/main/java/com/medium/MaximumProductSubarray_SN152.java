package com.medium;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray_SN152
{
  public static void main(String[] args)
  {
    int[] input = {2, 3, -2, 4};
    int[] input1 = {0, 2};
    int[] input2 = {-2, 0, -1};
    System.out.println(maxProduct(input));
    System.out.println(maxProduct(input1));
    System.out.println(maxProduct(input2));
  }

  public static int maxProduct(int[] nums)
  {
    if (nums.length == 0)
    {
      return 0;
    }
    int globalMax = nums[0];
    int current_Max = nums[0];
    int current_Min = nums[0];
    for (int i = 1; i < nums.length; i++)
    {
      int temp_Max = current_Max;
      current_Max = Math.max(Math.max(current_Max * nums[i], current_Min * nums[i]), nums[i]);
      current_Min = Math.min(Math.min(temp_Max * nums[i], current_Min * nums[i]), nums[i]);
      if (current_Max > globalMax)
      {
        globalMax = current_Max;
      }
    }
    return globalMax;
  }
}

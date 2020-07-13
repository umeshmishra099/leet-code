package com.easy;

import java.util.Arrays;

public class RotateArray_SN189
{
  public static void main(String[] args)
  {
    int[] input = {1,2,3,4,5,6,7};
    rotateAllElement(input, 2);
    Arrays.stream(input).forEach(System.out::print);
  }

  /**
   * Solution 1 using rotation
   * starts
   */
  private static void rotate(int[] nums, int k)
  {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private static void reverse(int[] nums, int start, int end)
  {
    for (int i = start; i < end; i++)
    {
      int temp = nums[i];
      nums[i] = nums[end];
      nums[end] = temp;
      end = end - 1;
    }
  }

  /**
   * Solution 1 using rotation
   * ends
   */

  /**
   * Solution 2 rotate all element
   * starts
   */
  private static void rotateAllElement(int[] nums, int k)
  {
    k = k % nums.length;
    for (int i = 0; i < k; i++)
    {
      int prev = nums[nums.length - 1];
      for (int j = 0; j < nums.length; j++)
      {
        int temp = nums[j];
        nums[j] = prev;
        prev = temp;
      }
    }
  }

  /**
   * Solution 2 rotate all element
   * ends
   */

}

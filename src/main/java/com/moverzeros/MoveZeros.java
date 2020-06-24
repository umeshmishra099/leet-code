package com.moverzeros;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeros
{
  public static void main(String[] args)
  {
    int[] input = {0, 1, 0, 3, 12};
    int[] input1 = {0, 0, 1};
    moveZeroes(input);
    Arrays.stream(input).forEach(System.out::print);
  }

  private static void moveZeroes(int[] nums)
  {
    int index = 0;
    for (int i = 0; i < nums.length; i++)
    {
      if (nums[i] != 0)
      {
        nums[index] = nums[i];
        index = index + 1;
      }
    }
    while (index < nums.length)
    {
      nums[index] = 0;
      index = index + 1;
    }
  }
}

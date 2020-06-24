package com.missing;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 */
public class MissingNumber
{
  public static void main(String[] args)
  {
    int[] input = {3, 0, 1};
    System.out.println(missingNumber(input));
  }

  private static int missingNumber(int[] nums)
  {
    int sum = 0;
    for (int num : nums)
    {
      sum = sum + num;
    }
    int length = nums.length;
    int actualSum = length * (length + 1) / 2;
    return actualSum - sum;
  }
}

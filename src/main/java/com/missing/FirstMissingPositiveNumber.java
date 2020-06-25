package com.missing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositiveNumber
{
  public static void main(String[] args)
  {
    int[] input = {3,1};
    System.out.println(firstMissingPositive1(input));
  }

  private static int firstMissingPositive(int[] nums)
  {
    Set<Integer> numbers = new HashSet<>();
    for (int num : nums)
    {
      if (num > 0)
      {
        numbers.add(num);
      }
    }
    for (int i = 1; i <= nums.length; i++)
    {
      if (!numbers.contains(i))
      {
        return i;
      }
    }
    return nums.length + 1;
  }

  private static int firstMissingPositive1(int[] nums)
  {
    int n = nums.length;
    boolean containsOne = false;
    for (int i = 0; i < n; i++)
    {
      if (nums[i] == 1)
      {
        containsOne = true;
      }
      else if (nums[i] <= 0 || nums[i] > n)
      {
        nums[i] = 1;
      }
    }
    if (!containsOne)
    {
      return 1;
    }
    for (int i = 0; i < n; i++)
    {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] > 0)
      {
        nums[index] = -1 * nums[index];
      }
    }

    for (int i = 0; i < n; i++)
    {
      int num = nums[i];
      if (num > 0)
      {
        return i + 1;
      }
    }
    return n + 1;
  }

}

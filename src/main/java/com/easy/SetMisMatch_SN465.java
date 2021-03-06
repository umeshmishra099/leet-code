package com.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * <p>
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 */
public class SetMisMatch_SN465
{
  public static void main(String[] args)
  {
    int[] input = {3, 2, 2};
    System.out.println(findErrorNums(input));
  }

  private static int[] findErrorNums(int[] nums)
  {
    Map<Integer, Integer> result = new HashMap<>();
    int val1 = -1;
    int val2 = -1;
    for (int num : nums)
    {
      result.put(num, result.getOrDefault(num, 0) + 1);
    }
    for (int i = 0; i < nums.length; i++)
    {
      if (result.containsKey(i))
      {
        if (result.get(nums[i]) == 2)
        {
          val2 = nums[i];
        }
      }
      else
      {
        val1 = i;
      }
    }
    return new int[]{val2, val1};
  }

}

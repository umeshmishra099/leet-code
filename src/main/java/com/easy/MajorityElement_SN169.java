package com.easy;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement_SN169
{
  public static void main(String[] args)
  {
    int[] input = {1, 2, 2, 3, 2, 1, 1, 3};
    System.out.println(majorityElements(input));
  }

  private static int majorityElement(int[] nums)
  {
    int result = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++)
    {
      if (count == 0)
      {
        result = nums[i];
        count = count + 1;
      }
      else if (result == nums[i])
      {
        count = count + 1;
      }
      else
      {
        count = count - 1;
      }
    }
    return result;
  }

  private static List<Integer> majorityElements(int[] nums)
  {
    List<Integer> result = new ArrayList<>();
    if (nums.length == 0)
    {
      return result;
    }
    int result1 = 0;
    int count1 = 0;
    int result2 = 0;
    int count2 = 0;
    for (int num : nums)
    {
      if (result1 == num)
      {
        count1 = count1 + 1;
      }

      else if (result2 == num)
      {
        count2 = count2 + 1;
      }
      else if (count1 == 0)
      {
        result1 = num;
        count1 = count1 + 1;
      }
      else if (count2 == 0)
      {
        result2 = num;
        count2 = count2 + 1;
      }

      else
      {
        count1 = count1 - 1;
        count2 = count2 - 1;
      }
    }
    count1 = 0;
    count2 = 0;
    for (int num : nums)
    {
      if (num == result1)
      {
        count1 = count1 + 1;
      }
      else if (num == result2)
      {
        count2 = count2 + 1;
      }
    }
    if (count1 > nums.length / 3)
    {
      result.add(result1);
    }
    if (count2 > nums.length / 3)
    {
      result.add(result2);
    }
    return result;
  }
}

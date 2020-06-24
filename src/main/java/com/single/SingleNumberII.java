package com.single;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class SingleNumberII
{
  public static void main(String[] args)
  {
    int[] input = {2,2,3,2};
    System.out.println(singleNumberII(input));

  }

  private static int singleNumberII(int[] nums)
  {
    Map<Integer, Integer> count = new HashMap<>();
    for (Integer key : nums)
    {
      if (count.containsKey(key))
      {
        count.put(key, count.get(key) + 1);
      }
      else
      {
        count.put(key, 1);
      }
    }
    int result = -1;
    for (Map.Entry<Integer, Integer> entry : count.entrySet())
    {
      Integer key = entry.getKey();
      Integer value = entry.getValue();
      if (value != 3)
      {
        result = key;
        break;
      }
    }
    return result;
  }

}

package com.single;

import java.util.*;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 */
public class SingleNumberIII
{
  public static void main(String[] args)
  {
    int[] input = {1, 2, 1, 3, 2, 5};
    System.out.println(Arrays.toString(singleNumberIII(input)));

  }

  private static int[] singleNumberIII(int[] nums)
  {
    int[] output = new int[2];
    Map<Integer, Integer> count = new HashMap<>();
    for (Integer key : nums)
    {
      count.put(key, count.getOrDefault(key, 0) + 1);
    }
    int index = 0;
    for (Map.Entry<Integer, Integer> entry : count.entrySet())
    {
      Integer key = entry.getKey();
      Integer value = entry.getValue();
      if (value == 1)
      {
        output[index] = key;
        index = index + 1;
      }
    }
    return output;
  }

}

package com.single;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber
{
  public static void main(String[] args)
  {
    int[] input = {4, -1, -2, -1, -2};
    System.out.println(singleNumberSolution1(input));
    System.out.println(singleNumberSolution2(input));
    System.out.println(singleNumberSolution3(input));
  }

  private static int singleNumberSolution1(int[] nums)
  {
    List<Integer> values = new ArrayList<>();
    for (int num : nums)
    {
      if (values.contains(num))
      {
        values.remove((Integer)num);
      }
      else
      {
        values.add(num);
      }
    }
    return values.get(0);
  }

  private static int singleNumberSolution2(int[] nums)
  {
    return 2 * Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet())
            .stream().reduce(0, Integer::sum) - Arrays.stream(nums).sum();
  }

  private static int singleNumberSolution3(int[] nums)
  {
    int a = 0;
    for (int num : nums)
    {
      a = a ^ num;
    }
    return a;
  }
}

package com.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class DisappearedNumbers_SN448
{
  public static void main(String[] args)
  {
    int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
    System.out.println(findDisappearedNumbers(input));
  }

  private static List<Integer> findDisappearedNumbers(int[] nums)
  {
    List<Integer> results = new ArrayList<>();
    Set<Integer> allNumbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    for (int i = 1; i <= nums.length; i++)
    {
      if (!allNumbers.contains(i))
      {
        results.add(i);
      }
    }
    return results;
  }
}

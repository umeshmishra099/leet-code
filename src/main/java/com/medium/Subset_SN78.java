package com.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
class Subset_SN78
{

  public static void main(String[] args)
  {
    int[] input = {1, 2, 3};
    System.out.println(subsets(input));
  }

  public static List<List<Integer>> subsets(int[] nums)
  {
    List<List<Integer>> result = new ArrayList<>();
    final ArrayList<Integer> data = new ArrayList<>();
    result.add(data);
    for (int n : nums)
    {
      int size = result.size();
      for (int i = 0; i < size; i++)
      {
        List<Integer> subset = new ArrayList<>(result.get(i));
        subset.add(n);
        result.add(subset);
      }
    }
    return result;
  }
}

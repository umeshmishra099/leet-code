package com.learning.subsets;

import java.util.ArrayList;
import java.util.List;

class SolutionSubset
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

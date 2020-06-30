package com.topkthfreq;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
public class TopKFrequentElement
{
  public static void main(String[] args)
  {
    int[] input = {1, 1, 1, 2, 2, 3,2,2,3,1,5,6,5,3,6,7,6,6,6,6,8};
    Arrays.stream(topKFrequent(input, 3)).forEach(System.out::println);
  }

  private static int[] topKFrequent(int[] nums, int k)
  {
    Map<Integer, Integer> count = new HashMap<>();
    for (int num : nums)
    {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }
    int[] uniqueCounts = new int[count.size()];
    int index = 0;
    for (Integer key : count.keySet())
    {
      uniqueCounts[index] = key;
      index = index + 1;
    }

    // sort uniqueCounts based on its frequency.
    int inputLength = uniqueCounts.length;

    for (int i = 0; i < inputLength - 1; i++)
    {
      for (int j = 0; j < inputLength - i - 1; j++)
      {
        if (count.get(uniqueCounts[j]) > count.get(uniqueCounts[j + 1]))
        {
          int temp = uniqueCounts[j];
          uniqueCounts[j] = uniqueCounts[j + 1];
          uniqueCounts[j + 1] = temp;
        }
      }
    }
    return Arrays.copyOfRange(uniqueCounts, inputLength - k, inputLength);
  }

}

package com.medium;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
public class TopKFrequentElement_SN347
{
  public static void main(String[] args)
  {
    int[] input = {2,2,2,1, 1, 1, 2, 2, 3, 2, 2, 3, 1, 5, 6, 5, 3, 6, 8, 6, 6, 6, 6, 7};
    Arrays.stream(topKFrequent(input, 2)).forEach(System.out::println);
  }

  private static Integer[] topKFrequent(int[] nums, int k)
  {
    List<Integer>[] bucket = new List[nums.length + 1];
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    for (int n : nums)
    {
      frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    }

    for (int key : frequencyMap.keySet())
    {
      int frequency = frequencyMap.get(key);
      if (bucket[frequency] == null)
      {
        bucket[frequency] = new ArrayList<>();
      }
      bucket[frequency].add(key);
    }

    List<Integer> res = new ArrayList<>();

    for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--)
    {
      if (bucket[pos] != null)
      {
        res.addAll(bucket[pos]);
      }
    }
    res = res.subList(0, k);
    return res.toArray(new Integer[0]);
  }

}

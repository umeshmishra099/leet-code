package com.topkthfreq;

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
public class TopKFrequentElement
{
  public static void main(String[] args)
  {
    int[] input = {1, 1, 1, 2, 2, 3, 2, 2, 3, 1, 5, 6, 5, 3, 6, 7, 6, 6, 6, 6, 8};
    Arrays.stream(topKFrequent(input, 2)).forEach(System.out::println);
  }

  private static int[] topKFrequent(int[] nums, int k)
  {
    Map<Integer, Integer> countFreq = new HashMap<>();
    for (int num : nums)
    {
      countFreq.put(num, countFreq.getOrDefault(num, 0) + 1);
    }
    int[] uniques = new int[countFreq.size()];
    int index = 0;
    for (Integer key : countFreq.keySet())
    {
      uniques[index] = key;
      index = index + 1;
    }

    // sort uniques based on its frequency.
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
    );

    for (Map.Entry<Integer, Integer> entry : countFreq.entrySet())
    {
      pq.offer(entry);
      if (pq.size() > k)
        pq.poll();
    }
    int[] result = new int[k];
    index = 0;
    while (!pq.isEmpty())
    {
      result[index] = pq.poll().getKey();
      index = index + 1;
    }
   return result;
  }

  private static void sort(int[] input, Map<Integer, Integer> count)
  {
    int inputLength = input.length;
    for (int i = inputLength / 2 - 1; i >= 0; i--)
    {
      heapify(input, inputLength, i, count);
    }
    for (int i = inputLength - 1; i >= 0; i--)
    {
      int temp = input[0];
      input[0] = input[i];
      input[i] = temp;
      heapify(input, i, 0, count);
    }
  }

  private static void heapify(int[] input, int inputLength, int i, Map<Integer, Integer> count)
  {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < inputLength && count.get(input[largest]) < count.get(input[left]))
    {
      largest = left;
    }
    if (right < inputLength && count.get(input[largest]) < count.get(input[right]))
    {
      largest = right;
    }
    if (largest != i)
    {
      int temp = input[i];
      input[i] = input[largest];
      input[largest] = temp;
      heapify(input, inputLength, largest, count);
    }
  }
}

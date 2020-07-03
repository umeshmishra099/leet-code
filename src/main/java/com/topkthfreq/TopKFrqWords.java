package com.topkthfreq;

import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrqWords
{
  public static void main(String[] args)
  {
    String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
    String[] input2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    System.out.println(topKFrequent(input, 1));
    System.out.println(topKFrequent(input2, 4));
  }

  private static List<String> topKFrequent(String[] words, int k)
  {
    List<String> result = new ArrayList<>();
    Map<String, Integer> wordCounts = new TreeMap<>();
    for (String word : words)
    {
      wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
            (o1, o2) -> o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue());
    for (Map.Entry<String, Integer> entry : wordCounts.entrySet())
    {
      priorityQueue.offer(entry);
      if (priorityQueue.size() > k)
      {
        priorityQueue.poll();
      }
    }

    while (!priorityQueue.isEmpty())
    {
      result.add(0, priorityQueue.poll().getKey());
    }
    return result;
  }
}

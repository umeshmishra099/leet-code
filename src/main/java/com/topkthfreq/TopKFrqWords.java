package com.topkthfreq;

import java.util.*;

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

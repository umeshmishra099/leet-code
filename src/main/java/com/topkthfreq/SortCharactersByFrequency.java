package com.topkthfreq;

import java.util.*;

public class SortCharactersByFrequency
{
  public static void main(String[] args)
  {
    System.out.println(frequencySort("ttttree"));
    System.out.println(frequencySort("cccaaa"));
  }

  public static String frequencySort(String s)
  {

    Map<Character, Integer> charCounts = new HashMap<>();
    final int inputLength = s.length();
    List<Integer>[] bucket = new List[inputLength + 1];
    for (int i = 0; i < inputLength; i++)
    {
      final char key = s.charAt(i);
      charCounts.put(key, charCounts.getOrDefault(key, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(
            (o1, o2) -> o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o2.getValue() - o1.getValue());
    StringBuilder result = new StringBuilder();
    for (Map.Entry<Character, Integer> entry : charCounts.entrySet())
    {
      priorityQueue.offer(entry);
    }

    while (!priorityQueue.isEmpty())
    {
      final Map.Entry<Character, Integer> poll = priorityQueue.poll();
      for (int i = 0; i < poll.getValue(); i++)
      {
        result.append(poll.getKey());
      }
    }
    return result.toString();
  }

}

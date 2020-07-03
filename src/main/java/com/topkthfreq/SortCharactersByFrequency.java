package com.topkthfreq;

import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
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

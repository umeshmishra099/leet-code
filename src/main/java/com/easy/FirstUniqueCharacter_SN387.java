package com.easy;

import java.util.*;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 *
 * Note: You may assume the string contains only lowercase English letters.
 */
public class FirstUniqueCharacter_SN387
{
  public static void main(String[] args)
  {
    String input = "loveleetcode";
    System.out.println(firstUniqChar(input));
  }

  public static int firstUniqChar(String s)
  {
    Map<Character, Integer> characterCounts = new LinkedHashMap<>();
    Set<Character> characters = new HashSet<>();
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++)
    {
      Character character = charArray[i];
      if (characters.contains(character))
      {
        characterCounts.remove(character);
      }
      else
      {
        characterCounts.put(character,i);
        characters.add(character);
      }
    }
    return characterCounts.size() == 0 ? -1 : characterCounts.entrySet().stream().findFirst().get().getValue();
  }
}

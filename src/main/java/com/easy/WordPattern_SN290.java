package com.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 */
public class WordPattern_SN290
{
  public static void main(String[] args)
  {
    String pattern = "abbc";
    String input = "dog cat cat fish";
    System.out.println(wordPattern(pattern, input));

  }

  public static boolean wordPattern(String pattern, String str)
  {
    Map<Character, String> charWordMap = new HashMap<>();
    String[] words = str.split(" ");
    if (pattern.length() != words.length)
    {
      return false;
    }
    for (int i = 0; i < words.length; i++)
    {
      char patternChar = pattern.charAt(i);
      String word = words[i];
      if (charWordMap.containsKey(patternChar))
      {
        if (!charWordMap.get(patternChar).equals(word))
        {
          return false;
        }
      }
      else
      {
        if (!charWordMap.containsValue(word))
        {
          charWordMap.put(patternChar, word);
        }
        else
        {
          return false;
        }
      }
    }
    return true;
  }
}

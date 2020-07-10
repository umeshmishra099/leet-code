package com.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_SN205
{
  public static void main(String[] args)
  {
    System.out.println(isIsomorphic("ab", "aa"));
  }

  public static boolean isIsomorphic(String s, String t)
  {
    Map<Character, Character> charMap = new HashMap<>();
    char[] chars = s.toCharArray();
    char[] chart = t.toCharArray();
    for (int i = 0; i < chars.length; i++)
    {
      if (charMap.containsKey(chars[i]))
      {
        if (!charMap.get(chars[i]).equals(chart[i]))
        {
          return false;
        }
      }
      else
      {
        if (!charMap.containsValue(chart[i]))
        {
          charMap.put(chars[i], chart[i]);
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

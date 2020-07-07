package com.topkthfreq;

import java.util.*;

public class FirstUniqueCharacter
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

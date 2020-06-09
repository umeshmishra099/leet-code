package com.learning.valid;

import java.util.*;

public class ValidParentheses
{
  public static void main(String[] args)
  {
    System.out.println(isValid("{[][](((((([]))))))[]}"));
  }

  private static boolean isValid(String s)
  {
    Map<Character, Character> brackets = new HashMap<Character, Character>();
    brackets.put(')', '(');
    brackets.put('}', '{');
    brackets.put(']', '[');
    Stack<Character> characterStack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++)
    {
      char value = s.charAt(i);
      if (brackets.containsKey(value))
      {
        if (!characterStack.isEmpty())
        {
          final Character pop = characterStack.pop();
          if (pop != brackets.get(value))
          {
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      else
      {
        characterStack.push(value);
      }
    }
    return characterStack.isEmpty();
  }
}

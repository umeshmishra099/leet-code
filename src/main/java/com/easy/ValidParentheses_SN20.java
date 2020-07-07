package com.easy;

import java.util.*;
/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 */
public class ValidParentheses_SN20
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

package com.easy;

public class ReverseString_SN344
{
  public static void main(String[] args)
  {
    char[] s = "Hello".toCharArray();
    reverseString(s);
    for (char c : s)
    {
      System.out.print(c);
    }
  }

  private static void reverseString(char[] s)
  {
    int left = 0;
    int right = s.length - 1;
    while (left < right)
    {
      char c = s[left];
      s[left] = s[right];
      s[right] = c;
      left = left + 1;
      right = right - 1;
    }
  }
}

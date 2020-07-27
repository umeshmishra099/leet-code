package com.explore.binarysearch;

public class BadVersion
{
  public static void main(String[] args)
  {
    System.out.println(firstBadVersion(7));
  }

  private static int firstBadVersion(int n)
  {
    int left = 1;
    int right = n;
    int middle;
    while (left <= right)
    {
      middle = left + (right - left) / 2;
      if (isBadVersion(middle))
      {
        right = middle - 1;
      }
      else
      {
        left = middle + 1;
      }
    }
    return left;
  }

  private static boolean isBadVersion(int n)
  {
    return n > 3;
  }

}

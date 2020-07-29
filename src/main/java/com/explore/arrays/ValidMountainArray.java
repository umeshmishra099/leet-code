package com.explore.arrays;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1]
 * Output: false
 * Example 2:
 * <p>
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 * <p>
 * Input: [0,3,2,1]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class ValidMountainArray
{

  public static void main(String[] args)
  {
    int[] input = {2, 0, 2};
    System.out.println(validMountainArray(input));

  }

  //Solution 1
  private static boolean validMountainArray1(int[] A)
  {
    if (A == null || A.length < 3)
    {
      return false;
    }

    int maxIndex = 0;
    int maxValue = A[0];
    for (int i = 1; i < A.length; i++)
    {
      if (maxValue < A[i])
      {
        maxIndex = i;
        maxValue = A[i];
      }
    }

    if (maxIndex == 0 || maxIndex == A.length - 1)
    {
      return false;
    }

    // Left from Max index
    int currentValue = A[maxIndex];
    for (int i = maxIndex - 1; i >= 0; i--)
    {
      if (currentValue - A[i] <= 0)
      {
        return false;
      }
      currentValue = A[i];
    }

    // Right from Max index
    currentValue = A[maxIndex];
    for (int i = maxIndex + 1; i < A.length; i++)
    {
      if (currentValue - A[i] <= 0)
      {
        return false;
      }
      currentValue = A[i];
    }
    return true;
  }

  //Solution 2
  private static boolean validMountainArray(int[] A)
  {
    int inputLength = A.length - 1;
    int i = 0;
    while (i < inputLength && A[i] < A[i + 1])
    {
      i = i + 1;
    }

    if (i == 0 || i == inputLength)
    {
      return false;
    }

    while (i < inputLength && A[i + 1] < A[i])
    {
      i = i + 1;
    }
    return i == inputLength;
  }

}

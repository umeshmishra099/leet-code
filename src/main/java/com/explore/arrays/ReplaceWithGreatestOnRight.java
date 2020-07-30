package com.explore.arrays;

import java.util.Arrays;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * <p>
 * After doing so, return the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */
public class ReplaceWithGreatestOnRight
{
  public static void main(String[] args)
  {
    int[] input = {17, 18, 5, 4, 6, 1};
    Arrays.stream(replaceElements(input)).forEach(System.out::println);
  }

  private static int[] replaceElements(int[] arr)
  {
    int max = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--)
    {
      int temp = arr[i];
      arr[i] = max;
      max = Math.max(max, temp);
    }
    arr[arr.length - 1] = -1;
    return arr;
  }

}

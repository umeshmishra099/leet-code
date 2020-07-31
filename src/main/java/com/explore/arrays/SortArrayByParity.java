package com.explore.arrays;

import java.util.Arrays;

/**
 * iven an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity
{
  public static void main(String[] args)
  {
    int[] input = {3, 1, 2, 4};
    Arrays.stream(sortArrayByParity(input)).forEach(System.out::println);
  }

  private static int[] sortArrayByParity1(int[] A)
  {
    int[] result = new int[A.length];
    int index = 0;
    for (int i = 0; i < A.length; i++)
    {
      if (A[i] % 2 == 0)
      {
        result[index] = A[i];
        index = index + 1;
        A[i] = -1;
      }
    }

    for (int value : A)
    {
      if (value != -1)
      {
        result[index] = value;
        index = index + 1;
      }
    }
    return result;
  }

  private static int[] sortArrayByParity(int[] A)
  {
    int i = 0;
    int j = A.length - 1;
    while (i < j)
    {
      if (A[i] % 2 != 0 && A[j] % 2 == 0)
      {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
      }
      if (A[i] % 2 == 0)
      {
        i = i + 1;
      }

      if (A[j] % 2 != 0)
      {
        j = j - 1;
      }

    }
    return A;
  }

}

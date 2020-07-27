package com.explore.arrays;

import java.util.Arrays;

public class SortedSquareArray
{
  public static void main(String[] args)
  {
    int[] input = {-4, -1, 0, 3, 10};
    System.out.println(Arrays.toString(sortedSquares(input)));
  }

  private static int[] sortedSquares1(int[] A)
  {
    int[] result = new int[A.length];
    Arrays.fill(result, Integer.MAX_VALUE);
    for (int i = 0; i < A.length; i++)
    {
      int res = A[i] * A[i];

      for (int j = 0; j <= i; j++)
      {
        int temp = result[j];
        if (res < result[j])
        {
          result[j] = res;
          res = temp;
        }
      }
    }
    return result;
  }

  private static int[] sortedSquares(int[] A)
  {
    int[] result = new int[A.length];
    int positiveStartIndex = -1;
    for (int i = 0; i < A.length; i++)
    {
      if (A[i] >= 0)
      {
        positiveStartIndex = i;
        break;
      }
    }

    if (positiveStartIndex != -1)
    {
      int[] resultPositive = new int[A.length - positiveStartIndex];
      int count = 0;
      int i = positiveStartIndex;
      while (i < A.length)
      {
        resultPositive[count] = A[i] * A[i];
        count = count + 1;
        i++;
      }
      int[] resultNegative = new int[positiveStartIndex];
      count = 0;
      int j = positiveStartIndex - 1;
      while (j >= 0)
      {
        resultNegative[count] = A[j] * A[j];
        count = count + 1;
        j--;
      }
      i = 0;
      j = 0;
      int k = 0;
      while (i <= resultNegative.length - 1 && j <= resultPositive.length - 1)
      {
        if (resultNegative[i] < resultPositive[j])
        {
          result[k] = resultNegative[i];
          i = i + 1;
        }
        else
        {
          result[k] = resultPositive[j];
          j = j + 1;
        }
        k = k + 1;
      }
      while (i <= resultNegative.length - 1)
      {
        result[k] = resultNegative[i];
        i++;
        k++;
      }

      while (j <= resultPositive.length - 1)
      {
        result[k] = resultPositive[j];
        j++;
        k++;
      }
    }
    else
    {
      for (int i = 0; i < A.length; i++)
      {
        result[i] = A[i] * A[i];
      }
    }

    return result;
  }
}

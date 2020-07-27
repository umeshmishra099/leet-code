package com.explore.arrays;

import java.util.Arrays;

public class DuplicateZeros
{
  public static void main(String[] args)
  {
    int[] input = {1, 0, 2, 3, 0, 4, 5, 0};
    duplicateZeros(input);
    Arrays.stream(input).forEach(System.out::println);
  }

  public static void duplicateZeros1(int[] arr)
  {
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] == 0 && i + 1 < arr.length)
      {
        for (int j = arr.length - 1; j > i + 1; j--)
        {
          arr[j] = arr[j - 1];
        }
        i++;
        arr[i] = 0;
      }
    }
  }

  public static void duplicateZeros(int[] arr)
  {
    int zeroCount = 0;
    int inputLength = arr.length - 1;
    for (int i = 0; i <= inputLength - zeroCount; i++)
    {
      int value = arr[i];
      if (value == 0)
      {
        if (i == inputLength - zeroCount)
        {
          arr[inputLength] = 0;
          inputLength = inputLength - 1;
          break;
        }
        zeroCount = zeroCount + 1;
      }
    }

    int lastElement = inputLength - zeroCount;

    for (int i = lastElement; i >= 0; i--)
    {
      if (arr[i] == 0)
      {
        arr[i + zeroCount] = 0;
        zeroCount--;
        arr[i + zeroCount] = 0;
      }
      else
      {
        arr[i + zeroCount] = arr[i];
      }
    }

  }
}

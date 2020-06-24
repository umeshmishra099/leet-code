package com.learning.subsetsum;

public class Solution
{
  public static void main(String[] args)
  {
    int[] input = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 100
    };
    System.out.println(subSetSum(input, input.length, 99));
    System.out.println(subsetSum(input, 100));
  }

  private static boolean subSetSum(int[] nums, int n, int sum)
  {
    boolean[][] result = new boolean[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++)
    {
      for (int j = 0; j < sum + 1; j++)
      {
        if (i == 0)
        {
          result[i][j] = false;
        }
        if (j == 0)
        {
          result[i][j] = true;
        }
      }
    }

    for (int i = 1; i < n + 1; i++)
    {
      for (int j = 1; j < sum + 1; j++)
      {
        if (nums[i - 1] <= j)
        {
          result[i][j] = result[i - 1][j - nums[i - 1]] || result[i - 1][j];
        }
        else
        {
          result[i][j] = result[i - 1][j];
        }
      }
    }
    return result[n][sum];
  }

  public static int subsetSum(int[] A, int sum)
  {
    int n = A.length;
    int[][] T = new int[n + 1][sum + 1];

    for (int i = 0; i <= n; i++)
    {
      T[i][0] = 1;
    }

    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= sum; j++)
      {
        if (A[i - 1] > j)
        {
          T[i][j] = T[i - 1][j];
        }
        else
        {
          T[i][j] = T[i - 1][j] + T[i - 1][j - A[i - 1]];
        }
      }
    }
    return T[n][sum];
  }

}

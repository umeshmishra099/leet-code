package com.learning.equlapartitionsum;

class Solution
{

  public static void main(String[] args)
  {
    int[] input = {1,1};  /*{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 100
    };*/
    System.out.println(canPartition(input));
  }

  public static boolean canPartition(int[] nums)
  {
    int sum = 0;
    for (int num : nums)
    {
      sum = sum + num;
    }
    if (sum % 2 != 0)
    {
      return false;
    }
    else
    {
      int halfSum = sum / 2;
      return subSetSum(nums, nums.length, halfSum);
    }
  }

  private static boolean subSetSum(int[] nums, int n, int sum)
  {
    boolean[][] result = new boolean[n + 1][sum + 1];
    for (int i = 0; i < sum + 1; i++)
    {
      result[0][i] = false;
    }
    for (int i = 0; i < n + 1; i++)
    {
      result[i][0] = true;
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
}

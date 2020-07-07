package com.product;

public class MaximumProductSubarray
{
  public static void main(String[] args)
  {
    int[] input = {2, 3, -2, 4};
    int[] input1 = {0, 2};
    int[] input2 = {-2, 0, -1};
    System.out.println(maxProduct(input));
    System.out.println(maxProduct(input1));
    System.out.println(maxProduct(input2));
  }

  public static int maxProduct(int[] nums)
  {
    if (nums.length == 0)
    {
      return 0;
    }
    int globalMax = nums[0];
    int current_Max = nums[0];
    int current_Min = nums[0];
    for (int i = 1; i < nums.length; i++)
    {
      int temp_Max = current_Max;
      current_Max = Math.max(Math.max(current_Max * nums[i], current_Min * nums[i]), nums[i]);
      current_Min = Math.min(Math.min(temp_Max * nums[i], current_Min * nums[i]), nums[i]);
      if (current_Max > globalMax)
      {
        globalMax = current_Max;
      }
    }
    return globalMax;
  }
}

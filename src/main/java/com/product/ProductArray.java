package com.product;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductArray
{
  public static void main(String[] args)
  {
    int[] input = {1, 2, 3, 4};
    System.out.println(productExceptSelfS1(input));
  }

  public static int[] productExceptSelf(int[] nums)
  {
    int[] result = new int[nums.length];
    Arrays.fill(result, 1);

    for (int i = 0; i < nums.length; i++)
    {
      int innerResult = 1;
      for (int j = 0; j < nums.length; j++)
      {
        if (i != j)
        {
          innerResult = innerResult * nums[j];
        }
      }
      result[i] = innerResult;
    }
    return result;
  }

  public static int[] productExceptSelfS1(int[] nums)
  {
    int[] result = new int[nums.length];
    result[0] = 1;
    for (int i = 1; i < nums.length; i++)
    {
      result[i] = result[i - 1] * nums[i - 1];
    }

    int tempProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--)
    {
      result[i] = result[i] * tempProduct;
      tempProduct = tempProduct * nums[i];
    }
    return result;
  }
}

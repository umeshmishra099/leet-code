package com.rainwater;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater
{
  public static void main(String[] args)
  {
    int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(input));
  }

  public static int trap(int[] height)
  {
    int result = 0;
    if (height.length <= 2)
    {
      return 0;
    }
    int maxHeight = height[0];
    int maxIndex = 0;
    for (int i = 1; i < height.length; i++)
    {
      int value = height[i];
      if (maxHeight < value)
      {
        maxHeight = value;
        maxIndex = i;
      }
    }
    int left_Max = height[0];
    for (int i = 0; i < maxIndex; i++)
    {
      if (left_Max < height[i])
      {
        left_Max = height[i];
      }
      else
      {
        result = result + left_Max - height[i];
      }
    }

    int right_Max = height[height.length - 1];
    for (int i = height.length - 2; i > maxIndex; i--)
    {
      if (right_Max < height[i])
      {
        right_Max = height[i];
      }
      else
      {
        result = result + right_Max - height[i];
      }
    }

    return result;
  }
}

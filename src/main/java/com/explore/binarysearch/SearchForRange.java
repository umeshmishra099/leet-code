package com.explore.binarysearch;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class SearchForRange
{
  public static void main(String[] args)
  {
    int[] input = {5, 7, 7, 8, 8, 10};
    Arrays.stream(searchRange(input, 8)).forEach(System.out::println);
  }

  private static int[] searchRange(int[] nums, int target)
  {
    int[] result = new int[2];
    int leftIndex = getLeftIndex(nums, target);
    if (leftIndex == -1)
    {
      result[0] = -1;
      result[1] = -1;
      return result;
    }
    else
    {
      result[0] = leftIndex;
      result[1] = leftIndex;
    }
    result[1] = getRightIndex(nums, target);
    return result;
  }

  private static int getLeftIndex(int[] nums, int target)
  {
    int index = -1;
    int left = 0;
    int right = nums.length - 1;
    int middle = 0;
    while (left <= right)
    {
      middle = left + (right - left) / 2;
      if (nums[middle] >= target)
      {
        right = middle - 1;
      }
      else
      {
        left = middle + 1;
      }
    }
    if (nums[left] == target)
    {
      index = middle;
    }
    return index;
  }

  private static int getRightIndex(int[] nums, int target)
  {
    int index = -1;
    int left = 0;
    int right = nums.length - 1;
    int middle = 0;
    while (left <= right)
    {
      middle = left + (right - left) / 2;
      if (nums[middle] <= target)
      {
        left = middle + 1;
      }
      else
      {
        right = middle - 1;
      }
    }
    if (nums[right] == target)
    {
      index = right;
    }
    return index;
  }

}

package com.explore.binarysearch;

public class BinarySearchOnRotatedArray
{
  public static void main(String[] args)
  {
    int[] input = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(search(input, 0));
  }

  private static int search(int[] nums, int target)
  {
    if (nums ==null || nums.length ==0) return -1;
    int left = 0;
    int right = nums.length - 1;
    int middle;
    while (left < right)
    {
      middle = left + (right - left) / 2;
      if (nums[middle] > nums[right])
      {
        left = middle + 1;
      }
      else
      {
        right = middle;
      }
    }
    int start = left;
    left = 0;
    right = nums.length - 1;
    if (target >= nums[start] && target <= nums[right])
    {
      left = start;
    }
    else
    {
      right = start;
    }

    while (left <= right)
    {
      middle = left + (right - left) / 2;
      if (nums[middle] == target)
      {
        return middle;
      }
      else if (nums[middle] < target)
      {
        left = middle + 1;
      }
      else
      {
        right = middle - 1;
      }
    }
    return -1;
  }
}

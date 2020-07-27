package com.explore.binarysearch;

public class BinarySearch
{
  public static void main(String[] args)
  {
    int[] input = {-1,0,3,5,9,12};
    System.out.println(search(input, 2));
  }

  private static int search(int[] nums, int target)
  {
    int left = 0;
    int right = nums.length - 1;
    int middle;
    while (left <= right)
    {
      middle = left + (right - left) / 2;
      if (nums[middle] == target)
      {
        return middle;
      }
      else if (nums[middle] > target)
      {
        right = middle-1;
      }
      else
      {
        left = middle+1;
      }
    }
    return -1;
  }
}

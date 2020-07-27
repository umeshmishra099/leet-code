package com.explore.binarysearch;

public class FindMinimumRotatedSortedArray
{
  public static void main(String[] args)
  {
    int[] input = {4, 5, 6, 7, -1, 1, 2};
    System.out.println(findMin(input));
  }

  private static int findMin(int[] nums)
  {
    int left = 0;
    int right = nums.length - 1;
    int middle;
    while (left < right) {
      middle = left + (right-left)/2;
      if (nums[middle] > nums[right]) {
        left = middle+1;
      } else {
        right = middle;
      }
    }
    return nums[left];
  }
}

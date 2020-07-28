package com.explore.arrays;

import java.util.Arrays;

public class MergeTwoSortedArray
{
  public static void main(String[] args)
  {
    int[] input1 = {1, 2, 3, 0, 0, 0};
    int[] input2 = {2, 5, 6};
    merge(input1, 3, input2, input2.length);
    Arrays.stream(input1).forEach(System.out::println);
  }

  private static void merge(int[] nums1, int m, int[] nums2, int n)
  {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (i >= 0 && j >= 0)
    {
      if (nums1[i] > nums2[j])
      {
        nums1[k] = nums1[i];
        i = i - 1;
      }
      else
      {
        nums1[k] = nums2[j];
        j = j - 1;
      }
      k = k - 1;
    }

    while (j >= 0)
    {
      nums1[k] = nums2[j];
      j = j - 1;
      k = k - 1;
    }

  }
}

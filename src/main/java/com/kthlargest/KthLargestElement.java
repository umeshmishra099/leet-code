package com.kthlargest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement
{
  public static void main(String[] args)
  {
    int[] input = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest1(input, 2));
    int[] input1 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    System.out.println(findKthLargest1(input1, 4));
  }

  public static int findKthLargest1(int[] nums, int k)
  {
    PriorityQueue<Integer> heapMin = new PriorityQueue<>();
    for (int num : nums)
    {
      heapMin.add(num);
      if (heapMin.size() > k) {
        heapMin.remove();
      }
    }

    return heapMin.remove();
  }

  public static int findKthLargest(int[] nums, int k)
  {
    Arrays.sort(nums);
    return nums[k];
  }
}

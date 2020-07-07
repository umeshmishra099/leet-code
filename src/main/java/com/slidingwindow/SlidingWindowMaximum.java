package com.slidingwindow;

import java.util.*;

public class SlidingWindowMaximum
{
  public static void main(String[] args)
  {
    int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
    Arrays.stream(maxSlidingWindow(input, 3)).forEach(System.out::println);
  }

  public static int[] maxSlidingWindow(int[] nums, int k)
  {
    int[] result = new int[nums.length - k + 1];
    Queue<Integer> priorityQueue =  new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < k; i++)
    {
      priorityQueue.add(nums[i]);
    }
    result[0]  = priorityQueue.peek();
    for (int i = k; i < nums.length; i++)
    {
      priorityQueue.remove(nums[i-k]);
      priorityQueue.add(nums[i]);
      result[i-k+1] = priorityQueue.peek();
    }
    return result;
  }

}

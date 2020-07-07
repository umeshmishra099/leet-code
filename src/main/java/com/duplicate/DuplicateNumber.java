package com.duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class DuplicateNumber
{
  public static void main(String[] args)
  {
    int[] input = {1, 3, 4, 2, 2};
    System.out.println(findDuplicate(input));
  }

  public static int findDuplicate(int[] nums)
  {
      Set<Integer> values = new HashSet<>();
    for (int num : nums)
    {
      if (values.contains(num))
      {
        return num;
      }
      else
      {
        values.add(num);
      }
    }
    return -1;
  }
}

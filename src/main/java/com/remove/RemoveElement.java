package com.remove;

public class RemoveElement
{
  public static void main(String[] args)
  {
    int[] input = {0, 1, 2, 2, 3, 0, 4, 2};
    System.out.println(removeElement(input, 2));
    for (int n : input)
    {
      System.out.print(n + " ");
    }
  }

  private static int removeElement(int[] nums, int val)
  {
    int result = 0;
    for (int i = 0; i < nums.length; i++)
    {
      if (nums[i] != val)
      {
        nums[result] = nums[i];
        result = result + 1;
      }
    }
    return result;
  }
}

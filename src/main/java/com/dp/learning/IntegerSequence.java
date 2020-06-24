package com.dp.learning;

public class IntegerSequence
{
  public static void main(String[] args)
  {
    int [] input = {2,3,4,5,6,7};
    System.out.println(validSequence(input, input.length));
  }

  private static boolean validSequence(int[] input, int length)
  {
    if (length <= 1) {
      return true;
    }
    return validSequence(input , length-1);
  }
}

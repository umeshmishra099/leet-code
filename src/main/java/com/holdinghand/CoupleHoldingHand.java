package com.holdinghand;

import java.util.HashMap;
import java.util.Map;

public class CoupleHoldingHand
{
  public static void main(String[] args)
  {
    // int[] input = {3, 2, 0, 1};
    //System.out.println(minSwapsCouples(input));
     int[] input2 = {0,2,4,6,7,1,3,5};
     System.out.println(minSwapsCouples(input2));
    System.out.println((int)Math.ceil(1.4));
  }

  public static int minSwapsCouples(int[] row)
  {
    Map<Integer, Integer> couples = new HashMap<>();
    int i = 0;
    while (i < row.length)
    {
      int value = row[i];
      i = i + 1;
      couples.put(value, row[i]);
      i = i + 1;
    }
    int result = 0;
    for (Integer key : couples.keySet())
    {
      if (key - couples.get(key) == 1 || couples.get(key) - key == 1)
      {
        result = result + 1;
      }
    }
    return couples.size() == result ? 0 : (int)Math.ceil(((double)couples.size() - result) / 2);
  }

}

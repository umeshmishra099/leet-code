package com.topkthfreq;

import java.util.*;

public class KClosestPointToOrigin
{
  public static void main(String[] args)
  {
    int[][] input = {{1, 3}, {-2, 2}};
    int[][] input1 = {{3,2},{7,7},{9,-9},{4,-6},{-3,-6}}; // {{3,3},{5,-1},{-2,4}};
   // System.out.println(kClosest(input, 1));
    System.out.println(kClosest(input1, 4));
  }

  public static int[][] kClosest(int[][] points, int K)
  {
    Map<Integer, Integer> indexDistance = new HashMap<>();
    for (int i = 0; i < points.length; i++)
    {
      int value = points[i][0] * points[i][0] + points[i][1] * points[i][1];
      indexDistance.put(i, value);
    }
    // sort base on values;
    PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
            (o1, o2) -> o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o2.getValue() - o1.getValue());

    for (Map.Entry<Integer, Integer> entry : indexDistance.entrySet())
    {
      priorityQueue.offer(entry);
      if (priorityQueue.size() > K)
      {
        priorityQueue.poll();
      }
    }
    int[][] result = new int[K][2];
    int count = 0;
    while (!priorityQueue.isEmpty())
    {
      final Integer key = priorityQueue.poll().getKey();
      result[count][0] = points[key][0];
      result[count][1] = points[key][1];
      count=count+1;
    }
    return result;
  }
}

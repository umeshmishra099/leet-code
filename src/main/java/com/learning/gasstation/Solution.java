package com.learning.gasstation;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 *
 * Note:
 *
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * Example 1:
 *
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 */
public class Solution
{
  public static void main(String[] args)
  {
    int[] gas = {1, 2, 3, 4, 5};
    int[] cost = {3, 4, 5, 1, 2};

    System.out.println(canCompleteCircuit(gas, cost));

  }

  private static int canCompleteCircuit(int[] gas, int[] cost)
  {
    int start = 0;
    int total = 0;
    int tank = 0;
    for (int i = 0; i < gas.length; i++)
    {
      if ((tank = tank + gas[i] - cost[i]) < 0)
      {
        start = i + 1;
        total += tank;
        tank = 0;
      }
    }
    return (total + tank < 0) ? -1 : start;
  }
}

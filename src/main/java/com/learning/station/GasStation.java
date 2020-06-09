package com.learning.station;

public class GasStation
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
    //if car fails at 'start', record the next station
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

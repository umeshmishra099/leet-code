package com.explore.arrays;

import java.util.Arrays;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * <p>
 * Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
 * <p>
 * Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Current array : [1,1,4,2,1,3]
 * Target array  : [1,1,1,2,3,4]
 * On index 2 (0-based) we have 4 vs 1 so we have to move this student.
 * On index 4 (0-based) we have 1 vs 3 so we have to move this student.
 * On index 5 (0-based) we have 3 vs 4 so we have to move this student.
 * Example 2:
 * <p>
 * Input: heights = [5,1,2,3,4]
 * Output: 5
 * Example 3:
 * <p>
 * Input: heights = [1,2,3,4,5]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightCheck
{
  public static void main(String[] args)
  {
    int[] input = {1, 1, 4, 2, 1, 3};
    System.out.println(heightChecker(input));
  }

  private static int heightChecker(int[] heights)
  {
    int[] originalHeight = new int[heights.length];
    System.arraycopy(heights, 0, originalHeight, 0, originalHeight.length);
    Arrays.sort(heights);

    int result = 0;
    for (int i = 0; i < heights.length; i++)
    {
      if (heights[i] != originalHeight[i])
      {
        result = result + 1;
      }
    }
    return result;
  }
}

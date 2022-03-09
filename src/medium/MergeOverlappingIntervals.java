package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 Write a function that takes in a non-empty array of arbitrary intervals,
 merges any overlapping intervals, and returns the new intervals in no
 particular order.

 Each interval is an array of two integers, with interval[0] as the start of the interval and
 interval[1] as the end of the interval.

 Note that back-to-back intervals aren't considered to be overlapping. For
 example, [1, 5] and [6,7] aren't overlapping;
 however, [1, 6] and [6, 7] are indeed overlapping.

 Also note that the start of any particular interval will always be less than
 or equal to the end of that interval.

 Sample Input
 intervals = [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]

 Sample Output
 [[1, 2], [3, 8], [9, 10]]
 // Merge the intervals [3, 5], [4, 7], and [6, 8].
 // The intervals could be ordered differently.
 */
public class MergeOverlappingIntervals {

  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    int[][] sortedIntervals = intervals.clone();
    Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> result = new ArrayList<>();
    result.add(sortedIntervals[0]);
    int j = 0;
    // Write your code here.
    for(int i = 1; i < sortedIntervals.length; i++) {
      if(sortedIntervals[i][0] <= result.get(j)[1]) {
        result.get(j)[1] = Math.max(sortedIntervals[i][1], result.get(j)[1]);
      } else {
        result.add(sortedIntervals[i]);
        j++;
      }
    }
    int [][] resultArray = new int[result.size()][2];
    return result.toArray(resultArray);
  }

  public static void main(String[] args) {
    //int [][] input = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
    //int [][] input = {{100, 105}, {1, 104}};
    int [][] input = {{1, 22}, {-20, 30}};
    MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();
    mergeOverlappingIntervals.mergeOverlappingIntervals(input);
  }

}

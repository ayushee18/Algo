package medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 You're given an array of integers where each integer represents a jump of its
 value in the array. For instance, the integer 2 represents a jump
 of two indices forward in the array; the integer 3 represents a
 jump of three indices backward in the array.

 If a jump spills past the array's bounds, it wraps over to the other side. For
 instance, a jump of -1 at index 0 brings us to the last index in
 the array. Similarly, a jump of 1 at the last index in the array brings us to
 index 0.

 Write a function that returns a boolean representing whether the jumps in the
 array form a single cycle. A single cycle occurs if, starting at any index in
 the array and following the jumps, every element in the array is visited
 exactly once before landing back on the starting index.

 Sample Input
 array = [2, 3, 1, -4, -4, 2]

 Sample Output
 true
 */
public class SingleCycleCheck {
  // O(n) time and O(n) space
  public static boolean hasSingleCycle(int[] array) {
    Set<Integer> set = new HashSet<>();
    set.add(0);
    for (int i = 0; i < array.length;) {
      i = i + array[i];
      if (i < 0) {
        i = array.length + i % array.length;
      }
      if (i > array.length - 1) {
        i = i % array.length;
      }
      if (set.contains(i)) {
        if (set.size() == array.length && i == 0) {
          return true;
        }
        return false;
      }
      set.add(i);
    }
    return false;
  }

  // Expected sol
  // O(n) time and O(1) space
  public static boolean hasSingleCycleExpectedSol(int[] array) {
    int currIndex = 0;
    int elementsVisited = 0;
    final int STARTING_INDEX = 0;

    while (elementsVisited < array.length) {
      // if elementsVisited < 'elements in array' and it comes back to 1st element means there is a cycle without all
      // elements
      if (elementsVisited > 0 && currIndex == STARTING_INDEX) {
        return false;
      }
      elementsVisited++;
      currIndex = getNxtIdx(currIndex, array);
    }
    return currIndex == 0;
  }

  public static int getNxtIdx(int currIndex, int[] array) {
    int nextIdx = (currIndex + array[currIndex]) % array.length;
    return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
  }

  public static void main(String[] args) {
    System.out.println(hasSingleCycle(new int[] {2, 3, 1, -4, -4, 2}));
  }
}

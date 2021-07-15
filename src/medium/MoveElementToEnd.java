package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 You're given an array of integers and an integer. Write a function that moves
 all instances of that integer in the array to the end of the array and returns
 the array.

 The function should perform this in place (i.e., it should mutate the input
 array) and doesn't need to maintain the order of the other integers.

 Sample Input
 array = [2, 1, 2, 2, 2, 3, 4, 2]
 toMove = 2

 Sample Output
 [1, 3, 4, 2, 2, 2, 2, 2]
 */
public class MoveElementToEnd {

  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    // Write your code here.
    int low = 0, high = array.size() - 1;
    while (low < high) {
      while(low < high && array.get(high) == toMove) {
        high--;
      }
      if(low < array.size() && high >= 0 && array.get(low) == toMove) {
        Collections.swap(array, low, high);
      }
      low++;
    }
    return array;
  }

  public static void main(String[] args) {
    Integer [] array = {4, 1, 3, 2, 2, 2, 2, 2};
    List<Integer> list = Arrays.asList(array);
    List<Integer> result = moveElementToEnd(list, 2);

    for(Integer i: result) {
      System.out.print(i + " ");
    }

  }

}

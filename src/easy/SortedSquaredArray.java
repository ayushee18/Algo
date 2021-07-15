package easy;

/**
 *
 Write a function that takes in a non-empty array of integers that are sorted
 in ascending order and returns a new array of the same length with the squares
 of the original integers also sorted in ascending order.

 Sample Input
  array = [1, 2, 3, 5, 6, 8, 9]
 Sample Output
  [1, 4, 9, 25, 36, 64, 81]
 */
public class SortedSquaredArray {

  public static int[] sortedSquaredArray(int[] array) {
    int [] result = new int [array.length];
    int low = 0, high = array.length - 1, index = array.length - 1;
    while (low <= high && index >= 0) {
      int sqLow = array[low] * array[low];
      int sqHigh = array[high] * array[high];
      if(sqLow > sqHigh) {
        result[index] = sqLow;
        low++;
      } else {
        result[index] = sqHigh;
        high--;
      }
      index--;
    }
    return result;
  }

  public static void main(String[] args) {
    int [] array = {1, 2, 3, 5, 6, 8, 9};
    int [] result = sortedSquaredArray(array);
    for(int i : result) {
      System.out.print(i +  " ");
    }
  }
}

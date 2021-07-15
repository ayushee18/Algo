package easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Write a function that takes in a "special" array and returns its product sum.

 A "special" array is a non-empty array that contains either integers or other
 "special" arrays. The product sum of a "special" array is the sum of its
 elements, where "special" arrays inside it are summed themselves and then
 multiplied by their level of depth.

 The depth of a "special" array is how far nested it is. For instance, the
 depth of [] is 1; the depth of the inner array in [[]] is 2; the depth of the innermost array in
 [[[]]] is 3.

 Therefore, the product sum of [x, y] is x + y; the
 product sum of [x, [y, z]] is x + 2 * (y + z); the
 product sum of [x, [y, [z]]] is x + 2 * (y + 3z).

 Sample Input
  array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]

 Sample Output
  12 // calculated as: 5 + 2 + 2 * (7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4)

 */
public class ProductSum {

  public static int productSumUtil(List<Object> array, int level) {
    // Write your code here.
    Integer sum = 0;
    for(int i = 0; i < array.size(); i++) {
      if(array.get(i) instanceof Integer) {
        sum = Integer.sum(sum, level * (int) array.get(i));
      } else {
        sum = Integer.sum(sum, level * productSumUtil((List<Object>) array.get(i), level + 1));
      }
    }
    return sum;
  }

  public static int productSum(List<Object> array) {
    // Write your code here.
    return productSumUtil(array, 1);
  }

  public static void main(String[] args) {
    List<Object> array = new ArrayList<>();
    List<Object> value1 = new ArrayList<>();
    value1.add(7); value1.add(-1);
    List<Object> value2 = new ArrayList<>();
    value2.add(6);
    List<Object> value3 = new ArrayList<>();
    value3.add(-13); value3.add(8);
    value2.add(value3); value2.add(4);
    array.add(5); array.add(2); array.add(value1); array.add(3); array.add(value2);

    System.out.println(productSum(array));
  }
}

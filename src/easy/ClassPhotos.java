package easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 It's photo day at the local school, and you're the photographer assigned to
 take class photos. The class that you'll be photographing has an even number
 of students, and all these students are wearing red or blue shirts. In fact,
 exactly half of the class is wearing red shirts, and the other half is wearing
 blue shirts. You're responsible for arranging the students in two rows before
 taking the photo. Each row should contain the same number of the students and
 should adhere to the following guidelines:

 All students wearing red shirts must be in the same row.
 All students wearing blue shirts must be in the same row.
 Each student in the back row must be strictly taller than the student directly in front of them in the front row.

 You're given two input arrays: one containing the heights of all the students
 with red shirts and another one containing the heights of all the students
 with blue shirts. These arrays will always have the same length, and each
 height will be a positive integer. Write a function that returns whether or
 not a class photo that follows the stated guidelines can be taken.

 Note: you can assume that each class has at least 2 students.

 Sample Input
 redShirtHeights = [5, 8, 1, 3, 4]
 blueShirtHeights = [6, 9, 2, 4, 5]

 Sample Output: true
 */
public class ClassPhotos {

  public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    // Write your code here.
    Collections.sort(redShirtHeights);
    Collections.sort(blueShirtHeights);
    boolean redHeight = false;
    boolean blueHeight = false;
    for(int i = 0; i < redShirtHeights.size(); i++) {
      if(redShirtHeights.get(i) == blueShirtHeights.get(i)) {
        return false;
      } else if(redShirtHeights.get(i) > blueShirtHeights.get(i)) {
        redHeight = true;
      } else {
        blueHeight = true;
      }
    }
    return redHeight ^ blueHeight;
  }

  public static void main(String[] args) {
    ArrayList<Integer> redShirtHeights = new ArrayList<>();
    ArrayList<Integer> blueShirtHeights = new ArrayList<>();
    redShirtHeights.add(1); redShirtHeights.add(3); redShirtHeights.add(2);
    blueShirtHeights.add(2); blueShirtHeights.add(4); blueShirtHeights.add(3);
    System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
  }
}

package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnhappyStudent {

  public static int unhappy_students(List<Integer> heights) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < heights.size(); i++) {
      map.put(heights.get(i), i);
    }
   Collections.sort(heights);
    int low = 0, high = heights.size() - 1;
    while(low < high) {
      //int height =
    }
    return 0;
  }
}

package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StackPair {
  public String value;
  public int count;

  StackPair(String value) {
    this.value = value;
    this.count = 1;
  }
}

public class ArrayBurst {

  public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
    Stack<StackPair> stack = new Stack<>();
    for(int i = 0; i < inputArray.size(); i++) {
      if(stack.isEmpty() || !stack.peek().value.equals(inputArray.get(i))) {
        stack.push(new StackPair(inputArray.get(i)));
      } else {
        int times = stack.peek().count;
        if(times >= burstLength) {
          stack.pop();
        }  else {
          stack.peek().count++;
        }
      }
    }

    List<String> result = new ArrayList<>();

    for (int i = 0; i < stack.size(); i++) {
      StackPair stackPair = stack.get(i);
      int count = stackPair.count;
      while(count != 0) {
        result.add(stackPair.value);
        count--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("a"); list.add("b"); list.add("c"); list.add("d");
    list.add("e"); list.add("e"); list.add("e"); list.add("e");
    list.add("d"); list.add("d"); list.add("c"); list.add("b");
    list.add("f"); list.add("g"); list.add("f");
    List<String> result = getShrunkArray(list, 3);
    for(String s: result) {
      System.out.print(s + " ");
    }
  }
}

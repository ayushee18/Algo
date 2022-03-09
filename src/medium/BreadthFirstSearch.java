package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 You're given a Node class that has a name and an
 array of optional children nodes. When put together, nodes form
 an acyclic tree-like structure.

 Implement the breadthFirstSearch method on the Node class, which takes in an empty array, traverses the tree
 using the Breadth-first Search approach (specifically navigating the tree from
 left to right), stores all of the nodes' names in the input array, and returns
 it.

 Sample Input
 graph =             A
                  /  |  \
                 B   C   D
                / \     / \
               E   F   G   H
                  / \   \
                 I   J   K

 Sample Output
 ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"]
 */
public class BreadthFirstSearch {
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public List<String> breadthFirstSearch(List<String> array) {
      Queue<Node> queue = new LinkedList();
      queue.add(this);
      while(!queue.isEmpty()) {
        List<Node> children = queue.peek().children;
        array.add(queue.poll().name);
        queue.addAll(children);
      }
     return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      this.children.add(child);
      return this;
    }
  }

  public static void main(String[] args) {
    BreadthFirstSearch.Node graph = new Node("A");
    graph.addChild("B").addChild("C").addChild("D");
    graph.children.get(0).addChild("E").addChild("F");
    graph.children.get(2).addChild("G").addChild("H");
    graph.children.get(0).children.get(1).addChild("I").addChild("J");
    graph.children.get(2).children.get(0).addChild("K");
    String[] expected = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
    List<String> inputArray = new ArrayList<String>();
    List<String> result = graph.breadthFirstSearch(new ArrayList<>());
    for (String str: result) {
      System.out.println(str);
    }
  }
}

package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * There's an algorithms tournament taking place in which teams of programmers
 * compete against each other to solve algorithmic problems as fast as possible.
 * Teams compete in a round robin, where each team faces off against all other
 * teams. Only two teams compete against each other at a time, and for each
 * competition, one team is designated the home team, while the other team is the
 * away team. In each competition there's always one winner and one loser; there
 * are no ties. A team receives 3 points if it wins and 0 points if it loses. The
 * winner of the tournament is the team that receives the most amount of points.
 * <p>
 * <p>
 * Given an array of pairs representing the teams that have competed against each
 * other and an array containing the results of each competition, write a
 * function that returns the winner of the tournament. The input arrays are named comptetions and results resuts,
 * respectively  array has elements in the form of [homeTeam, awayTeam] , where each team is a string of at most 30
 * characters representing the name of the team. The results  array
 * contains information about the winner of each corresponding competition in the competitions  array. Specifically,
 * results[i]  denotes the winner of  denotes the winner of competitions[i], where a 1  in the
 * results  array means that the home team in the corresponding
 * competition won and a 0  means that the away team won.
 * <p>
 * It's guaranteed that exactly one team will win the tournament and that each
 * team will compete against all other teams exactly once. It's also guaranteed
 * that the tournament will always have at least two teams.
 * <p>
 * Sample Input
 * competitions = [
 * ["HTML", "C#"],
 * ["C#", "Python"],
 * ["Python", "HTML"],
 * ]
 * results  = [0, 0, 1]
 * <p>
 * Sample Output
 * "Python"
 * // C# beats HTML, Python Beats C#, and Python Beats HTML.
 * // HTML - 0 points
 * // C# -  3 points
 * // Python -  6 points
 */
public class TournamentWinner {

  public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    // Write your code here.
    Map<String, Integer> map = this.score(competitions, results);
    String winner = "";
    int maxScore = 0;
    for (Map.Entry<String, Integer> set : map.entrySet()) {
      if (maxScore < map.get(set.getKey())) {
        maxScore = set.getValue();
        winner = set.getKey();
      }
    }
    return winner;
  }

  public Map<String, Integer> score(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < results.size(); i++) {
      if (results.get(i) == 1) {
        String key2 = competitions.get(i).get(1);
        String key1 = competitions.get(i).get(0);
        if (map.containsKey(key1)) {
          int value = map.get(key1);
          map.put(key1, value + 3);
        } else {
          map.put(key1, 3);
        }
        if (!map.containsKey(key2)) {
          map.put(key2, 0);
        }
      } else {
        String key1 = competitions.get(i).get(1);
        String key2 = competitions.get(i).get(0);
        if (map.containsKey(key1)) {
          int value = map.get(key1);
          map.put(key1, value + 3);
        } else {
          map.put(key1, 3);
        }
        if (!map.containsKey(key2)) {
          map.put(key2, 0);
        }
      }

    }
    return map;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<String>> competitions = new ArrayList<>();
    ArrayList<String> comp1 = new ArrayList<>();
    comp1.add("HTML"); comp1.add("C#");
    ArrayList<String> comp2 = new ArrayList<>();
    comp2.add("C#"); comp2.add("Python");
    ArrayList<String> comp3 = new ArrayList<>();
    comp3.add("Python"); comp3.add("HTML");
    competitions.add(comp1); competitions.add(comp2); competitions.add(comp3);

    ArrayList<Integer> results = new ArrayList<>();
    results.add(0); results.add(0); results.add(1);

    TournamentWinner tournamentWinner = new TournamentWinner();
    System.out.println(tournamentWinner.tournamentWinner(competitions, results));
  }
}

package medium;

/**
 *
 Write a function that takes in two strings and returns the minimum number of
 edit operations that need to be performed on the first string to obtain the
 second string.

 There are three edit operations: insertion of a character, deletion of a
 character, and substitution of a character for another.

 Sample Input
 str1 = "abc"
 str2 = "yabd"

 Sample Output
 2 // insert "y"; substitute "c" for "d"
 */
public class LevenshteinDistance {
  // take min of neighbouring 3 edit values in the array add one to the exiting edit if str[i] != str[j] else just copy
  // diagonal element.
  public static int levenshteinDistance(String str1, String str2) {
    // Write your code here.
    int row = str1.length() + 1; int col = str2.length() + 1;
    int [][] result = new int[row][col];
    for (int i = 0; i < row; i++) {
      result[i][0] = i;
    }
    for (int i = 0; i < col; i++) {
      result[0][i] = i;
    }

    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          result[i][j] = result[i-1][j-1];
        } else {
          result[i][j] = Math.min(result[i-1][j-1], Math.min(result[i-1][j], result[i][j-1])) + 1;
        }
      }
    }
    return result[row-1][col-1];
  }

  public static void main(String[] args) {
    System.out.println(levenshteinDistance("abc", "yabd"));
  }
}

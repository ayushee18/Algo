package test;

public class DecodeWays {

  public int numDecodings(String inputStr) {
    //possiblities[i] means the number of decodes from i to inputStr.length - 1
    if (inputStr == null || inputStr.length() == 0) {
      return 0;
    }
    int[] possiblities = new int[inputStr.length() + 1];
    possiblities[inputStr.length()] = 1;
    possiblities[inputStr.length() - 1] = inputStr.charAt(inputStr.length() - 1) > '0'?1:0;
    for (int i = inputStr.length() - 2; i >=0; i --) {
      if (inputStr.charAt(i) == '0') {
        possiblities[i] = 0;
      }
      else {
        int temp = (inputStr.charAt(i) - '0') * 10 + (inputStr.charAt(i+1) - '0');
        if (temp > 26) {
          possiblities[i] = possiblities[i + 1];
        }
        else {
          possiblities[i] = possiblities[i + 1] + possiblities[i + 2];
        }
      }
    }
    return possiblities[0];
  }

  public static void main(String[] args) {
    DecodeWays decodeWays = new DecodeWays();
    System.out.println(decodeWays.numDecodings("2112"));
  }
}

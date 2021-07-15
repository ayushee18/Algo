package test;

public class TruckCapacity {
  public int optimal_capacity(int[] weights, int k) {
    int low = 0, high = 0;
    for (int i = 0; i < weights.length; i++) {
      low = Math.max(low, weights[i]);
      high += weights[i];
    }

    while (low < high) {
      int mid = (low + high) / 2;
      int truckNumber = 1, cur = 0;
      for (int i = 0; i < weights.length; i++) {
        if (cur + weights[i] > mid) {
          truckNumber += 1;
          cur = 0;
        }
        cur += weights[i];
      }

      if (truckNumber > k) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return low;
  }

  public static void main(String[] args) {
    int [] weights = {1, 2,3,4,5,6,7,8,9,10};
    TruckCapacity truckCapacity = new TruckCapacity();
    System.out.println(truckCapacity.optimal_capacity(weights, 5));
  }
}

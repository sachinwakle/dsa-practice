package KadanesPattern;

public class GFG_Smallest_Sum_Contiguous_Subarray {
    static int smallestSumSubarray(int a[], int size) {
        // your code here
        int minSum = a[0];
        int bestEnding = a[0];
        for (int i = 1; i < size; i++) {
            bestEnding = Math.min((bestEnding + a[i]), a[i]);
            minSum = Math.min(minSum, bestEnding);
        }
        return minSum;
    }

}

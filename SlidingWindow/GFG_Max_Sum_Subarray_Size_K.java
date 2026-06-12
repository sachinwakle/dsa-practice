package SlidingWindow;

public class GFG_Max_Sum_Subarray_Size_K {
    public static int maxSubarraySum(int[] arr, int k) {
        int result = 0, sum = 0;
        int arrLength = arr.length;
        int low = 0;
        int high = k-1;

        for(int i=0;i<=high;i++)
            sum += arr[i];

        while (high<arrLength) {
            result = Math.max(result, sum);
            low++;
            high++;
            sum = sum - arr[low-1];
            if (high==arrLength) {
                break;
            }

            sum = sum + arr[high];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int max = maxSubarraySum(arr, k);
        System.out.println(max);
    }
}

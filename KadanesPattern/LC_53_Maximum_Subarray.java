package KadanesPattern;

public class LC_53_Maximum_Subarray {

    // Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    // Output: 6
    // Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int v1 = nums[0];
        int v2;
        int bestEnding = nums[0];

        for (int i = 1; i < nums.length; i++) {
            v2 = nums[i];
            v1 = bestEnding + v2;
            bestEnding = Math.max(v1, v2);
            maxSum = Math.max(maxSum, bestEnding);
        }
        return maxSum;

    }
}

package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LC_560_Longest_Subarray_Sum_Equals_K {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> prefixIndexMap = new HashMap<>();
        prefixIndexMap.put(0, -1);
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixIndexMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixIndexMap.get(sum - k));
            }

            if (!prefixIndexMap.containsKey(sum)) {
                prefixIndexMap.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LC_560_Longest_Subarray_Sum_Equals_K solution = new LC_560_Longest_Subarray_Sum_Equals_K();
        // int[] nums = {1, -1, 5, -2, 3};
        int[] nums = { 1, 2, 3, 4, -3, -1, 3 };
        int k = 3;
        int result = solution.subarraySum(nums, k);
        System.out.println("Length of the longest subarray with sum " + k + ": " + result);
    }
}

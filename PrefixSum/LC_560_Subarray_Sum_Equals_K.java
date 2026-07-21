package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LC_560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            counter += freqMap.getOrDefault(sum - k, 0);
            freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }
}

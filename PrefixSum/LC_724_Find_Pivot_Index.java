package PrefixSum;

public class LC_724_Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int prefix = 0;
        int suffix;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                prefix = prefix + nums[i - 1];
            }

            suffix = totalSum - nums[i] - prefix;

            if (suffix == prefix) {
                return i;
            }
        }
        return -1;
    }
}

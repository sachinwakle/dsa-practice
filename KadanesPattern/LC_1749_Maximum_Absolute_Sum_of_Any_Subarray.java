package KadanesPattern;

public class LC_1749_Maximum_Absolute_Sum_of_Any_Subarray {
    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = Math.abs(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            min = Math.min(min + nums[i], nums[i]);
            result = Math.max(result, Math.max(Math.abs(max), Math.abs(min)));
        }

        return result;
    }

}

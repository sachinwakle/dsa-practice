package SlidingWindow.VariableWindow;

public class LC_209_Minimum_Size_Subarray_Sum {
    // My version
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[0];
        int count = 1;

        while (right < len && left <= right) {
            if (sum >= target) {
                min = Math.min(min, count);
                if (left == right) {
                    left++;
                    right++;
                    sum = sum - nums[left - 1];
                    if (right >= len) {
                        break;
                    }
                    sum = sum + nums[right];
                } else {
                    left++;
                    count = count - 1;
                    sum = sum - nums[left - 1];
                }
            } else if (sum < target) {
                right++;
                if (right >= len) {
                    break;
                }
                sum = sum + nums[right];
                count = count + 1;
            } else {
                left++;
                count = count - 1;
                sum = sum - nums[left - 1];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // Better Version
    public static int minSubArrayLenV2(int target, int[] nums){
        int left = 0, right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (right<nums.length) {
            sum = sum + nums[right];
            while (sum>=target) {
                min = Math.min(min, (right-left+1));
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        int result = minSubArrayLenV2(target, nums);
        System.out.println(result);
    }
}

package TwoPointers;

import java.util.Arrays;

public class LC_16_3Sum_Closest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        int min = 999999;
        int sum = 0;
        int minSum = 0;
        while (i < len - 2) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                sum = nums[left] + nums[right] + nums[i];
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    minSum = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            i++;

        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -1,2,1,-4 };
        int target = 1;
        int result = threeSumClosest(nums, target);
        System.out.println(result);

    }
}

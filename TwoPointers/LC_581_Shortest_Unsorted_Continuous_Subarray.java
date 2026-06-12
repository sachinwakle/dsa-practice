package TwoPointers;

public class LC_581_Shortest_Unsorted_Continuous_Subarray {

    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int start = -1;
        int end = -2;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            while (nums[i] > nums[j] && j < nums.length) {
                if (start == -1) {
                    start = i;
                }
                end = j;
                j++;
            }
            if (j >= nums.length) {
                break;
            }
            i = j;
            j++;
        }

        return end - start + 1;

    }

     public static int findUnsortedSubarrayV2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int start = -1;
        int end = -1;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
            i++;
        }

        int j = nums.length - 1;
        while (j > 0) {
            if (nums[j - 1] > nums[j]) {
                end = j;
                break;
            }
            j--;
        }

        if (start == -1 && end == -1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int k = start; k <= end; k++) {
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }

        int a = -1;
        for (int k = 0; k <= start; k++) {
            if (min < nums[k]) {
                a = k;
                break;
            }
        }

        int b = -1;
        for (int k = nums.length - 1; k >= end; k--) {
            if (max > nums[k]) {
                b = k;
                break;
            }
        }

        return b - a + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2,6,4,8,10,9,15 };
        int res = findUnsortedSubarrayV2(nums);
        System.out.println(res);
    }
}
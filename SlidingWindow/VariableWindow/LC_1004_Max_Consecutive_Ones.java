package SlidingWindow.VariableWindow;

public class LC_1004_Max_Consecutive_Ones {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        int oneCounter = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                oneCounter++;
            }
            int wlen = right - left + 1;
            int diff = wlen - oneCounter;
            while (diff > k) {
                if (nums[left] == 1) {
                    oneCounter--;
                }
                left++;
                wlen = right - left + 1;
                diff = wlen - oneCounter;
            }
            max = Math.max(max, (right - left + 1));
        }
        return max;
    }
}

package TwoPointers;

public class LC_189_Rotate_Array {
    // time limit exceeds error
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int rot = k % len;

        for (int r = 1; r <= rot; r++) {
            int temp = nums[len - 1];
            int i = len - 1;
            while (i > 0) {
                nums[i] = nums[i - 1];
                i--;
            }
            nums[i] = temp;
        }

    }

    public void rotateV2(int[] nums, int k) {
        int len = nums.length;
        int rot = k % len;
        int[] arr = new int[rot];
        int j = 0;
        for (int i = len - rot; i < len; i++) {
            arr[j] = nums[i];
            j++;
        }

        int i = len - 1;
        while (i - rot >= 0) {
            nums[i] = nums[i - rot];
            i--;
        }

        for (int index = 0; index < arr.length; index++) {
            nums[index] = arr[index];
        }
    }

    public void rotateV3(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        reverse(nums, left, right);

        int len = nums.length;
        int r = k % len;

        left = 0;
        right = r - 1;
        reverse(nums, left, right);

        left = r;
        right = len - 1;
        reverse(nums, left, right);
    }

    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

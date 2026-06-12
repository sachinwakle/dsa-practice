package TwoPointers;

public class LC_713_Subarray_Product_Less_Than_K {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int counter = 0;
        boolean isEligibleWin = true;
        long mainpProduct = 1;

        for (int windowSize = 1; windowSize <= nums.length; windowSize++) {
            if (isEligibleWin) {
                isEligibleWin = false;
            } else {
                break;
            }
            int left = 0;
            int right = windowSize - 1;

            mainpProduct = mainpProduct * nums[right];
            long product = mainpProduct;

            while (right < nums.length) {
                if (product < k) {
                    counter++;
                    isEligibleWin = true;
                }
                product = product / nums[left];
                left++;
                right++;
                if (right < nums.length) {
                    product = product * nums[right];
                }

            }
        }
        return counter;
    }

    public static int numSubarrayProductLessThanKV2(int[] nums, int k) {
        int counter = 0;
        long product = 1;
        int left = 0;
        int right = 0;
        for (right = 0; right < nums.length; right++) {
            product = product * nums[right];
            while (product >= k) {
                product = product / nums[left];
                left++;
            }
            counter = counter + (right - left + 1);

        }

        return counter;

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3 };
        int k = 19;
        int res = numSubarrayProductLessThanKV2(nums, k);
        System.out.println(res);

    }
}

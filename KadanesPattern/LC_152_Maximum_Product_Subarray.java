package KadanesPattern;

public class LC_152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int bestMax = nums[0];
        int bestMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int v1 = nums[i];
            int v2 = bestMax * nums[i];
            int v3 = bestMin * nums[i];
            bestMax = Math.max(v1, Math.max(v2, v3));
            bestMin = Math.min(v1, Math.min(v2, v3));
            maxProduct = Math.max(maxProduct, Math.max(bestMax, bestMin));

        }
        return maxProduct;
    }
}

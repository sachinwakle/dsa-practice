package TwoPointers;

public class LC_42_Trapping_Rain_Water {
    public int trap(int[] height) {
        int maxHeight = Integer.MIN_VALUE;
        int maxHeightIndex = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }

        int totalArea = maxHeight * (height.length - 1);
        int unnecessaryArea = totalArea;

        int maxEle = 0;
        for (int i = 0; i < maxHeightIndex; i++) {
            if (height[i] < maxEle) {
                continue;
            }

            int w = maxHeightIndex - i;
            int area = w * (height[i] - maxEle);
            maxEle = height[i];
            unnecessaryArea = unnecessaryArea - area;
        }

        maxEle = 0;
        for (int i = height.length - 1; i > maxHeightIndex; i--) {
            if (height[i] < maxEle) {
                continue;
            }

            int w = i - maxHeightIndex;
            int area = w * (height[i] - maxEle);
            maxEle = height[i];
            unnecessaryArea = unnecessaryArea - area;
        }

        totalArea = totalArea - unnecessaryArea;

        for (int i = 0; i < height.length; i++) {
            if (i == maxHeightIndex) {
                continue;
            }
            totalArea = totalArea - height[i];
        }

        return totalArea;
    }

    public int trapV2(int[] height) {
        int maxHeight = Integer.MIN_VALUE;
        int maxHeightIndex = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeightIndex = i;
                maxHeight = height[i];
            }
        }

        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeftHeight = Integer.MIN_VALUE;
        int maxRightHeight = Integer.MIN_VALUE;
        while (left < maxHeightIndex || right > maxHeightIndex) {
            if (left < maxHeightIndex) {
                if (height[left] > maxLeftHeight) {
                    maxLeftHeight = height[left];
                }

                water = water + (maxLeftHeight - height[left]);
                left++;
            }

            if (right > maxHeightIndex) {
                if (height[right] > maxRightHeight) {
                    maxRightHeight = height[right];
                }

                water = water + (maxRightHeight - height[right]);
                right--;
            }

        }

        return water;

    }

    // most optimized - canonical two pointers
    public int trapV3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left < right) {
            if (height[left] > leftMax) {
                leftMax = height[left];
            }

            if (height[right] > rightMax) {
                rightMax = height[right];
            }

            if (leftMax < rightMax) {
                water = water + (leftMax - height[left]);
                left++;
            } else {
                water = water + (rightMax - height[right]);
                right--;
            }
        }

        return water;
    }
}

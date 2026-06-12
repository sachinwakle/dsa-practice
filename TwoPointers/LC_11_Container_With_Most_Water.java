package TwoPointers;

public class LC_11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            if (height[left] <= height[right]) {
                int h = height[left];
                int w = right - left;
                int area = h * w;
                max = Math.max(max, area);
                left++;
            } else {
                int h = height[right];
                int w = right - left;
                int area = h * w;
                max = Math.max(max, area);
                right--;
            }
        }
        return max;
    }
}

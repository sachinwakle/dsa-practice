package SlidingWindow.Revision_1;

import java.util.ArrayList;
import java.util.List;

public class LC_658_Find_K_Closest_Elements {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) or O(1) depending on the implementation of the list. If we consider the output * * list as extra space then it is O(k) otherwise it is O(1).
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = k;
        int start = 0;
        int end = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + Math.abs(arr[i] - x);
        }

        while (right <= arr.length) {
            if (sum < minSum) {
                minSum = sum;
                end = left;
                start = right;
            }
            sum = sum - Math.abs(arr[left] - x);
            if (right >= arr.length) {
                break;
            }
            sum = sum + Math.abs(arr[right] - x);
            left++;
            right++;
        }

        List<Integer> list = new ArrayList<>();
        while (end < start) {
            list.add(arr[end]);
            end++;
        }
        return list;
    }


    /**
     * Time Complexity: O(n)
     * Space Complexit:y: O(k) or O(1) depending on the implementation of the list. If we consider the output * list as extra space then it is O(k) otherwise it is O(1).
     */
    public List<Integer> findClosestElementsV2(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}

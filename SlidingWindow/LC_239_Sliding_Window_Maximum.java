package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_239_Sliding_Window_Maximum {

    /**
     * Time Limit Exceeded
     * Time Complexity: O(n*k) where n is the length of the input array and k is the
     * size of the sliding window.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0, right = k;
        int index = 0;

        while (right <= nums.length) {
            result[index++] = getMax(nums, left, right);
            left++;
            right++;
        }
        return result;
    }

    int getMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }



    /**
     * Time Complexity: O(n) where n is the length of the input array.
     * Space Complexity: O(k) where k is the size of the sliding window.
     */
    public int[] maxSlidingWindowV2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0, right = k;
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            addDeq(deque, nums[i]);
        }

        while (right <= nums.length) {
            result[index++] = deque.peekFirst();
            removeDeq(deque, nums[left]);
            left++;
            if (right == nums.length) {
                break;
            }
            addDeq(deque, nums[right]);
            right++;
        }
        return result;
    }

    void addDeq(Deque<Integer> deq, int num) {
        if (deq.isEmpty()) {
            deq.offerLast(num);
            return;
        }
        while (!deq.isEmpty() && deq.peekLast() < num) {
            deq.pollLast();
        }
        deq.offerLast(num);
    }

    void removeDeq(Deque<Integer> deq, int num) {
        if (!deq.isEmpty() && deq.peekFirst() == num) {
            deq.pollFirst();
        }
    }

}
package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int i = 0;
        int length = nums.length;
        Arrays.sort(nums);

        while (i < length - 2) {
            if (i > 0 && (nums[i - 1] == nums[i])) {
                i++;
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                if ((nums[left] + nums[right]) == -(nums[i])) {
                    results.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (nums[left]==nums[left-1] && (left < right)) {
                        left++;
                    }
                    while (nums[right]==nums[right+1]  && (left < right)) {
                        right--; 
                    }
                } else if (nums[left] + nums[right] < -(nums[i])) {
                    left++;
                    // while (nums[left]==nums[left-1] && (left < right)) {
                    //     left++;
                    // }
                } else {
                    right--;
                    // while (nums[right]==nums[right+1] && (left < right)) {
                    //     right--;
                    // }
                }
            }
            i++;
        }
        return results;
    }

    public static void main(String[] args) {
        // int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        int[] nums = new int[] { 1,2,0,1,0,0,0,0 };
        List<List<Integer>> results = threeSum(nums);
        results.forEach(li -> {
            System.out.println(li.toString());
        });
    }
}
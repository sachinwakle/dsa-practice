package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_18_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        while (i < (len - 3)) {
            if (i > 0 && (nums[i] == nums[i - 1])) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < (len - 2)) {
                if (j > i+1 && (nums[j] == nums[j - 1])) {
                    j++;
                    continue;
                }

                int left = j + 1, right = len - 1;
                long newTarget = (long) target - nums[i] - nums[j];

                while (left < right) {
                    if ((nums[left] + nums[right]) == newTarget) {
                        resultList.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left<len && (nums[left] == nums[left - 1])) {
                            left++;
                        }

                        while (right>0 && (nums[right] == nums[right + 1])) {
                            right--;
                        }
                    } else if ((nums[left] + nums[right]) < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
                j++;
            }
            i++;
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        result.forEach(list -> System.out.println(list));
    }
}

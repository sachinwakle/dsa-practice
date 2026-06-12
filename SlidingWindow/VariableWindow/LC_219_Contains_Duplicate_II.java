package SlidingWindow.VariableWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            if (map.containsKey(nums[right])) {
                return true;
            } else {
                map.put(nums[right], right);
            }

            while (map.size() > k) {
                map.remove(nums[left]);
                left++;
            }
            right++;
        }
        return false;
    }

    public boolean containsNearbyDuplicateV2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            if (set.contains(nums[right])) {
                return true;
            } else {
                set.add(nums[right]);
            }

            while (set.size() > k) {
                set.remove(nums[left]);
                left++;
            }
            right++;
        }

        return false;
    }
}

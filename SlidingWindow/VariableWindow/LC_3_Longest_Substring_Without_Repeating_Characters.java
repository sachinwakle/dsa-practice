package SlidingWindow.VariableWindow;

import java.util.*;

public class LC_3_Longest_Substring_Without_Repeating_Characters {
    /**
     * using hashset: my solution
     * Time Complexity: O(n)
     * Space complexity: O(min(M,N))
     */ 
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, (right - left + 1));
        }
        return max;

    }

    // Using Hashmap

    public int lengthOfLongestSubstringV2(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            int k = right - left + 1;
            while (map.size() < k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
                k = right - left + 1;

            }
            max = Math.max(max, (right - left + 1));
        }
        return max;

    }
}

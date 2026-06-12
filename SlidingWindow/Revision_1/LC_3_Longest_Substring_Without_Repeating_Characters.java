package SlidingWindow.Revision_1;

import java.util.*;

public class LC_3_Longest_Substring_Without_Repeating_Characters {

    // s = "abcabcbb"
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = Integer.MIN_VALUE;
        while (right < s.length()) {
            set.add(s.charAt(right));
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            int w = right - left + 1;
            maxLength = Math.max(maxLength, w);
            right++;
        }
        return maxLength;
    }
}

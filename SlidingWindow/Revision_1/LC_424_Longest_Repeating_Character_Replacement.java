package SlidingWindow.Revision_1;

public class LC_424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            map[s.charAt(right) - 'A']++;
            int wlen = right - left + 1;
            int maxCounter = maxCounter(map);
            int diff = wlen - maxCounter;
            while (diff > k) {
                map[s.charAt(left) - 'A']--;
                left++;
                wlen = right - left + 1;
                maxCounter = maxCounter(map);
                diff = wlen - maxCounter;
            }
            maxLength = Math.max(maxLength, (right - left + 1));
        }
        return maxLength;
    }

    int maxCounter(int[] map) {
        int max = Integer.MIN_VALUE;
        for (int i : map) {
            max = Math.max(max, i);
        }
        return max;
    }
}

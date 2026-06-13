package SlidingWindow.Revision_1;

public class LC_76_Minimum_Window_Substring {
    /**
     * Time Complexity: O(M+N) where M is the length of string s and N is the length of string t.
     * Space Complexity: O(1) as we are using a fixed size array of size 128 to store the frequency of characters.
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int counter = t.length();

        int left = 0, right = 0;
        int minWind = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            if (map[s.charAt(right)] > 0) {
                counter--;
            }
            map[s.charAt(right)]--;
            while (counter == 0) {
                int wlen = right - left + 1;
                if (wlen < minWind) {
                    minWind = wlen;
                    start = left;
                }
                map[s.charAt(left)]++;
                if (map[s.charAt(left)] > 0) {
                    counter++;
                }
                left++;
            }
            right++;
        }
        return minWind == Integer.MAX_VALUE ? "" : s.substring(start, start + minWind);
    }
}

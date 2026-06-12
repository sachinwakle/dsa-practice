package SlidingWindow.VariableWindow;

public class LC_567_Permutation_In_String {
    /**
     * Time Complexity: O(s1.length+s2.length) => O(m+n)
     * Space Complexity: O(1)
     * 
     * 
     * 
     * Approach
     * Current:Sliding Window/Hash Table
     * Suggested:Sliding Window/Hash Table
     * Key Idea:Using a sliding window with a frequency map to check for character
     * permutation matches efficiently.
     * Consider:Can you refactor this to use a fixed-size array of 26 instead of 128
     * to squeeze out even more performance?
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int low = 0;
        int counter = s1.length();
        int min = Integer.MAX_VALUE;
        int[] map = new int[128];
        for (int ch : s1.toCharArray()) {
            map[ch]++;
        }

        for (int high = 0; high < s2.length(); high++) {
            if (map[s2.charAt(high)] > 0) {
                counter--;
            }
            map[s2.charAt(high)]--;

            while (counter == 0) {
                int wlen = high - low + 1;
                min = Math.min(min, wlen);
                if (map[s2.charAt(low)] == 0) {
                    counter++;
                }
                map[s2.charAt(low)]++;
                low++;
            }
            if (s1.length() == min) {
                return true;
            }
        }
        return false;
    }

    /**
     * Consider:Can you refactor this to use a fixed-size array of 26 instead of 128
     * to squeeze out even more performance?
     * 
     * Time Complexity: O(s1.length+s2.length) => O(m+n)
     * Space Complexity: O(1)
     * 
     */
    public boolean checkInclusionV2(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int low = 0;
        int counter = s1.length();
        int min = Integer.MAX_VALUE;
        int[] map = new int[26];
        for (int ch : s1.toCharArray()) {
            int i = ch - 'a';
            map[i]++;
        }

        for (int high = 0; high < s2.length(); high++) {
            int i = s2.charAt(high) - 'a';
            if (map[i] > 0) {
                counter--;
            }
            map[i]--;

            while (counter == 0) {
                int wlen = high - low + 1;
                min = Math.min(min, wlen);
                int j = s2.charAt(low) - 'a';
                if (map[j] == 0) {
                    counter++;
                }
                map[j]++;
                low++;
            }
            if (s1.length() == min) {
                return true;
            }
        }
        return false;
    }
}

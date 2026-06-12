package SlidingWindow.VariableWindow;

public class LC_424_Longest_Repeating_Character_Replacement {

    /**
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int characterReplacementV2(String s, int k) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int[] map = new int[128];
        int majorityEle = Integer.MIN_VALUE;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right);
            map[c]++;
            // int major = getMajorElement(map);
            majorityEle = Math.max(majorityEle, map[c]);
            int wlen = right - left + 1;
            int diff = wlen - majorityEle;
            while (diff > k) {
                c = s.charAt(left);
                map[c]--;
                left++;
                majorityEle = Math.max(majorityEle, map[c]);
                wlen = right - left + 1;
                diff = wlen - majorityEle;
            }
            wlen = right - left + 1;
            max = Math.max(max, wlen);
        }
        return max;
    }


    /**
     * Time Complexity: O(n*c)
     * Space Complexity: O(1)
     */

    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int[] map = new int[128];
        for (int right = 0; right < s.length(); right++) {
            map[s.charAt(right)]++;
            int major = getMajorElement(map);
            int wlen = right - left + 1;
            int diff = wlen - major;
            while (diff > k) {
                map[s.charAt(left)]--;
                left++;
                major = getMajorElement(map);
                wlen = right - left + 1;
                diff = wlen - major;
            }
            wlen = right - left + 1;
            max = Math.max(max, wlen);
        }
        return max;
    }

    int getMajorElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            max = Math.max(max, ele);
        }
        return max;
    }
}

package SlidingWindow.VariableWindow;

public class LC_76_Minimum_Window_Substring {
    /**
     * my version
     * Time complexity: O(m*n)
     * Space complexity: O(1)
     */
    public static String minWindowV2(String s, String t) {
        String substring = "";
        int ch = 0;
        int[] map = new int[128];
        int min = Integer.MAX_VALUE;
        while (ch < t.length()) {
            int i = t.charAt(ch);
            map[i]++;
            ch++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            map[s.charAt(right)]--;
            while (isCorrect(map)) {
                int wlen = right - left + 1;
                if (wlen < min) {
                    min = wlen;
                    substring = s.substring(left, right + 1);
                }

                map[s.charAt(left)]++;
                left++;
            }

        }
        return substring;
    }

    static boolean isCorrect(int[] map) {
        for (int i : map) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Better version
     * Time Complexity = O(n+m)
     * Space Complexity = O(1)
     * 
     */
    public static String minWindow(String s, String t) {
        if (s.length()<t.length()) {
            return "";
        }
        int low = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int counter = t.length();
        int[] map = new int[128];
        for (int i : t.toCharArray()) {
            map[i]++;
        }

        for (int high = 0; high < s.length(); high++) {
            if (map[s.charAt(high)] > 0) {
                counter--;
            }
            map[s.charAt(high)]--;
            while (counter == 0) {
                int wlen = high - low + 1;
                if (wlen < min) {
                    min = wlen;
                    start = low;
                }
                if (map[s.charAt(low)] == 0) {
                    counter++;
                }
                map[s.charAt(low)]++;
                low++;
            }
        }

        return min==Integer.MAX_VALUE?"":s.substring(start, start + min);
    }

    public static void main(String[] args) {
        // String s = "ADOBECODEBANC", t = "ABC";
        String s = "a", t = "b";
        // String s = "cabwefgewcwaefgcf", t = "cae";
        String subString = minWindow(s, t);
        System.out.println(subString);

    }
}

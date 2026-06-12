package SlidingWindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class GFG_Longest_Substring_with_K_Uniques {
    public static int longestKSubstr(String s, int k) {
        int max = Integer.MIN_VALUE;
        int low = 0, high = 0;
        Map<Character, Integer> charCounter = new HashMap<>();
        for (high = 0; high < s.length(); high++) {
            charCounter.put(s.charAt(high), charCounter.getOrDefault(s.charAt(high), 0) + 1);
            while (charCounter.size() > k) {
                int counter = charCounter.get(s.charAt(low));
                if (counter == 1) {
                    charCounter.remove(s.charAt(low));
                } else {
                    charCounter.put(s.charAt(low), counter - 1);
                }

                low++;
            }
            max = Math.max(max, (high - low + 1));
        }
        return max == Integer.MIN_VALUE || charCounter.size() != k ? -1 : max;
    }

    // better version
    public static int longestKSubstrV2(String s, int k) {
        int max = Integer.MIN_VALUE;
        int low = 0, high = 0;
        Map<Character, Integer> charCounter = new HashMap<>();
        for (high = 0; high < s.length(); high++) {
            charCounter.put(s.charAt(high), charCounter.getOrDefault(s.charAt(high), 0) + 1);
            while (charCounter.size() > k) {
                charCounter.put(s.charAt(low), charCounter.get(s.charAt(low)) - 1);

                if (charCounter.get(s.charAt(low)) == 0) {
                    charCounter.remove(s.charAt(low));
                }

                low++;
            }
            if (charCounter.size() == k) {
                max = Math.max(max, (high - low + 1));
            }

        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        int result = longestKSubstr(s, k);
        System.out.println(result);
    }
}

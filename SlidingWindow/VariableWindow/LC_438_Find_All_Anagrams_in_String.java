package SlidingWindow.VariableWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_438_Find_All_Anagrams_in_String {
    public List<Integer> findAnagramsV2(String s, String p) {
        Set<Integer> indicesArray = new HashSet<>();
        int low = 0;
        int start = 0;
        int[] map = new int[128];
        for (int i : p.toCharArray()) {
            map[i]++;
        }
        int min = Integer.MAX_VALUE;
        int counter = p.length();
        for (int high = 0; high < s.length(); high++) {
            if (map[s.charAt(high)] > 0) {
                counter--;
            }
            map[s.charAt(high)]--;
            while (counter == 0) {
                int wlen = high - low + 1;
                if (wlen <= min) {
                    min = wlen;
                    start = low;
                }
                if (map[s.charAt(low)] == 0) {
                    counter++;
                }
                map[s.charAt(low)]++;
                low++;
            }
            if (p.length() == min) {
                indicesArray.add(start);
            }
        }
        return new ArrayList<Integer>(indicesArray);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indicesArray = new ArrayList<>();
        int low = 0;
        int[] map = new int[128];
        for (int i : p.toCharArray()) {
            map[i]++;
        }
        int counter = p.length();
        for (int high = 0; high < s.length(); high++) {
            if (map[s.charAt(high)] > 0) {
                counter--;
            }
            map[s.charAt(high)]--;
            if ((high - low + 1) == p.length()) {
                if (counter == 0) {
                    indicesArray.add(low);
                }

                if (map[s.charAt(low)] >= 0) {
                    counter++;
                }
                map[s.charAt(low)]++;
                low++;
            }

        }
        return new ArrayList<Integer>(indicesArray);
    }

}

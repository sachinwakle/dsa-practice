package SlidingWindow.Revision_1;

public class LC_567_Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (char ch : s1.toCharArray()) {
            s1Map[ch - 'a']++;
        }

        int k = s1.length();
        for (int i = 0; i < k; i++) {
            s2Map[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = k;
        while (true) {
            if (checkEqualMap(s1Map, s2Map)) {
                return true;
            }
            s2Map[s2.charAt(left) - 'a']--;
            left++;
            if (right >= s2.length()) {
                break;
            }
            s2Map[s2.charAt(right) - 'a']++;
            right++;

        }
        return false;
    }

    boolean checkEqualMap(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}

package SlidingWindow.VariableWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_30_Substring_With_Concatenation_Of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        int left = 0;
        int fixedLen = words[0].length();
        int wordsLen = words.length * fixedLen;
        int tempLeft = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String i : words) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int counter = words.length;

        for (int right = fixedLen - 1; right < s.length(); right++) {
            tempLeft = right + 1 - fixedLen;
            String substring = s.substring(tempLeft, tempLeft + fixedLen);
            if (map.get(substring) > 0) {
                counter--;
            }
            map.put(substring, map.getOrDefault(substring, 0) - 1);
            if (wordsLen == (right - left + 1)) {
                if (counter == 0) {
                    indices.add(left);
                }

                substring = s.substring(left, left + fixedLen);

                if (map.get(substring) >= 0) {
                    counter++;
                }

                map.put(substring, map.getOrDefault(substring, 0) + 1);
                left++;
            }
        }

        return indices;
    }

      public List<Integer> findSubstringV2(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        int left = 0;
        int fixedLen = words[0].length();
        int wordsLen = words.length * fixedLen;
        int tempLeft = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String i : words) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int counter = words.length;

        for (int right = fixedLen - 1; right < s.length(); right++) {
            tempLeft = right + 1 - fixedLen;
            String substring = s.substring(tempLeft, tempLeft + fixedLen);
            if (map.getOrDefault(substring, 0) > 0) {
                counter--;
            }
            map.put(substring, map.getOrDefault(substring, 0) - 1);
            if (wordsLen == (right - left + 1)) {
                if (counter == 0) {
                    indices.add(left);
                }

                substring = s.substring(left, left + fixedLen);

                if (map.get(substring) >= 0) {
                    counter++;
                }

                map.put(substring, map.getOrDefault(substring, 0) + 1);
                left++;
            }
        }

        return indices;
    }
}

package TwoPointers;

public class LC_1768_Merge_Strings_Alternately {
    public static String mergeAlternately(String word1, String word2) {
        int w1Len = word1.length();
        int w2Len = word2.length();
        char[] mergedWord = new char[w1Len + w2Len];
        int wp = 0;
        int mergedIndex = 0;
        while (wp < w1Len && wp < w2Len) {
            mergedWord[mergedIndex++] = word1.charAt(wp);
            mergedWord[mergedIndex++] = word2.charAt(wp);
            wp++;
        }

        while (wp < w1Len) {
            mergedWord[mergedIndex++] = word1.charAt(wp);
            wp++;
        }

        while (wp < w2Len) {
            mergedWord[mergedIndex++] = word2.charAt(wp);
            wp++;
        }

        return String.valueOf(mergedWord);

    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqrs";
        String mword = mergeAlternately(word1, word2);
        System.out.println(mword);
    }
}

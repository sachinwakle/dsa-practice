package TwoPointers;

public class LC_844_Backspace_String_Compare {
    public boolean backspaceCompare(String s, String t) {
        char[] s2 = new char[s.length()];
        char[] t2 = new char[t.length()];

        int i = 0;
        int y = -1, z = -1;
        while (i < s.length() && i < t.length()) {
            if (s.charAt(i) == '#') {
                y = y - 1;
            } else {
                s2[++y] = s.charAt(i);
            }

            if (t.charAt(i) == '#') {
                z = z - 1;
            } else {
                t2[++z] = t.charAt(i);
            }
            i++;
        }

        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                y = y - 1;
            } else {
                s2[++y] = s.charAt(i);
            }
            i++;
        }

        while (i < t.length()) {
            if (t.charAt(i) == '#') {
                z = z - 1;
            } else {
                t2[++z] = t.charAt(i);
            }
            i++;
        }

        if (y < 0 && z < 0) {
            return true;
        }

        if (y < 0 || z < 0) {
            return false;
        }

        if (y != z) {
            return false;
        }

        int k = Math.min(s2.length, t2.length);

        for (int m = 0; m < k; m++) {
            if (s2[m] != t2[m]) {
                return false;
            }
        }
        return true;
    }

    public static boolean backspaceCompareV2(String s, String t) {
        char[] s2 = new char[s.length()];
        int i = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                i = i == 0 ? 0 : i - 1;
                s2[i] = '\u0000';
            } else {
                s2[i] = ch;
                i++;
            }
        }

        char[] t2 = new char[t.length()];
        int j = 0;

        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                j = j == 0 ? 0 : j - 1;
                t2[j] = '\u0000';
            } else {
                t2[j] = ch;
                j++;
            }
        }

        String s3 = new String(s2, 0, i);
        String t3 = new String(t2, 0, j);
        return s3.equals(t3);
    }

    public static boolean backspaceCompareV3(String s, String t) {
        int is = s.length() - 1;
        int it = t.length() - 1;
        int his = 0;
        int hit = 0;
        int vcs = 0;
        int vct = 0;

        while (is >= 0 && it >= 0) {
            while (s.charAt(is) == '#') {
                his++;
                is--;
            }
            is = is - his;
            his = 0;
            if (is < 0) {
                break;
            }

            while (t.charAt(it) == '#') {
                hit++;
                it--;
            }
            it = it - hit;
            hit = 0;
            if (it < 0) {
                break;
            }

            if (s.charAt(is) != t.charAt(it)) {
                return false;
            }
            is--;
            it--;
            vcs++;
            vct++;

        }

        while (is >= 0) {
            while (s.charAt(is) == '#') {
                his++;
                is--;
            }
            is = is - his;
            his = 0;
            if (is < 0) {
                break;
            }
            is--;
            vcs++;
        }

        while (it >= 0) {
            while (t.charAt(it) == '#') {
                hit++;
                it--;
            }
            it = it - hit;
            hit = 0;
            if (it < 0) {
                break;
            }
            it--;
            vct++;
        }

        return vcs == vct;

    }

    public static boolean backspaceCompareV4(String s, String t) {
        int is = s.length() - 1;
        int it = t.length() - 1;
        int his = 0;
        int hit = 0;

        while (is >= 0 || it >= 0) {

            while (is >= 0) {
                if (s.charAt(is) == '#') {
                    his++;
                    is--;
                } else if (his > 0) {
                    is--;
                    his--;
                } else {
                    break;
                }

            }

            while (it >= 0) {
                if (t.charAt(it) == '#') {
                    hit++;
                    it--;
                } else if (hit > 0) {
                    it--;
                    hit--;
                } else {
                    break;
                }

            }

            if (is < 0 && it < 0) {
                return true;
            }

            if (is < 0 || it < 0) {
                return false;
            }

            if (s.charAt(is) != t.charAt(it)) {
                return false;
            }
            is--;
            it--;

        }
        return true;

    }

    public static void main(String[] args) {
        String s = "y#fo##f", t = "y#f#o##f";
        boolean res = backspaceCompareV4(s, t);
        System.out.println(res);

    }
}

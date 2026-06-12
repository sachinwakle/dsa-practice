package TwoPointers;

public class LC_125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        char ch = 0;
        char rchar = 0;

        while (left <= right) {
            while (left < len) {
                ch = s.charAt(left);
                if (ch >= 'a' && ch <= 'z') {
                    break;
                } else if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch + 32);
                    break;
                } else if (ch >= '0' && ch <= '9') {
                    break;
                }
                left++;
            }
            if (left >= len) {
                ch = 0;
            }

            while (right >= 0) {
                rchar = s.charAt(right);
                if (rchar >= 'a' && rchar <= 'z') {
                    break;
                } else if (rchar >= 'A' && rchar <= 'Z') {
                    rchar = (char) (rchar + 32);
                    break;
                } else if (rchar >= '0' && rchar <= '9') {
                    break;
                }
                right--;
            }

            if (right < 0) {
                rchar = 0;
            }

            if (ch != rchar) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}

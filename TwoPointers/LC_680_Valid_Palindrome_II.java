package TwoPointers;

public class LC_680_Valid_Palindrome_II {
    public static boolean validPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        boolean removed = false;
        boolean isPalindrome = true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right) && !removed) {
                if (s.charAt(left) == s.charAt(right - 1)) {
                    removed = true;
                    right--;
                } else if (s.charAt(left + 1) == s.charAt(right)) {
                    removed = true;
                    left++;
                } else {
                    isPalindrome = false;
                    break;
                }

            } else if (s.charAt(left) != s.charAt(right) && removed) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        left = 0;
        right = s.length() - 1;
        removed = false;

        if (!isPalindrome) {
            isPalindrome = true;
            while (left < right) {

                if (s.charAt(left) != s.charAt(right) && !removed) {
                    if (s.charAt(left + 1) == s.charAt(right)) {
                        removed = true;
                        left++;
                    } else if (s.charAt(left) == s.charAt(right - 1)) {
                        removed = true;
                        right--;
                    } else {
                        isPalindrome = false;
                        break;
                    }

                } else if (s.charAt(left) != s.charAt(right) && removed) {
                    isPalindrome = false;
                    break;
                }

                left++;
                right--;
            }

        }

        return isPalindrome;
    }

    public static boolean validPalindromeV2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;

    }

    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        boolean res = validPalindromeV2(s);
        System.out.println(res);
    }
}

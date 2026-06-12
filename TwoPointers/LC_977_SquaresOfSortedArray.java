package TwoPointers;

public class LC_977_SquaresOfSortedArray {

    static int[] squaresOfSortedArray(int[] nums) {
        int[] squareArray = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int k = j;

        while (i <= j) {
            if (sqr(nums[i]) >= sqr(nums[j])) {
                squareArray[k] = sqr(nums[i]);
                i++;
                k--;
            } else {
                squareArray[k] = sqr(nums[j]);
                j--;
                k--;
            }
        }
        return squareArray;
    }

    static int sqr(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -4, -1, 0, 3, 10 };
        int[] sortedSqaure = squaresOfSortedArray(arr);
        for (int e : sortedSqaure) {
            System.out.print(e + " ");
        }
    }
}
package TwoPointers;
/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class RemoveDuplicates {
    static int[] removeDuplicate(int[] inputArray) {
        int i = 0, j = 1;
        while (j < inputArray.length) {
            if (inputArray[i] == inputArray[j]) {
                j++;
                continue;
            }

            inputArray[++i] = inputArray[j++];
        }
        return inputArray;
    }

     static int getUniqueCount(int[] inputArray) {
        int i = 0, j = 1;
        int count = 1;

        while (j < inputArray.length) {
            if (inputArray[i] == inputArray[j]) {
                j++;
                continue;
            }

            inputArray[++i] = inputArray[j++];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 2, 3, 3, 3, 4, 4, 5 };
        // System.out.println(getUniqueCount(arr));
        int[] result = removeDuplicate(arr);
        for (int e : result) {
            System.out.print(e);
            System.out.print(" ");
        }

    }
}

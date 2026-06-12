package TwoPointers;

import java.util.Arrays;

/**
 * 
 * Triplets with Smaller Sum
Difficulty: MediumAccuracy: 40.33%Submissions: 113K+Points: 4

Given an array arr[] of distinct integers and a value sum, find the count of triplets (i, j, k), having (i<j<k) with the sum of (arr[i] + arr[j] + arr[k]) smaller than the given value sum.

Examples :

Input: sum = 2, arr[] = [-2, 0, 1, 3]
Output:  2
Explanation: Triplets with sum less than 2 are (-2, 0, 1) and (-2, 0, 3). 

Input: sum = 12, arr[] = [5, 1, 3, 4, 7]
Output: 4
Explanation: Triplets with sum less than 12 are (1, 3, 4), (5, 1, 3), (1, 3, 7) and (5, 1, 4).

Constraints:
1 ≤ sum ≤ 105
3 ≤ arr.size() ≤ 103
-103 ≤ arr[i] ≤ 103
Expected Complexities
Time Complexity: O(n^2)
Auxiliary Space: O(1)

 */

public class GFG_Triplets_with_Smaller_Sum {
    public static int countTriplets(int sum, int arr[]) {
        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int length = arr.length;
        while (i <length-2) {
            int left = i+1;
            int right = length-1;
            while (left<right) {
                int smallerSum = arr[left]+arr[right]+arr[i];
                if (smallerSum >= sum) {
                    right--;
                } else {
                    count+=right-left;
                    left++;
                }
            }
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        // Input: sum = 12, arr[] = [5, 1, 3, 4, 7]
        int[] arr = new int[]{5, 1, 3, 4, 7};
        int sum = 12;
        int count = countTriplets(sum, arr);
        System.out.println(count);
    }
    
}

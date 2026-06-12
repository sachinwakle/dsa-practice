package TwoPointers;

import java.util.Arrays;
import java.util.*;

public class LC_1_TwoSum {
    public static void main(String[] args) {
        int[] inputArr = new int[]{7,2,15,11};
        int target = 13;
        int[] result = findPair(inputArr,target);
        // int[] result = findIndexPair(inputArr,target);
        if (result != null) {
            int i=0;
            while (i<result.length) {
                System.out.println(result[i]);
                i++;
            }
        } else {
            System.out.println("No element found.");
        }
    }

    static int[] findPair(int[] inputArr,int target){
        Arrays.sort(inputArr);
        int i=0, j = inputArr.length-1;

        while (i<j) {
            if (inputArr[i]+inputArr[j]==target) {
                return new int[]{inputArr[i],inputArr[j]};
            } else if (inputArr[i]+inputArr[j]>target) {
                j--;
            } else if (inputArr[i]+inputArr[j]<target) {
                i++;
            }
        }

        return null;
    }

      static int[] findIndexPair(int[] inputArr,int target){
        Map<Integer,Integer> pairMapping = new HashMap<>();
        for(int i=0;i<inputArr.length;i++){
            int secondPair = target-inputArr[i];
            if (pairMapping.get(secondPair)!= null) {
                return new int[]{i,pairMapping.get(secondPair)};
            } else {
                pairMapping.put(inputArr[i], i);
            }

        }
        return null;
      }
    
}

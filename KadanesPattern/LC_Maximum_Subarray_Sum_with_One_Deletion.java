package KadanesPattern;

public class LC_Maximum_Subarray_Sum_with_One_Deletion {
    // [1,-2,0,3]
    public int maximumSum(int[] arr) {
        int result = arr[0];
        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            int prevNoDelete = noDelete;
            noDelete = Math.max(noDelete + arr[i], arr[i]);
            if (oneDelete == Integer.MIN_VALUE) {
                oneDelete = arr[0];
            } else {
                oneDelete  = Math.max(oneDelete+arr[i], prevNoDelete);
            }

            result = Math.max(result, Math.max(noDelete, oneDelete));
        }
        return result;
    }
}

/*

arr = [10,15,-2,-8,6,30]

index = 1,2,3,4,5
prevNoDelete = 10,25,23,15,21
noDelete = 10,25,23,15,21,51
oneDelete = minval,10,25,23,29,59
result = 10,25,29,59

 */
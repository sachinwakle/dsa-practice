package TwoPointers;

public class GF_Segregate_0s_And_1s {
    void  segregate0and1(int[] arr) {
        // code here
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 0) {
                left++;
            } else if (arr[left] == 1) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
            }

        }
    }

    void segregate0and1V2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {

            if (arr[left] == 0 && arr[right] == 0) {
                left++;
            } else if (arr[left] == 1 && arr[right] == 1) {
                right--;
            } else if (arr[left] > arr[right]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else {
                left++;
                right--;
            }
        }
    }

    void segregate0and1V3(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] == 0  ) {
                left++;
            }
            while (right > left && arr[right] == 1) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }   
    }

}

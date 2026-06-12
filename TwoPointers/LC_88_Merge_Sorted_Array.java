package TwoPointers;

public class LC_88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0, index2 = 0;

        while (index1 < m && index2 < n) {
            if (nums2[index2] < nums1[index1]) {
                int trav = index1;
                int replacement = nums2[index2];
                while (trav < nums1.length) {
                    int temp = nums1[trav];
                    nums1[trav] = replacement;
                    replacement = temp;
                    trav++;
                }
                index1++;
                index2++;
                m++;
            } else {
                index1++;
            }
        }

        while (index2 < n) {
            nums1[index1] = nums2[index2];
            index1++;
            index2++;
        }

    }

    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int i = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[i] = nums1[index1];
                index1--;
            } else {
                nums1[i] = nums2[index2];
                index2--;
            }
            i--;
        }

        while (index2 >= 0) {
            nums1[i] = nums2[index2];
            index2--;
            i--;
        }
    }
}

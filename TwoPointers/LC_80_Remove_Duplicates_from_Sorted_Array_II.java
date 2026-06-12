package TwoPointers;

public class LC_80_Remove_Duplicates_from_Sorted_Array_II {
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        boolean flag = true;

        while (right < nums.length ) {
            if (nums[right] != nums[right - 1]) {
                
                nums[++left] = nums[right];
                flag = true;
            } else {
                if (flag) {
                    
                    nums[++left] = nums[right];
                    
                    flag = false;
                }
            }
            right++;

        }

        return left+1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int res = removeDuplicates(nums);
        System.out.println(res);
        for(int i:nums){
            System.out.print(i+" ");
        }

     }
}

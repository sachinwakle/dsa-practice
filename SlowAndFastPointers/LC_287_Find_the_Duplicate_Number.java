package SlowAndFastPointers;

public class LC_287_Find_the_Duplicate_Number {
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return -1;
        }

        if (n == 2) {
            return nums[0] == nums[1] ? nums[0] : -1;
        }

        int slow = 0;
        int fast = 2;

        while (nums[slow] != nums[fast]) {
            slow = slow + 1;
            fast = fast + 2;

            if (slow >= n) {
                slow = slow - n;
            }

            if (fast >= n) {
                fast = fast - n;
            }

            if (slow == fast) {
                fast = fast + 2;
                if (fast >= n) {
                    fast = fast - n;
                }
            }

            System.out.println("slow: " + slow + " | fast: " + fast);
        }

        return nums[slow];

    }

    public static int findDuplicateV2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int lastNum = n - 1;
        int expectedSum = lastNum * (lastNum + 1) / 2;
        int borderSum = expectedSum + lastNum;
        if (expectedSum < sum && sum <= borderSum) {
            return sum - expectedSum;
        } else {
            return nums[0];
        }
    }

    public static int findDuplicateV3(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 4, 2, 2 };
        // int[] nums = new int[] {1,3,4,2,1 };
        // int[] nums = new int[] { 3, 3, 3, 3, 3 };
        int res = findDuplicateV3(nums);
        System.out.println(res);
    }
}

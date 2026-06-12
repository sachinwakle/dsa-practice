package SlowAndFastPointers;

public class LC_202_Happy_Number {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (true) {
            slow = calculateSum(slow);
            fast = calculateSum(calculateSum(fast));
            if (fast == 1) {
                return true;
            }
            if (slow == fast) {
                return false;
            }
        }
        
    }

    int calculateSum(int num){
        int sum = 0;
        while (num!=0) {
            int digit = num%10;
            sum = sum + (digit*digit);
            num = num/10;
        }
        return sum;
    }
}

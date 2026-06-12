package SlidingWindow.VariableWindow;

public class LC_121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i <= prices.length; i++) {
            int left = 0;
            int right = i;
            while (right < prices.length) {
                maxProfit = Math.max(maxProfit, (prices[right] - prices[left]));
                right++;
                left++;
            }
        }
        return maxProfit;
    }

    public int maxProfitV2(int[] prices) {
        int maxProfit = 0;
        int i = 1;
        int buy = prices[0];
        while (i < prices.length) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
            int profit = prices[i] - buy;
            maxProfit = Math.max(maxProfit, profit);
            i++;
        }
        return maxProfit;
    }

    public int maxProfitV3(int[] prices) {
        int maxProfit = 0;
        int i = 1;
        int buy = prices[0];
        while (i < prices.length) {
            buy = Math.min(buy, prices[i]);
            int profit = prices[i] - buy;
            maxProfit = Math.max(maxProfit, profit);
            i++;
        }
        return maxProfit;
    }
}

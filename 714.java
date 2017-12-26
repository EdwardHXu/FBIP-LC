class Solution {
    public int maxProfit(int[] prices, int fee) {
        //FBIP 2R
        //DP with time complexity O(N): on day i, we either do sell stock or buy stock or do nothing
        //cash is the maximum profit if did not have a share of stock, hold is the maximum profit if owned a share of stock
        if (prices == null || prices.length == 0)   return 0;
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++){
            cash = Math.max(cash, hold + prices[i] - fee);      //do nothing or sell stock with fee
            hold = Math.max(hold, cash - prices[i]);            //do nothing or buy stock
        }
        return cash;
    }
}
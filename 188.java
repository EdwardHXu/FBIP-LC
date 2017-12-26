class Solution {
    public int maxProfit(int k, int[] prices) {
        //FBIP
        //DP: dp[i][j] represents the max profit on day j and made i transactions before
        //dp[i][j] = max(dp[i][j-1], prices[j] - prices[jj] + dp[i-1][jj])
        //         = max(dp[i][j-1], prices[j] + max(dp[i-1][jj] - prices[jj]))
        //use quickSolver to solve if k >= prices.length / 2 since can make as many transactions under this condition
        if (prices == null || prices.length == 0 || k == 0)  return 0;
        int n = prices.length;
        if (k >= n / 2) return quickSolver(prices);
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++){
            int prevBuy = -prices[0];
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i][j - 1], prevBuy + prices[j]);
                prevBuy = Math.max(prevBuy, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
    private int quickSolver(int[] prices){
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }
}
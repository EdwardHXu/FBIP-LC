class Solution {
    public int maxProfit(int[] prices) {
        //FBIP 2R
        //shitty greedy problem
        if (prices == null || prices.length == 0)   return 0;
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++)
            if (prices[i + 1] > prices[i])
                result += prices[i + 1] - prices[i];
        return result;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        //FBIP 3R
        if (prices == null || prices.length == 0)   return 0;
        int result = 0, prev = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < prev)
                prev = prices[i];
            else 
                result = Math.max(result, prices[i] - prev);
        }
        return result;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        //FBIP 2R
        //DP problem with three states: buy, sell, rest
        //buy and sell represent the profit can get from these actions
        //transformation equation is:   buy[i] = max(rest[i-1]-price, buy[i-1]), sell[i] = max(buy[i-1]+price, sell[i-1])
        //and rest[i] = max(sell[i-1], buy[i-1], rest[i-1]). The fact is rest[i] = sell[i-1]
        //which can be reduced to: buy[i] = max(sell[i-2]-price, buy[i-1]) and sell[i] = max(buy[i-1]+price, sell[i-1])
        int prevBuy = Integer.MIN_VALUE, buy = Integer.MIN_VALUE;
        int prevSell = 0, sell = 0;
        for (int price : prices){
            prevBuy = buy;                                  //buy after sell
            buy = Math.max(prevBuy, prevSell - price);      //at day i, buy or not
            prevSell = sell;                                //buy after rest
            sell = Math.max(prevSell, prevBuy + price);     //at day i, sell or not
        }
        return sell;
    }
}

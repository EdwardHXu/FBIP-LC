class Solution {
    public int minCostII(int[][] costs) {
        //FBIP 2R
        //typical DP problem
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++){
            int prev1 = min1, prev2 = min2;
            min1 = -1;  min2 = -1;
            for (int j = 0; j < k; j++){
                if (j != prev1)     // current color j is different to last min1 so can use color same as prev1
                    costs[i][j] += prev1 < 0 ? 0 : costs[i - 1][prev1];
                else 
                    costs[i][j] += prev2 < 0 ? 0 : costs[i - 1][prev2];     //else use alternative color prev2 
                //find the indices of 1st and 2nd smallest cost of painting current house i
                if (min1 < 0 || costs[i][j] < costs[i][min1]){
                    min2 = min1;
                    min1 = j;
                }
                else if (min2 < 0 || costs[i][j] < costs[i][min2])
                    min2 = j;
            }
        }
        return costs[n - 1][min1];
    }
}
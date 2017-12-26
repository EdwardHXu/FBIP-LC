class Solution {
    public int maximalSquare(char[][] matrix) {
        //FBIP 2R
        //implemented dfs with O((mn)^2) now do it with DP
        //DP approach 2D version: dp[i][j] means right bottom element as (i, j) length 
        //dp(i, j) = min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1)) + 1
        //1D version: optimize as dp[j] = min(dp[j−1], dp[j], prev) where prev is old dp[j-1]
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)  return 0;
        int m = matrix.length, n = matrix[0].length;
        int result = 0, prev = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                int temp = dp[j];
                if (matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
                    result = Math.max(result, dp[j]);
                }
                else    dp[j] = 0;
                prev = temp;
            }
        }
        return result * result;
    }
}

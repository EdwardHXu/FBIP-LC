class Solution {
    public boolean isMatch(String s, String p) {
        //FBIP 3R
        //2D dp[i][j] means whether or not s.substring(i) and p.substring(j) can match
        //DP time and speace complexity of O(s.length * p.length)
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++)
            if (p.charAt(i) == '*' && dp[0][i-1])
                dp[0][i+1] = true;          //consider only p '*' scenario is true
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')   //'.' can match any character
                    dp[i+1][j+1] = dp[i][j];
                if (p.charAt(j) == '*'){
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.')
                        dp[i+1][j+1] = dp[i+1][j-1];                    //'*' considered as empty string
                    else 
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);  //'*' as multiple / single / empty character
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
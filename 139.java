class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //FBIP 3R
        //DP: divide s into s1 and s2, if s1 and s2 both in HashSet(wordDict), then s holds true
        if (s == null || s.length() == 0)    return true;
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && set.contains(s.substring(j, i))){  //divide s into (0, j) and (j, i) if both holds true then true
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

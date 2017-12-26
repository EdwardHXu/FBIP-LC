class Solution {
    public boolean canPartition(int[] nums) {
        //FBIP similar
        //problem can be generlized to backpack problem and use DP to solve it
        //DP: dp[i][j] means whether the specific sum j can be gotten from the first i numbers
        //for each number, if we don't pick it, dp[i][j] = dp[i-1][j]; if we pick nums[i], dp[i][j] = dp[i-1][j-nums[i]]
        //overall: dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]] optimize to 1-D array dp[i] = dp[i] || dp[i-num];
        if (nums == null || nums.length == 0)   return true;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)   
            return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums)
            for (int i = sum; i >= num; i--)
                dp[i] = dp[i] || dp[i - num];
        return dp[sum];
    }
}
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        //FBIP 2R
        //brute force as backtracking with O(2^n) WHILE DP has time complexity O(ns)
        //DP with subset sum: the key point is divide nums into pos and neg and sum(P) = (target + sum(nums)) / 2
        //this can be get from: sum(p) - sum(n) = target -> sum(p) - sum (n) + sum(p) + sum(n) = target + sum(num)
        //-> 2 * sum(p) = target + sum(num). Now problem is to find sbuset of nums satisfies sum(p) which is LC416!
        if (nums == null || nums.length == 0)   return 0;
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum < S || (S + sum) % 2 != 0 ? 0 : subsetSum(nums, (S + sum) / 2);
    }
    private int subsetSum(int[] nums, int target){  //revised backpack problem similar with LC416
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums)
            for (int i = target; i >= num; i--)
                dp[i] += dp[i - num];               //sum up all possible positive subset permutation
        return dp[target];
    }
}
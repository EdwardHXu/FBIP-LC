class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int combinationSum4(int[] nums, int target) {
        //FBIP 2R follow-up
        //logically can be implemented as previous backtracking approach but lead to TLE    
        //DP approach: the basic idea is that when target >= nums[i] can recrusively call the same function to sum the result
        //dp array only avoid calculate the same combination appreace before
        if (nums == null || nums.length == 0)   return 0;
        int[] dp = new int[target + 1];     //dp[] means sum of previous number
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target, dp);
    }
    private int helper(int[] nums, int remain, int[] dp){
        if (dp[remain] != -1)
            return dp[remain];
        int result = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= remain)
                result += helper(nums, remain - nums[i], dp);
        dp[remain] = result;
        return result;
        
        //alternative approach is use HashMap storing previsou called sum of array. IF negative num should limit length of output
        // int count = 0;
        // if (nums == null || nums.length == 0 || target < 0) return 0;
        // if (target == 0)    return 1;
        // if (map.containsKey(target))    return map.get(target);
        // for (int num : nums)
        //     count += combinationSum4(nums, target - num);
        // map.put(target, count);
        // return count;
    }
}
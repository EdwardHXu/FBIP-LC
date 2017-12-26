class Solution {
    public int lengthOfLIS(int[] nums) {
        //FBIP 2R
        //DP solution with O(n^2)
        //the state-equation is: dp[i] = max(dp[j]) + 1 where j < i and LIS = max(dp[i])
        // if (nums == null || nums.length == 0)   return 0;
        // int[] dp = new int[nums.length];
        // int result = 1;
        // dp[0] = 1;
        // for (int i = 1; i < nums.length; i++){
        //     int max = 0;
        //     for (int j = 0; j < i; j++)
        //         if (nums[i] > nums[j])
        //             max = Math.max(max, dp[j]);
        //     dp[i] = max + 1;
        //     result = Math.max(result, dp[i]);
        // }
        // return result;
        
        //BinarySearch from discussion with O(n*logn) 
        //basic idea is maintain an increasing array tails[] to record increasing subsequence length
        //traversal all num in nums, run binarysearch to append num into tails or just update it
        int[] tails = new int[nums.length];
        int result = 0;
        for (int num : nums){
            int lo = 0, hi = result;
            while (lo < hi){
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] < num)
                    lo = mid + 1;
                else 
                    hi = mid;
            }
            tails[lo] = num;
            if (lo == result)    result++;
        }
        return result;
    }
}
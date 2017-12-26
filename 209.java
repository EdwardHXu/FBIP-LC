class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //FBIP 2R
        //Simultaneously increase right to end and increase left to find when sum >= s
        if (nums == null || nums.length == 0)   return 0;
        int result = Integer.MAX_VALUE, l = 0, r = 0, sum = 0;
        while (r < nums.length){
            sum += nums[r++];
            while (sum >= s){
                result = Math.min(result, r - l);
                sum -= nums[l++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
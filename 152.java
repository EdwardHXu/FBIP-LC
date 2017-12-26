class Solution {
    public int maxProduct(int[] nums) {
        //FBIP 2R
        //due to negative numbers. we have to record min and max since negative * negative can be max
        if (nums == null || nums.length == 0)   return 0;
        int result = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++){
            int prevMax = max;         //use temp variable to avoid max override
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(prevMax * nums[i], min * nums[i]));
            result = Math.max(result, max);
        }
        return result;
    }
}
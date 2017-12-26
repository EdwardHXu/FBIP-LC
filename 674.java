class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //FBIP 2R
        //one-pass time complexity O(n)
        if (nums == null || nums.length == 0)   return 0;
        int result = 1, length = 1;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i + 1] > nums[i])
                length++;
            else 
                length = 1;
            result = Math.max(result, length);
        }
        return result;
    }
}
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //FBIP 2R
        //sliding windows with time complexity O(n)
        if (nums == null || nums.length == 0 || k <= 1) return 0;
        int result = 0, product = 1, l = 0, r = 0;
        while (r < nums.length){
            product *= nums[r];
            while (product >= k)        //product has to be less than k, which means when equals to k should also divide
                product /= nums[l++];
            result += r - l + 1;        //plus 1 means when l and r at the same position should include current element itself
            r++;
        }
        return result;
    }
}
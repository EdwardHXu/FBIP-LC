class Solution {
    public int totalHammingDistance(int[] nums) {
        //FBIP 3R
        //count all bits in 32-interger which is 1 and multiply to those is not 1
        if (nums == null || nums.length == 0)   return 0;
        int result = 0, n = nums.length;
        for (int i = 0; i < 32; i++){
            int count1Bits = 0;         //count how many number in nums have current bit 1
            for (int j = 0; j < n; j++)
                count1Bits += (nums[j] >> i) & 1;
            result += count1Bits * (n - count1Bits);    //distance are all differences in those 1Bits and 0Bits
        }
        return result;
    }
}
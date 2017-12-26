class Solution {
    //FBIP 2R
    //the key point is to choose with equal probability with rand.nextInt(indexCount + 1) = indexCount
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int result = 0, count = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target)
                if (rand.nextInt(++count) == count - 1)     //++count means increase indexCount and [0, count-1] is indexCount
                    result = i;
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
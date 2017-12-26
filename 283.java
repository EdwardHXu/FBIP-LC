class Solution {
    public void moveZeroes(int[] nums) {
        //FBIP 3R
        //use two pointer, one for current position and one for none-zero position
        if (nums == null || nums.length == 0)   return;
        int index = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[index++] = nums[i];
        while (index < nums.length)
            nums[index++] = 0;
        return;
    }
}
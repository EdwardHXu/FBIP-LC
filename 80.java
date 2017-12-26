class Solution {
    public int removeDuplicates(int[] nums) {
        //FBIP 2R
        //record length to check length < 2 or push forward and increase length
        int index = 0;
        for (int num : nums)
            if (index < 2 || num > nums[index - 2])
                nums[index++] = num;
        return index;
    }
}
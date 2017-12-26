class Solution {
    public int removeDuplicates(int[] nums) {
        //FBIP
        //use two pointers with scanning pointer and index pointer of new array
        int index = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[index])
                index++;
            nums[index] = nums[i];
        }
        return index + 1;
    }
}


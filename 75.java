class Solution {
    public void sortColors(int[] nums) {
        //FBIP 3R
        //use two pointers for 0 and 2 the rest in the middle
        //follow-up with k different color: can be implemented by divide and conquer
        int p0 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2){
            if (nums[index] == 0){
                nums[index] = nums[p0];
                nums[p0++] = 0;
            }
            else if (nums[index] == 2){
                nums[index] = nums[p2];
                nums[p2--] = 2;
                index--;                //be careful here since p2-- so index-- too
            }
            index++;
        }
        
        //doing follow-up with k colors
    //     if (nums == null || nums.length == 1) return;
    //     divideAndConquer(nums, 0, nums.length - 1, 0, 2);   //0~2 means k different colors
    // }
    // private void divideAndConquer(int[] nums, int left, int right, int min, int max){
    //     if (min >= max) return;
    //     int lo = left, hi = right;
    //     int i = left;
    //     while (i <= hi){
    //         if (nums[i] == min)
    //             swap(nums, i, lo);
    //         else if (nums[i] == max)
    //             swap(nums, i, hi--);
    //         else i++;
    //     }
    //     divideAndConquer(nums, lo, hi, min + 1, max - 1);
    // }
    // private void swap(int[] nums, int i, int j){
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    }
}     
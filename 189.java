class Solution {
    public void rotate(int[] nums, int k) {
        //FBIP 2R
        //creat two new arrays and combine them 
        //OR do it in-place by cyclic swaping element of i and (i + k) % n but tricky to implement 
        //OR just use reverse approach which is awesome: respectively reverse array three times 
        if (nums == null || nums.length == 0)   return;
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1 - k);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    private void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        //FBIP 3R
        //classic permutation algorithm
        //find the largest index of k satisfying increasing order
        int k = -1;
        for (int i = nums.length - 2; i >= 0; i--)
            if (nums[i+1] - nums[i] > 0){
                k = i;
                break;
            }
        //if all in decreasing order just simply reverse the whole array
        if (k == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        //find the largest l greater than k that nums[k] < nums[l]
        int l = -1;
        for (int i = nums.length - 1; i > k; i--)
            if (nums[i] > nums[k]){
                l = i;
                break;
            }
        //swap nums[k] and nums[l]
        swap(nums, k, l);
        //reverse sequence from nums[k+1] upto nums[nums.length - 1]
        reverse(nums, k + 1, nums.length - 1);
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int l, int r){
        if (l > r)  return;
        for (int i = l; i <= (l+r) / 2; i++)
            swap(nums, i, r + l - i);
    }
}

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        //FBIP 
        //like 3 sum, sort first and then convert to twoSumSmaller problem use two pointers, overall TC is O(n^2)
        if (nums == null || nums.length == 0)   return 0;
        int result = 0;
        Arrays.sort(nums);              //have to sort first!
        for (int i = 0; i < nums.length - 2; i++)
            result += twoSumSmaller(nums, i + 1, target - nums[i]);
        return result;
    }
    private int twoSumSmaller(int[] nums, int startIndex, int target){
        int result = 0, l = startIndex, r = nums.length - 1;
        while (l < r){
            if (nums[l] + nums[r] < target){
                result += r - l;        //for current left and right index sum up to result
                l++;
            }
            else 
                r--;
        }
        return result;
    }
}
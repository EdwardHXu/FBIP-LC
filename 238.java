class Solution {
    public int[] productExceptSelf(int[] nums) {
        //FBIP 2R
        //classic two pointers problem, first scan left to right can record multiplying result in array then do right to left 
        if (nums == null || nums.length == 0)   return null;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++)
            result[i] = result[i - 1] * nums[i - 1];
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}
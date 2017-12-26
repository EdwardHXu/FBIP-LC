class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        //FBIP 2R
        //discuss with a>0 or a<0 these two cases and use some math knowledges
        //use two pointers doing merge sort like process
        if (nums == null || nums.length == 0)   return nums;
        int n = nums.length;
        int[] result = new int[n];
        int l = 0, r = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (l <= r){     //two pointers slide depends on a is positive or negative for ascending order
            if (a >= 0)
                result[index--] = f(nums[l], a, b, c) >= f(nums[r], a, b, c) ? f(nums[l++], a, b, c) : f(nums[r--], a, b, c);
            else 
                result[index++] = f(nums[l], a, b, c) >= f(nums[r], a, b, c) ? f(nums[r--], a, b, c) : f(nums[l++], a, b, c);
        }
        return result;
    }
    private int f(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
}
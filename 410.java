class Solution {
    public int splitArray(int[] nums, int m) {
        //FBIP 2R
        //DP problem with binary search (tricky)
        //l = max number of array; r = sum of all numbers in the array
        //1.Cut the array from left
        //2.Try our best to make sure that the sum of numbers between each two cuts is large enough but still less than mid
        //3.We'll end up with two results: either we can divide the array into more than m subarrays or we cannot (valid() func)
        //if we can do that which means no more other cut can make part larger than mid, so lead to l = mid + 1
        //if we cannot do that, leads to r = mid - 1
        int max = 0, sum = 0;
        for (int num : nums){
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return sum;
        int l = max, r = sum;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (overDivide(mid, nums, m))
                l = mid + 1;
            else 
                r = mid - 1;
        }
        return l;
    }
    private boolean overDivide(int target, int[] nums, int m){
        int count = 1, sum = 0;
        for (int num : nums){
            sum += num;
            if (sum > target){
                sum = num;
                count++;
                if (count > m)
                    return true;
            }
        }
        return false;
    }
}
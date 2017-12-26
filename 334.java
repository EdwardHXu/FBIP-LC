class Solution {
    public boolean increasingTriplet(int[] nums) {
        //FBIP 2R
        //scan nums from left to right if nums[i] > min and > secondMin then true
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums){
            if (num <= min)
                min = num;
            else if (num <= secondMin)
                secondMin = num;
            else 
                return true;
        }
        return false;
    }
}
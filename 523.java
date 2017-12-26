class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //FBIP 2R
        //using HashMap: store sum far and minus to n*k in index, if key occurs again then find one
        //with one pass O(n) and space complexity O(min(n, k))
        if (nums == null || nums.length == 0)   return false;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (k != 0) sum = sum % k;      //since sum up to n*k is also acceptable
            if (map.containsKey(sum)){
                int size = i - map.get(sum);
                if (size > 1)   return true;
            }
            else 
                map.put(sum, i);
        }
        return false;
    }
}
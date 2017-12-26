class Solution {
    public int subarraySum(int[] nums, int k) {
        //FBIP 2R
        //use HashMap to store every sum of subarray when check just checking contains (sum - k)? with time complexity is O(n) 
        if (nums == null || nums.length == 0)   return 0;
        int result = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap();      //map store sum and occurence of this sum
        map.put(0, 1);                                      //in case first sum equals to k
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k))
                result += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}

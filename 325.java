class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        //FBIP 3R
        //use HashMap storing sum and index (no need worrying duplicated sum since oldest sum has the longest length)
        if (nums == null || nums.length == 0)   return 0;
        int result = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (sum == k)   result = i + 1;
            else if (map.containsKey(sum - k))      //which means intermediate array has result of k
                result = Math.max(result, i - map.get(sum - k));
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return result;
    }
}
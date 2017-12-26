class Solution {
    public int longestConsecutive(int[] nums) {
        //FBIP
        //time complexity is O(n) so cannot sort(), use HashMap to check adject nums exist or not with TC O(n) and SC O(n)
        if (nums == null || nums.length == 0)   return 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap();      //map store current num and its LCS length
        for (int num : nums){
            if (map.containsKey(num))   continue;
            int leftCount = map.getOrDefault(num - 1, 0);
            int rightCount = map.getOrDefault(num + 1, 0);
            int length = 1 + leftCount + rightCount;
            result = Math.max(result, length);
            map.put(num, length);                              //append current num and its sum to map
            map.put(num - leftCount, length);                  //extend to less adjacent num
            map.put(num + rightCount, length);                 //extend to greater adjacent num
        }
        return result;
    }
}
class Solution {
    public int findMaxLength(int[] nums) {
        //FBIP 2R
        //brute force approach is easy to implement BUT one pass solution must exisit
        //using hashmap to store the sum of 0/1 and their index, if sum exsits in map means (index in map, i) has equal 0 and 1
        if (nums == null || nums.length == 0)   return 0;
        int result = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);             //remember to put (0, -1) in map so that can get length correctly
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0)       //if 0 count-- if 1 count++   
                count--;
            else    
                count++;
            if (map.containsKey(count))
                result = Math.max(result, i - map.get(count));
            else 
                map.put(count, i);
        }
        return result;
    }
}
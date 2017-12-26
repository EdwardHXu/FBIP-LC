class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //FBIP
        //naive approach is use HashMap to record <element, occurence> and pick top k occurence element with TC O(nlgn)
        // List<Integer> result = new ArrayList();
        // if (nums == null || nums.length == 0)   return result;
        // Map<Integer, Integer> map = new HashMap();
        // for (int i = 0; i < nums.length; i++)
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // for (int i : map.keySet())
        //     result.add(i);
        // Collections.sort(result, (i, j) -> (map.get(j) - map.get(i)));
        // return result.subList(0, k);
        
        //if Collections.sort is forbiden then use bucket sorting with both time and space complexity O(n)
        List<Integer> result = new ArrayList();
        if (nums == null || nums.length == 0)   return result;
        Map<Integer, Integer> map = new HashMap();
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key : map.keySet()){                   //bucket is like reverse relation with HashMap but sorted with frequency
            int frequency = map.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList();
            bucket[frequency].add(key);
        }
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--)
            if (bucket[i] != null)
                result.addAll(bucket[i]);
        return result;
    }
}
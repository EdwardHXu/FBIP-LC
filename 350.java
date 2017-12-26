class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //FBIP 3R
        //similar with previous version but use ArrayList instead of HashSet BUT this solution is trivial
        //use HashMap to record every number in nums1 appears as positive and record number in nums2 as negative
        if (nums1 == null && nums2 == null) return nums1;
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums1.length; i++)
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        for (int i = 0; i < nums2.length; i++){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){        //if num in nums1 also in nums2 add to list and -1
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i);
        return result;
    }
}
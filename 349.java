class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //FBIP 3R
        //sort and binarySearch with O(n*lgn) and HashSet with O(n)
        //HashSet is trivial just maintain two set: set1 contain elements in nums1, if elements in nums2 also in set1 add to set2
        //sort and two pointers
        if (nums1 == null && nums2 == null) return nums1;
        HashSet<Integer> set = new HashSet();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j])
                i++;
            else 
                j++;
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set)
            result[index++] = num;
        return result;
    }
}

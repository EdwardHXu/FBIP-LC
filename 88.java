class Solution {
    //follow-up with merge K sorted array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //FBIP 2R
        //using three pointers i, j, k to record current nums1 and nums2 and merged nums1 index
        //cannot start from 0 cause that will override nums1 exsited value. START FROM BACK
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        //only check if nums2 still have unmerged value since nums1 value exsited in nums1 anyway
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }
}
//follow-up problem can be solved by divide and conquer method just like merge K sorted list
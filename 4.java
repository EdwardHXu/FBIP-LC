class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //FB interview
        //O(log(m+n)) is typical binary search: every time cut nums1 and nums2 into half part
    //     int m = nums1.length, n = nums2.length;
    //     int l = (m + n + 1) / 2;
    //     int r = (m + n + 2) / 2;
    //     return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    // }
    // private double getKth(int[] nums1, int start1, int[] nums2, int start2, int k){
    //     if (start1 > nums1.length - 1)  return nums2[start2 + k - 1];
    //     if (start2 > nums2.length - 1)  return nums1[start1 + k - 1];
    //     if (k == 1) return Math.min(nums1[start1], nums2[start2]);
    //     int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
    //     if (start1 + k/2 - 1 < nums1.length)    mid1 = nums1[start1 + k/2 - 1];
    //     if (start2 + k/2 - 1 < nums2.length)    mid2 = nums2[start2 + k/2 - 1];
    //     if (mid1 < mid2)
    //         return getKth(nums1, start1 + k/2, nums2, start2, k - k/2); //check: right1 + left2
    //     else
    //         return getKth(nums1, start1, nums2, start2 + k/2, k - k/2); //check: right2 + left1
        
        //better approach can be implemented as O(log(min(m, n)))
        int m = nums1.length, n = nums2.length;
        if (m < n)  return findMedianSortedArrays(nums2, nums1);    //make sure nums2 is shorter
        int l = 0, h = 2 * n;
        while (l <= h){
            int mid2 = (l + h) / 2;
            int mid1 = m + n - mid2;
            double l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double r1 = mid1 == 2 * m ? Integer.MAX_VALUE : nums1[mid1 / 2];    
            double r2 = mid2 == 2 * n ? Integer.MAX_VALUE : nums2[mid2 / 2];    
            if (l1 > r2)    l = mid2 + 1;                               //nums1 lower half is too big
            else if (l2 > r1)   h = mid2 - 1;                           //nums2 lower half is too big
            else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;      //right cut
        }
        return -1;
    }
}
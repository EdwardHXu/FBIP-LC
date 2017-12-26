class Solution {
    public int hIndex(int[] citations) {
        //FBIP 2R
        //instead of using Arrays.sort() and linear scanning, use binary search
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length, lo = 0, hi = n - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] >= n - mid)
                hi = mid - 1;
            else 
                lo = mid + 1;
        }
        return n - lo;
    }
}
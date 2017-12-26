/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //FBIP 3R
        //typical binary search
        int lo = 1, hi = n;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid))
                hi = mid - 1;
            else 
                lo = mid + 1;
        }
        return lo;
    }
}
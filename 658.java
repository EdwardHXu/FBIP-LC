class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //FBIP 2R similar 
        //use lamda expression implemented Collections.sort can solve (why Arrays.sort() fucked up?)
    //     List<Integer> result = new ArrayList();
    //     for (int num : arr)
    //         result.add(num);
    //     Collections.sort(result, (i, j) -> i == j ? i - j : Math.abs(i - x) - Math.abs(j -  x));
    //     result = result.subList(0, k);
    //     Collections.sort(result);
    //     return result;
    // }
        
        //use binary search 
        List<Integer> result = new ArrayList();
        int lo = 0, hi = arr.length - k;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;       //if x is further to mid than to mid + k, update lo otherwise update hi
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k]))
                lo = mid + 1;
            else 
                hi = mid;                       //this binary is to find the whole array instead of a num
        }
        for (int num : Arrays.copyOfRange(arr, lo, lo + k))
            result.add(num);
        return result;
    }
}
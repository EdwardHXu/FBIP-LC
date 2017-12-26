class Solution {
    public int findKthLargest(int[] nums, int k) {
        //FBIP 2R
        //can be implemented in: Arrays.sort() with TC O(NlgN) and SC O(1). pq with TC O(NlgK) and SC O(K)
        //selection algorithm with TC O(N) ~ O(N^2) and SC O(1). randomize quick sort with TC O(N) and SC O(1)
        //implement randomize quick sort below:
        shuffle(nums);
        k = nums.length - k;    //since sorted in ascending order so convert k into nums.length - k
        int lo = 0, hi = nums.length - 1;
        while (lo < hi){
            int i = partition(nums, lo, hi);
            if (i < k)  lo = i + 1;
            else if (i > k) hi = i - 1;
            else break;
        }
        return nums[k];
    }
    private int partition(int[] nums, int lo, int hi){
        int i = lo, j = hi + 1;
        while (true){
            while (i < hi && nums[++i] < nums[lo])  ;
            while (j > lo && nums[lo] < nums[--j])  ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void shuffle(int[] nums){
        Random rand = new Random();
        for (int i = 1; i < nums.length; i++){
            int r = rand.nextInt(i + 1);
            swap(nums, i, r);
        }
    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //FBIP 2R
        //backtracking approach fucked up at 219/282 test cases cause TLE which brute force complexity is O(n^4)
        //solution from disscusion with binary search and 2-sum with time complexity O(n^3)
        //one extra loop and rest like 3sum
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length < 4)   return result;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++){
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target)   break;      //first candidate too large 
            if (nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target)   continue;   //first candidate too small
            if (i > 0 && nums[i] == nums[i-1])  continue;                           //prevent duplicate
            for (int j = i + 1; j < n - 2; j++){
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;      //second candidate too large
                if (nums[i] + nums[j] + nums[n-1] + nums[n-2] < target) continue;   //second candidate too small
                if (j > i + 1 && nums[j] == nums[j-1])  continue;                   //prevent duplicate
                int l = j + 1, r = n - 1;
                while (l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1])   l++;
                        while (l < r && nums[r] == nums[r-1])   r--;
                        l++;
                        r--;
                    }
                    else if (sum < target)  l++;
                    else r--;
                }
            }
        }
        return result;
    }
}
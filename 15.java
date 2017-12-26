class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //FBIP 3R
        //using two pointers with O(n^2) instead of HashMap
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0)   return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i - 1] == nums[i])    continue;
            int l = i + 1, r = nums.length - 1, sum = -nums[i];
            while (l < r){
                if (nums[l] + nums[r] == sum){
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if (nums[l] + nums[r] < sum)
                    l++;
                else 
                    r--;
            }
        }
        return result;
        
        //follow-up with if cannot use sort then like Two Sum and use HashMap and HashSet to avoid duplicate 
        // List<List<Integer>> result = new ArrayList();
        // if (nums == null || nums.length == 0)   return result;
        // HashMap<Integer, int[]> map = new HashMap();
        // HashSet<List<Integer>> set = new HashSet();
        // for (int i = 0; i < nums.length; i++)
        //     for (int j = i + 1; j < nums.length; j++)
        //         map.put(nums[i] + nums[j], new int[]{i, j});    //potential threat as nums[i]+nums[j] may have many values?
        // for (int i = 0; i < nums.length; i++)
        //     if (map.containsKey(-nums[i]) && i != map.get(-nums[i])[0] && i != map.get(-nums[i])[1]){
        //         List<Integer> list = Arrays.asList(nums[i], nums[map.get(-nums[i])[0]], nums[map.get(-nums[i])[1]]);
        //         Collections.sort(list);
        //         set.add(list);
        //     }
        // for (List<Integer> list : set)
        //     result.add(list);
        // return result;
    }
}
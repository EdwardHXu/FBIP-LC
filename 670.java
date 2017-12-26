class Solution {
    public int maximumSwap(int num) {
        //FBIP 2R
        //Greedy with time complexity O(n) and space complexity O(1)
        //always swap larger number from 9-0 after current index (but the farest one) to get the maximum result
        char[] nums = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];      //record the index of 0~9 num last occurence index and if there is large one
        for (int i = 0; i < nums.length; i++)
            lastIndex[nums[i] - '0'] = i;
        for (int i = 0; i < nums.length; i++){
            for (int j = 9; j > nums[i] - '0'; j--){
                if (lastIndex[j] > i){      //larger num occurs later then i, swap i with the latest index of larger num
                    char temp = nums[i];
                    nums[i] = nums[lastIndex[j]];
                    nums[lastIndex[j]] = temp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }
}
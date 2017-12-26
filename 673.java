class Solution {
    public int findNumberOfLIS(int[] nums) {
        //FBIP 2R
        //DP problem: maintain two arrays length[] and count[] record the length of LIS and count of it until nums[i]
        if (nums == null || nums.length == 0)   return 0;
        int n = nums.length, result = 0, maxLen = 0;
        int[] length = new int[n], count = new int[n];
        for (int i = 0; i < n; i++){
            length[i] = 1;                                  //for every nums[i] initialize length and count
            count[i] = 1;
            for (int j = 0; j < i; j++){    
                if (nums[i] > nums[j]){                     //if nums[i] is larger than previous num
                    if (length[i] < length[j] + 1){         //update current length[i] as previous + 1 and get count[previous]
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }
                    else if (length[i] == length[j] + 1)    //merge current count as sum of count[previous]
                        count[i] += count[j];
                }
            }
            if (maxLen < length[i]){                        //same thing as maxLen and result, update them
                maxLen = length[i];
                result = count[i];
            }
            else if (maxLen == length[i])                   //merge result as sum of all count which is manLen
                result += count[i];
        }
        return result;
    }
}
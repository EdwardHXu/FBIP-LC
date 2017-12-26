class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //FBIP 2R
        //DP problem: test every possible starting index of middle interval. run time is O(n)
        //suppose middle interval is [i, i+k-1]
        //so left interval is in subrange [0, i-1] and right interval is from subrange [i+k, n-1]
        //indexLeft and indexRight is starting index of left and right interval in range [0, i] and [i, n - 1]
        //to get lexicographical smallest order, when there are two intervals with equal max sum always select the left most one
        if (nums == null || nums.length == 0)   return null;
        int n = nums.length, maxSum = 0;
        int[] result = new int[3], leftIndex = new int [n], rightIndex = new int[n], sum = new int[n + 1];
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];
        for (int i = k, total = sum[k] - sum[0]; i < n; i++){               //start index of left max sum interval
            if (sum[i+1] - sum[i+1-k] > total){     //careful! the condition is " > total" for left interval
                leftIndex[i] = i + 1 - k;
                total = sum[i+1] - sum[i+1-k];
            }
            else
                leftIndex[i] = leftIndex[i - 1];
        }
        rightIndex[n - k] = n - k;
        for (int i = n - k - 1, total = sum[n] - sum[n-k]; i >= 0; i--){    //start index of right max sum interval
            if (sum[i+k] - sum[i] >= total){        //careful! the condition is " >= total" for right interval
                rightIndex[i] = i;
                total = sum[i+k] - sum[i];
            }
            else 
                rightIndex[i] = rightIndex[i + 1];
        }
        for (int i = k; i <= n - 2 * k; i++){       //test all possible middle interval
            int l = leftIndex[i-1], r = rightIndex[i+k];
            int total = (sum[i+k] - sum[i]) + (sum[l+k] - sum[l]) + (sum[r+k] - sum[r]);
            if (total > maxSum){
                maxSum = total;
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }
        return result;
    }
}
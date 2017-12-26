class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //FBIP 3R
        //use sliding window with two pointers from substring template
        if (s == null || s.length() == 0 || k == 0) return 0;
        int result = 0, count = 0, left = 0, right = 0;
        int[] map = new int[128];
        while (right < s.length()){
            if (map[s.charAt(right++)]++ == 0)  
                count++;
            while (count > k)
                if (map[s.charAt(left++)]-- == 1)
                    count--;
            result = Math.max(result, right - left);
        }
        return result;
    }
}
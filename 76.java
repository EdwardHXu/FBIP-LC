class Solution {
    public String minWindow(String s, String t) {
        //FBIP 3R
        //using substring template: implement with char[] map and two pointers to maintain a sliding window
        if (s == null || s.length() == 0)   return "";
        int[] map = new int[128];
        int left = 0, right = 0, count = t.length(), minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray())
            map[c]++;
        while (right < s.length()){
            if (map[s.charAt(right++)]-- > 0) 
                count--;
            while (count == 0){
                if (right - left < minLen){
                    minLen = right - left;
                    startIndex = left;
                }
                if (map[s.charAt(left++)]++ == 0)   
                    count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
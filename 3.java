class Solution {
    public int lengthOfLongestSubstring(String s) {
        //FBIP 
        //use HashMap and two pointers get length of longest substring with TC O(n)
        if (s == null || s.length() == 0)   return 0;
        HashMap<Character, Integer> map = new HashMap();
        int result = 0, l = 0, r = 0;       
        while (r < s.length()){     //scanning s using r pointer and l stands for previous index of repeated character
            if (map.containsKey(s.charAt(r)))
                l = Math.max(l, map.get(s.charAt(r)) + 1);  //must plus 1, s.charAt(r) is repeated char so must count after it
            result = Math.max(result, r - l + 1);           //must plus 1 since length is index (r - l) + 1
            map.put(s.charAt(r), r++);
        }
        return result;
    }
}
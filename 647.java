class Solution {
    //FBIP 2R
    //the optimal approach is to extend palindrome from mid to left and right for every single i
    private int result = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)   return 0;
        for (int i = 0; i < s.length(); i++){       //i is the mid point
            extendPalindrome(s, i, i);              //extend for odd length
            extendPalindrome(s, i, i + 1);          //extend for even length
        }
        return result;
    }
    private void extendPalindrome(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++))
            result++;
    }
}

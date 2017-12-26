class Solution {
    public boolean validPalindrome(String s) {
        //FBIP 2R
        //check first if not valid then brute force delete one with O(n^2) but leads to TLE
        //use greedy approach from begin and end scan to inner if not equals update one of them. complexity is O(N)
        if (s == null || s.length() == 0)   return true;
        int l = -1, r = s.length();
        while (l++ < r--)
            if (s.charAt(l) != s.charAt(r))
                return isPalindrome(s, l - 1, r) || isPalindrome(s, l, r + 1);
        return true;
    }
    private boolean isPalindrome(String s, int l, int r){
        while (l++ < r--)
            if (s.charAt(l) != s.charAt(r))
                return false;
        return true;
    }
}

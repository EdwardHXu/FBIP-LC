class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //FBIP 2R
        //naive idea is to sort s1 and compare it with every sorted s2.substring to check equal or not
        //use sliding window is optimized approach
        //use map to store s1 char and then slide the window in s2, if all map char count is zero then result is true
        //sliding windon size is fixed as s1.length(), just slide right pointer from s1.length() to s2.length()
        if (s2 == null || s2.length() < s1.length())    return false;
        int[] map = new int[26];
        int len1 = s1.length(), len2 = s2.length();
        for (int i = 0; i < len1; i++){         //initialize char map as window content of left-0 right-s1.length() 
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;          //s1 counts positive, s2 counts negative
        }
        if (allZero(map))   return true;
        for (int i = len1; i < len2; i++){
            map[s2.charAt(i - len1) - 'a']++;   //char at left ++, char at right --
            map[s2.charAt(i) - 'a']--;
            if (allZero(map))   return true;
        }
        return false;
    }
    private boolean allZero(int[] map){
        for (int i = 0; i < map.length; i++)
            if (map[i] != 0)
                return false;
        return true;
    }
}

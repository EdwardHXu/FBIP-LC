class Solution {
    public boolean isMatch(String s, String p) {
        //FBIP 2R
        //quite similar with (easier than) Regular Expression Matching
        //maintain two pointers: one for s one for p, time complexity is O(s + p)
        int sIndex = 0, pIndex = 0, xIndex = -1, matchIndex = 0;    //record s, p, '*', and match index
        while (sIndex < s.length()){
            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
                sIndex++;                                           //push s and p at the same time
                pIndex++;
            }
            else if (pIndex < p.length() && p.charAt(pIndex) == '*'){
                xIndex = pIndex;                                    //record the '*' position and s-p same position
                matchIndex = sIndex;
                pIndex++;
            }
            else if (xIndex != -1){
                pIndex = xIndex + 1;                                //keep pushing after '*'
                matchIndex++;
                sIndex = matchIndex;
            }
            else return false;
        }
        while (pIndex < p.length() && p.charAt(pIndex) == '*')      //if s reached the end and p left with '*' keep pushing 
            pIndex++;
        return pIndex == p.length();
    }
}
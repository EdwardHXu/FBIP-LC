class Solution {
    public int strStr(String haystack, String needle) {
        //FBIP 3R
        //simply scan haystack from 0 to l1 - l2 to check contain needle or not
        if (needle == null || needle.length() == 0) return 0;
        if (haystack.length() < needle.length())    return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        return -1;
    }
}
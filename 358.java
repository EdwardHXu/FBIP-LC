class Solution {
    public String rearrangeString(String s, int k) {
        //FBIP 2R
        //more complicated than TaskScheduler. typical greedy problem: always find the candidate with largest remaining count
        if (s == null || s.length() == 0) return "";
        int[] count = new int[26];      //count every character appearence 
        int[] valid = new int[26];      //record next valid index of current character
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++){
            int candidate = findMaxValid(count, valid, i);      //greedily find the max_count candidate 
            if (candidate == -1)    return "";
            count[candidate]--;
            valid[candidate] = i + k;
            result.append((char) (candidate + 'a'));
        }
        return result.toString();
    }
    private int findMaxValid(int[] count, int[] valid, int index){
        int max = Integer.MIN_VALUE, candidate = -1;
        for (int i = 0; i < count.length; i++){
            if (count[i] > 0 && count[i] > max && index >= valid[i]){
                max = count[i];
                candidate = i;
            }
        }
        return candidate;
    }
}
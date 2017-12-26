class Solution {
    public String countAndSay(int n) {
        //FBIP 2R
        //just pure string manipulation...
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev = new StringBuilder();
        char say;
        int count;
        for (int i = 1; i < n; i++){
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++){
                if (prev.charAt(j) != say){
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
}

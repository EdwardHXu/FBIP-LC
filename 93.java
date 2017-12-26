class Solution {
    public List<String> restoreIpAddresses(String s) {
        //FBIP
        //3 loops divide string into 4 parts and for each part check this substring is valid or not
        //valid condition is length between 0-3 cannot be leading 0 and cannot be greater than 255
        List<String> result = new ArrayList();
        if (s == null || s.length() == 0)   return result;
        int n = s.length();
        for (int i = 1; i < 4 && i < n - 2; i++){
            for (int j = i + 1; j < i + 4 && j < n - 1; j++){
                for (int k = j + 1; k < j + 4 && k < n; k++){
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, n);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return result;
    }
    private boolean isValid(String s){
        if (s.length() == 0 || s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
            return false;
        return true;
    }
}
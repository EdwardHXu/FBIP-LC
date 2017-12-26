class Solution {
    public int compress(char[] chars) {
        //FBIP 2R
        //have done in contest 56 independently 
        // int result = 0;
        // int index = 0, n = chars.length, len = 1, pos = 0;
        // while (index < n){
        //     while (index + len < n && chars[index] == chars[index + len])
        //         len++;
        //     if (len == 1){
        //         chars[pos] = chars[index];  pos++;
        //         result++;
        //     }   
        //     else if (len > 1 && len < 10){
        //         chars[pos] = chars[index];  pos++;
        //         chars[pos] = (char) (len + 48); pos++;
        //         result += 2;
        //     }
        //     else if (len >= 10 && len < 100){    
        //         chars[pos] = chars[index];  pos++;
        //         chars[pos] = (char) (len / 10 + 48); pos++;
        //         chars[pos] = (char) (len % 10 + 48);    pos++;
        //         result += 3;
        //     }
        //     else if (len >100){
        //         chars[pos] = chars[index];  pos++;
        //         chars[pos] = (char) (len / 100 + 48);    pos++;
        //         chars[pos] = (char) ((len / 10) % 10 + 48);  pos++;
        //         chars[pos] = (char) (len % 100 + 48);   pos++;
        //         result += 4;
        //     }  
        //     index += len;
        //     len = 1;
        // }
        // return result;
        
        //optimized to SC(1) and TC(n) with two pointers and counter
        int start = 0, end = 0, count = 0;
        for (; end < chars.length; end++){
            count++;    
            if (end == chars.length - 1 || chars[end] != chars[end + 1]){   //different or reach end of array
                chars[start] = chars[end];
                start++;
                if (count != 1){
                    char[] nums = String.valueOf(count).toCharArray();
                    for (int i = 0; i < nums.length; i++){
                        chars[start] = nums[i];
                        start++;
                    }
                }
                count = 0;      //remember to reset counter
            }
        }
        return start;
    }
}
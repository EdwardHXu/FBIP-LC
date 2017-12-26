class Solution {
    public int numDecodings(String s) {
        //FBIP 3R
        //DP problem: f(i) = ways(i) * f(i-1) + ways(i-1, i) * f(i-2)
        //with time complexity O(n) and space complexity O(1)
        //here define first as dp[i-2], second as dp[i] (also as dp[i-1] since dp[i-1] will convert to dp[i])
        //so we have second = ways(i) * second + ways(i-1, i) * first;  first = prevSecond
        if (s == null || s.length() == 0)   return 0;
        long first = ways(s.charAt(0));
        if (s.length() < 2)     return (int) first;
        long second = ways(s.charAt(1)) * first + ways(s.charAt(0), s.charAt(1));
        for (int i = 2; i < s.length(); i++){
            long prevSecond = second;
            second = (ways(s.charAt(i)) * second + ways(s.charAt(i-1), s.charAt(i)) * first) % 1000000007;
            first = prevSecond;
        }
        return (int) second;
    }
    
    private int ways(char c){               //single character is trivial to decode
        if (c == '*')   return 9;
        if (c == '0')   return 0;
        return 1;
    }
    
    private int ways(char c1, char c2){     //here c1 means s.charAt(i -1) and c2 means s.charAt(i)
        String s = String.valueOf(c1) + String.valueOf(c2);
        if (c1 != '*' && c2 != '*'){        //if c1 and c2 are 10-26 just decode into 1 possible result
            if (Integer.parseInt(s) >= 10 && Integer.parseInt(s) <= 26)
                return 1;
        }
        else if (c1 == '*' && c2 == '*')    //if encounter ** will decode as any num in 11-19 and 21-26 = 9+6 = 15
            return 15;
        else if (c1 == '*'){                //if encounter *N if 0<=N<=6 then num can be 1N and 2N; if 7<=N<=9 then num can be 1N
            int num2 = Integer.parseInt(String.valueOf(c2));
            if (num2 >= 0 && num2 <= 6)
                return 2;
            else 
                return 1;
        }
        else if (c2 == '*'){                //if encounter N* if N==1 then num can be 11-19 if N==2 then num can be 21-26
            int num1 = Integer.parseInt(String.valueOf(c1));
            if (num1 == 1)
                return 9;
            else if (num1 == 2)
                return 6;
        }
        return 0;
    }
}
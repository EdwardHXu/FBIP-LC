class Solution {
    public int divide(int dividend, int divisor) {
        //FBIP 3R
        //shitty math problem. use long to avoid overflow
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldivisor == 0)   return Integer.MAX_VALUE;
        if (ldividend == 0 || ldividend < ldivisor) return 0;
        long lresult = ldivide(ldividend, ldivisor);
        int result = 0;
        if (lresult > Integer.MAX_VALUE)
            result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else result = (int) (sign == 1 ? lresult : -lresult);
        return result;
    }
    private long ldivide(long ldividend, long ldivisor){
        if (ldividend < ldivisor)
            return 0;
        //find the max multiple so divisor * multiple <= dividend. Just like binary search 1 2 4 8 16 ...
        long sum = ldivisor, multiple = 1;
        while (sum + sum <= ldividend){
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
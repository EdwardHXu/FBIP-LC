class Solution {
    public double myPow(double x, int n) {
        //FBIP 2R
        //math implement pow()
        if (n < 0)  return 1/x * myPow(1/x, -(n+1));
        if (n == 0) return 1;
        if (n == 2) return x * x;
        if (n % 2 == 0) return myPow(myPow(x, n/2), 2);
        else    return x * myPow(myPow(x, n/2), 2);
    }
}
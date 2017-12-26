class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //FBIP 2R
        //basic idea is that ugly number can be generated from primes[i] multiplying previous ugly number, also skip duplicate 
        //below is naive approach with TC O(NK) but can be optimized to O(NlogK) with heap
        int[] ugly = new int[n];
        int[] index = new int[primes.length];           //index store the preivous ugly number should multiply with primes
        ugly[0] = 1;
        for (int i = 1; i < n; i++){
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[index[j]]);
            for (int j = 0; j < primes.length; j++)     //slip duplicate (prune branch) by updating index array
                while (primes[j] * ugly[index[j]] <= ugly[i])
                    index[j]++;
        }
        return ugly[n - 1];
    }
}

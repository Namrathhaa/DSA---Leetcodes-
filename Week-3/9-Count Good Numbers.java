class Solution {
    private static final long MOD = 1_000_000_007L; 
        public int countGoodNumbers(long n) {
            long evenPositions = (n+1)/2;
            long oddPositions = n/2;
            long evenWays = modPow(5, evenPositions);
            long oddWays = modPow(4, oddPositions);
            return (int) ((evenWays * oddWays) % MOD);
        }
        private long modPow(long base, long exp) {
            if(exp==0) {
                return 1;
            }
            long half = modPow(base, exp/2);
            long result = (half*half) % MOD;
            if(exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            return result;
        }
    }

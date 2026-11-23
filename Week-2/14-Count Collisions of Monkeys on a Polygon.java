class Solution {
    public int monkeyMove(int n) {
        long MOD = 1_000_000_007;
        long totalWays = power(2, n, MOD);
        long result = (totalWays - 2 + MOD) % MOD;
        return (int) result;
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}

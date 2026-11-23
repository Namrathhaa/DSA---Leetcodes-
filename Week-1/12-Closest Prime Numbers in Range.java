class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int p = 2; p * p <= right; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= right; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        if (primes.size() < 2) {
            return new int[] { -1, -1 };
        }
        
        int minDiff = Integer.MAX_VALUE;
        int num1 = -1;
        int num2 = -1;
        
        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i);
                num2 = primes.get(i + 1);
            }
        }
        
        return new int[] { num1, num2 };
    }
}

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        boolean isNegative = N < 0;
        if (isNegative) {
            N = -N;
        }
        
        double ans = 1.0;
        double currentProduct = x;
        
        while (N > 0) {
            if ((N % 2) == 1) {
                ans = ans * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
            N = N / 2;
        }
        
        return isNegative ? 1.0 / ans : ans;
    }
}

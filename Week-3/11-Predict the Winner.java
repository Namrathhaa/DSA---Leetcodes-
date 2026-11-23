class Solution {
    private Integer[][] memo;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];
        return maxDiff(nums, 0, n-1) >= 0;
    }
    private int maxDiff(int[] nums, int i, int j) {
        if(i == j) {
            return nums[i];
        }
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        int pickLeft = nums[i] - maxDiff(nums, i+1, j);
        int pickRight = nums[j] - maxDiff(nums, i, j-1);
        memo[i][j] = Math.max(pickLeft, pickRight);
        return memo[i][j];
    }
}

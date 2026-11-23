class Solution {
    private int max0r;
    private int count;
    public int countMaxOrSubsets(int[] nums) {
     max0r = 0;
     count = 0;
     for(int num : nums) {
        max0r |= num;
     }   
     dfs(nums, 0, 0);
     return count;
    }
    private void dfs(int[] nums, int index, int current0r) {
        if(index == nums.length) {
            if(current0r == max0r) {
                count++;
            }
            return;
        }
        dfs(nums, index + 1, current0r | nums[index]);
        dfs(nums, index + 1, current0r);
    }
}

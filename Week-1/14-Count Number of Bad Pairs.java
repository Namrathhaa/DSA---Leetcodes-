class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPairs = n * (n - 1) / 2;
        long goodPairs = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            if (map.containsKey(diff)) {
                goodPairs += map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        return totalPairs - goodPairs;
    }
}

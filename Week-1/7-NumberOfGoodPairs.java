class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int goodPairs = 0;
        
        for (int num : nums) {
            // If the number has been seen before, each previous occurrence 
            // forms a new good pair with the current number
            if (countMap.containsKey(num)) {
                goodPairs += countMap.get(num);
            }
            // Increment the count of this number in the map
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        return goodPairs;
    }
}

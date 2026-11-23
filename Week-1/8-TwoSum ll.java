class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // The problem requires 1-indexed results
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;  // We need a larger sum, so move the left pointer up
            } else {
                right--; // We need a smaller sum, so move the right pointer down
            }
        }
        
        return new int[] {};
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane's Algorithm - O(n) Time Complexity
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        // Sirf ek single loop chalega, koi nested loop nahi!
        for (int i = 1; i < nums.length; i++) {
            // Ya toh pichle sum me naya element jodo, ya naye element se fresh start karo
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Global maximum ko update karo
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
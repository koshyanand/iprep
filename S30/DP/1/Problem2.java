// Link: https://leetcode.com/problems/house-robber/

// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            
            if (i == 1)
                dp[i] = Math.max(dp[i - 1], nums[i]);
            else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }                    
        }
        
        return dp[nums.length - 1];
    }
}
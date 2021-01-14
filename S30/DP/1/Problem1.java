// Link: https://leetcode.com/problems/coin-change/

// Time Complexity: O(S * N) S: Number of coins N: Amount 
// Space Complexity: (N)

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if (amount == 0 || coins.length == 0)
            return 0;
        
        int[] dp = new int[amount + 1];
        
        for(int i = 1; i <= amount; i++) {
            int minCoins = amount + 1;
            for (int coin : coins) {
                
                int rem = i - coin;
                
                if (rem >= 0 && dp[rem] != -1) {
                    minCoins = Math.min(dp[rem] + 1, minCoins);
                }
            }
            dp[i] = minCoins;
        }

        return dp[dp.length - 1] > amount?-1:dp[dp.length - 1];
    }
}
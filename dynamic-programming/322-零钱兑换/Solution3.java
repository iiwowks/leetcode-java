/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 * 解题思路：动态规划————自下而上
 * 状态转移方程：
 * F(i) = min(F(i - c_j)) + 1       0 <= j <= n - 1
 * F(i) 为组成金额 i 所需最少的硬币数量，c_j 代表的是第 j 枚硬币的面值
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;


        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end


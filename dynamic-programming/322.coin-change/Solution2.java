/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 * 解题思路：动态规划————自上而下
 * 状态转移方程：
 * F(S) = F(S - C) + 1: { F(S) 即组成金额 S 最少的硬币数，最后一枚硬币的面值是 C }
 * F(S) = F(S - C_i) + 1 subject to S - C_i >= 0     { 0 <= i <= n - 1}
 * F(S) = 0 , when S = 0
 * F(S) = -1 , when n = 0
 * 
 * 子问题答案存数组，避免重复计算
 */

// @lc code=start
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    /**
     * 
     * @param coins
     * @param amount    
     * @param count     count[amount]子问题状态数组
     * @return
     */
    private int helper(int[] coins, int amount, int[] count) {
        int min = Integer.MAX_VALUE;

        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount - 1] != 0) return count[amount - 1];
        
        // 递归遍历状态树
        for (int coin : coins) {
          int res = helper(coins, amount - coin, count);
          // 
          if (res >= 0 && res < min)
            min = 1 + res;
        }

        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }
}
// @lc code=end


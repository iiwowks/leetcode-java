/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 * 解题思路：搜索回溯
 * // Time Limit Exceeded
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(0, coins, amount);
    }

    /**
     * 
     * @param idxCoin 目前递归到的index of coin
     * @param coins
     * @param amount
     * @param minCost 本层合法硬币最小值
     * @return        本层合法硬币最小值
     */
    private int helper(int idxCoin, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin]; // 此硬币能兑最大个数
            int minCost = Integer.MAX_VALUE;
            // x 表示此硬币使用次数
            for (int x = 0; x <= maxVal; x++) {
                if (x * coins[idxCoin] <= amount) {
                    // 此处递归求下一个硬币兑换最小数
                    int res = helper(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                    }

                }
            }

            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 * 解题思路：峰谷法
 * 1. 关注连续的 ‘峰’ 和 ‘谷’
 * 2. totalProfit = 累加(hight(peek_i) - hight(valley_i))
 * 3. 忽略掉了中间相邻的差值，作为一个整体累加了
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;

        while (i < prices.length - 1) {
            // 找到 ‘谷’
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            // 继续找 ‘峰’
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxProfit += peak - valley;           
        }
        return maxProfit;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start

//峰谷法
class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int vally = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while(i < prices.length-1){
            //找到第一个低谷： 比随后一个元素小  连续下降
            while(i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            vally = prices[i];
            //i从低谷开始向上寻找第一个最高峰  连续上升
            while(i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit +=peak - vally;
        }
        return maxprofit;
    }
}
//
class Solution_2 {
    public int maxProfit(int[] prices){
        int maxprofit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    
}
// @lc code=end


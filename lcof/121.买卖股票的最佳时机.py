#
# @lc app=leetcode.cn id=121 lang=python3
#
# [121] 买卖股票的最佳时机
#

# @lc code=start
# 思路对于每组i和j 找出max(prices[j]- prices[i])
from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ans = 0
        for i in range(len(prices)):
            for j in range(i + 1,len(prices)):
                ans = max(ans,prices[j]-prices[i])
        return ans


# @lc code=end


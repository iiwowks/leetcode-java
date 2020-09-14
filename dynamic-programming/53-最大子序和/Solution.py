#
# @lc app=leetcode.cn id=53 lang=python3
#
# [53] 最大子序和
# dp[i] = max(nums[i], nums[i] + dp[i - 1])
# 最大子序列和 = 当前元素自身最大，或者 包含之前后最大
#

# @lc code=start
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = nums
        for i in range(1, len(nums)):
            dp[i] = max(nums[i], nums[i] + dp[i - 1])
        return max(dp)
# @lc code=end


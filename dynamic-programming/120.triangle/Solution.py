#
# @lc app=leetcode id=120 lang=python3
#
# [120] Triangle
#

# @lc code=start
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # 初始化dp
        dp = triangle
        # 从倒数第二行开始向上递推
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                dp[i][j] += min(dp[i + 1][j], dp[i + 1][j + 1])
        return dp[0][0]

# @lc code=end


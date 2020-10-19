#
# @lc app=leetcode.cn id=343 lang=python3
#
# [343] 整数拆分
#

# @lc code=start


class Solution:
    def integerBreak(self, n: int) -> int:
        if n <= 3:
            return n - 1
        a, b = n // 3, n % 3
        if b == 0:
            return pow(3, a)
        if b == 1:
            return pow(3, a - 1) * 4
        return pow(3, a) * 2
# @lc code=end

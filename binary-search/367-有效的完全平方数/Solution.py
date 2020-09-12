#
# @lc app=leetcode.cn id=367 lang=python3
#
# [367] 有效的完全平方数
#

# @lc code=start
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num < 2:
            return True
        x = num // 2
        while x * x > num:
            x = (x + num // x) // 2
        return x * x == num
# @lc code=end


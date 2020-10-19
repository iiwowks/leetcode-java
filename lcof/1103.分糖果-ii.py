#
# @lc app=leetcode.cn id=1103 lang=python3
#
# [1103] 分糖果 II
#

# @lc code=start
#暴力法
class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        ans = [0] * num_people
        i = 0
        while candies != 0:
            ans[i % num_people] += min(i + 1, candies)
            candies -= min(i + 1, candies)
            i += 1
        return ans


#数学
class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        n = num_people
        # how many people received complete gifts
        p = int((2 * candies + 0.25)**0.5 - 0.5) 
        remaining = int(candies - (p + 1) * p * 0.5)
        rows, cols = p // n, p % n
        
        d = [0] * n
        for i in range(n):
            # complete rows
            d[i] = (i + 1) * rows + int(rows * (rows - 1) * 0.5) * n
            # cols in the last row
            if i < cols:
                d[i] += i + 1 + rows * n
        # remaining candies        
        d[cols] += remaining

# @lc code=end


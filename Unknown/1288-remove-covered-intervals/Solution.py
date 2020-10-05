#
# @lc app=leetcode id=1288 lang=python3
#
# [1288] Remove Covered Intervals
# 解题思路：枚举
# 对于每一个区间p, 枚举其余所有区间，依次判断p是否被其他区间所覆盖

# @lc code=start
class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        ans = n
        for i in range(n):
            for j in range(n):
                if i != j and intervals[j][0] <= intervals[i][0] and intervals[i][1] <= intervals[j][1]:
                    ans -= 1
                    break
        return ans

# @lc code=end


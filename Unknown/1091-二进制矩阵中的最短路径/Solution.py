#
# @lc app=leetcode.cn id=1091 lang=python3
#
# [1091] 二进制矩阵中的最短路径
# 解题思路：BFS
#

# @lc code=start
class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        q, n = [(0, 0, 2)], len(grid)
        if grid[0][0] or grid[-1][-1]:
            return -1
        elif n <= 2:
            return n

        # BFS
        for i, j, d in q:
            # current node: i, j ; distance = d
            for x, y in [(i - 1, j - 1), (i - 1, j), (i - 1, j + 1), (i, j - 1), (i, j + 1), (i + 1, j - 1), (i + 1, j), (i + 1, j + 1)]:
                if 0 <= x < n and 0 <= y < n and not grid[x][y]:
                    if x == y == n - 1:
                        return d
                    q += [(x, y, d + 1)]
                    grid[x][y] = 1
        return -1

# @lc code=end

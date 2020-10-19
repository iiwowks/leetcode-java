#
# @lc app=leetcode.cn id=994 lang=python3
#
# [994] 腐烂的橘子
#

# @lc code=start
# Python3:使用一个队列，先把腐烂的橘子（的坐标）依次入队，然后从队头开始，弹出一个腐烂的橘子，
# 同时将其四周的好橘子腐蚀并入队，时间time+1，依次进行直到队空，最后如果grid中好有好橘子则返回-1，否则返回time

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        x,y,time = len(grid), len(grid[0]) , 0
        locs,queue = [[-1,0],[0,-1],[0,1],[1,0]], []
        for i in range(x):
            for j in range(y):
                if grid[i][j] == 2:
                    queue.append((i,j,0))
        while queue:
            i,j,time = queue.pop(0)
            for loc in locs:
                loc_i,loc_j = i+loc[0],j+loc[1]
                if 0<=loc_i<x and 0<=loc_j<y and grid[loc_i][loc_j]==1:
                    grid[loc_i][loc_j]=2
                    queue.append((loc_i,loc_j,time+1))
        
        for g in grid:
            if 1 in g:
                return -1
        return time

        
# @lc code=end


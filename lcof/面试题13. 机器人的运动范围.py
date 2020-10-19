import collections

'''
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格
（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
'''

# 将矩阵看作一个有向图，用BFS或DFS


class Solution:
    def sum_rc(self, row, col):  # 计算行坐标和列坐标之和
        tmp = 0
        while row > 0:
            tmp += row % 10
            row //= 10
        while col > 0:
            tmp += col % 10
            col //= 10
        return tmp

    # 运动范围满足条件：
    # 1.当前格子坐标位数之和不大于k
    # 2.从坐标(0,0)通过上下左右移动可以到达当前格子

    """ def movingCount(self, m: int, n: int, k: int) -> int:
        marked = set()  # 将访问过的点添加到集合marked中,从(0,0)开始
        queue = collections.deque()
        queue.append((0, 0))
        while queue:
            x, y = queue.popleft()
            if (x, y) not in marked and self.sum_rc(x, y) <= k:
                marked.add((x, y))
                for dx, dy in [(-1, 0), (1, 0), (0, 1), (0, -1)]:
                    if 0 <= x + dx < m and 0 <= y + dy < n:
                        queue.append((x+dx, y+dy))
        return len(marked) """

    # 广度优先搜索 一般是使用队列实现
    def movingCount(self, m: int, n: int, k: int) -> int:
        marked = set()  # 将访问过的点添加到集合marked中，从(0,0)开始
        queue = collections.deuqe()

        queue.append((0, 0))  # 先将(0,0)加入队列

        while queue:  # 当队列不为空时，每次将队首坐标出队，加入集合中，再将满足两个条件的坐标加入到队尾，直到队列为空
            x, y = queue.popleft()

            if (x, y) not in marked and self.sum_rc(x, y) <= k:
                marked.add((x, y))

                for dx, dy in[(1, 0), (0, 1)]:  # 仅考虑向下和向右即可
                    if 0 <= x+dx < m and 0 <= y+dy < n:
                        queue.append((x+dx, y+dy))
        return len(marked)

    # 深度优先搜索 一般使用栈来实现， 使用递归容易实现，


class Solution:
    def movingCount(self, m: int, n: int, k: int) -> int:
        def sum_ij(i, j):
            tmp = 0
            while i > 0:
                tmp += i % 10
                i //= 10
            while j > 0:
                tmp += j % 10
                j //= 10
            return tmp

        def dfs(i, j):
            nonlocal res
            if (i, j) in marked \
                    or i == m \
                    or j == n \
                    or sum_ij(i, j) > k:
                return
            marked.add((i, j))
            res += 1
            dfs(i+1, j), dfs(i, j+1)

        marked = set()
        res = 0
        dfs(0, 0)
        return res

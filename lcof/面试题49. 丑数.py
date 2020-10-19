""" 关键思路：找一下最小丑数
思路一：最小堆
因为丑数是2, 3, 5的倍数，我们不断把它们的倍数压入栈中，再按顺序弹出！
时间复杂度：nlogn """
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        import heapq
        heap = [1]
        heapq.heapify(heap)
        res = 0
        for _ in range(n):
            res = heapq.heappop(heap)
            while heap and res == heap[0]:
                res = heapq.heappop(heap)
            a, b, c = res * 2, res * 3, res * 5
            for t in [a, b, c]:
                heapq.heappush(heap, t)
        return res



""" 思路二：动态规划
dp[i] 表示第i个丑数
那么dp[i] = min(2 * dp[l_2], 3 * dp[l_3], 5 * dp[l_5])
这里 l_2, l_3, l_5是表示，指到的位置。
时间复杂度：O(n)O"""
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp = [0] * n
        dp[0] = 1
        l_2 = 0
        l_3 = 0
        l_5 = 0
        for i in range(1, n):
            dp[i] = min(2 * dp[l_2], 3 * dp[l_3], 5 * dp[l_5])
            if dp[i] >= 2 * dp[l_2]:
                l_2 += 1
            if dp[i] >= 3 * dp[l_3]:
                l_3 += 1
            if dp[i] >= 5 * dp[l_5]:
                l_5 += 1
        return dp[-1]


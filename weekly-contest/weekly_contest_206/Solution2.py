# 5512. 统计不开心的朋友

class Solution:
    def unhappyFriends(self, n: int, preferences: List[List[int]], pairs: List[List[int]]) -> int:
        hm = {}  # 配对情况表，用一个哈希表代替，O(1)
        for i, j in pairs:  # 核心在于建立这个双向的表，因为题目中[x, y]不具有自反性
            hm[i] = j
            hm[j] = i
        not_happy = set()  # 注意是一个set
        for x in range(n):
            y = hm[x]
            for u in preferences[x][0:preferences[x].index(y)]:  # 对每一个比y更亲近的
                v = hm[u]
                if preferences[u].index(x) < preferences[u].index(v):
                    not_happy.add(x)
        return len(not_happy)


    
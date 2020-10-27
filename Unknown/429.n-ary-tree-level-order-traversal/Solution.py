#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
#

# @lc code=start
import collections

# Definition for a Node.
class Node:
    def __init__(self, val = None, children = None):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res = []
        queue = collections.deque()
        queue.append(root)
        while queue:
            size = len(queue)
            level = []
            for _ in range(size):
                node = queue.popleft()
                if not node:
                    continue
                level.append(node.val)
                for child in node.children:
                    queue.append(child)
            if level:
                res.append(level)
        return res
# @lc code=end

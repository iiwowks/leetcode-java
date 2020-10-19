#
# @lc app=leetcode.cn id=111 lang=python3
#
# [111] 二叉树的最小深度
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if root:
            if root.left and root.right:
                return min(self.minDepth(root.left),self.minDepth(root.right))+1
            elif root.left:
                return 1+self.minDepth(root.left)
            elif root.right:
                return 1+self.minDepth(root.right)
            else:
                return 1
        else:
            return 0

class Solution_1:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        children = [root.left, root.right]

        if not any(children):
            return 1
        min_depth = float('inf')

        # 直接使用递归 用深度优先搜索
        for c in children:
            if c:
                min_depth = min(self.minDepth(c), min_depth)

        return min_depth+1

#深度优先搜索迭代
class Solution_2:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        else:
            stack, min_depth =[(1,root),] , float('inf')
        while stack:
            depth,root=stack.pop()
            children=[root.left,root.right]
            if not any(children):
                min_depth=min(depth,min_depth)
            for c in children:
                if c:
                    stack.append((depth+1,c))

        return min_depth

#宽度优先搜索迭代
class Solution_3:
    def minDepth(self,root: TreeNode) -> int:
        pass

        # @lc code=end

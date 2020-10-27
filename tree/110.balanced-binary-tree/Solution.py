#
# @lc app=leetcode id=110 lang=python3
#
# [110] Balanced Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        def dfs(node, depth):
            if not node: return 0
            l = dfs(node.left, depth + 1)
            r = dfs(node.right, depth + 1)
            return max(l, r) + 1
        if not root: 
            return True
        elif abs(dfs(root.left, 0) - dfs(root.right, 0)) > 1 :
            return False
        else:
            return self.isBalanced(root.left) and self.isBalanced(root.right)
        
# @lc code=end


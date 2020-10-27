#
# @lc app=leetcode.cn id=106 lang=python3
#
# [106] Construct Binary Tree from Inorder and Postorder Traversal
#

# @lc code=start
# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def dfs(in_l, in_r, post_l, post_r):
            if post_l < post_r:
                return None
            inorder_root = Hash[postorder[post_l]]

            root = TreeNode(postorder[post_l])
            subtree_size = in_r - inorder_root
            root.right = dfs(inorder_root+1, in_r,
                             post_l-1, post_l-subtree_size)
            root.left = dfs(in_l, inorder_root-1,
                            post_l-subtree_size-1, post_r)
            return root

        Hash = {key: value for value, key in enumerate(inorder)}
        return dfs(0, len(inorder)-1, len(postorder)-1, 0)

# @lc code=end

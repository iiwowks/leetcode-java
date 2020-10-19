# 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
# 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


""" 解题思路
用前序遍历找到根结点
用根结点在中序遍历中切开左右子树，递归重建二叉树 """

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        #递归退出条件
        if not preorder:
            return None
        root_val = preorder[0]
        # 建立头节点
        root = TreeNode(root_val)


        #idx = inorder.index(preorder[0])
        for i in range(len(inorder)):
            # 找到中序遍历中头节点的下标
            if inorder[i] == root_val:
                break
        # 递归
        root.left = self.buildTree(preorder[1:1+i], inorder[:i])
        root.right = self.buildTree(preorder[i+1:], inorder[i+1:])

        return root

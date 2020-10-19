# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

def helper(treeA, treeB):
    if not treeB:
        return True
    elif not treeA:
        return False
    elif treeA.val != treeB.val:
        return False
    else:
        return helper(treeA.left, treeB.left) and helper(treeA.right, treeB.right)


class Solution(object):
    def isSubStructure(self, A, B):
        """
        :type A: TreeNode
        :type B: TreeNode
        :rtype: bool
        """
        if not A or not B: return False
        # B 是不是 A的子树
        res = False
        if A.val == B.val:
            res = helper(A, B)
        if res: 
            return True
        else:
            return self.isSubStructure(A.left, B) or self.isSubStructure(A.right, B)


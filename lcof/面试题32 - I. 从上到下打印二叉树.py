# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
""" 
解题思路
二叉树层次遍历，用队列存储每层结点，再依次弹出。
"""
class Solution:
    def levelOrder(self,root:TreeNode)->List[int]:
        if not root: return []
        #存树节点的队列
        queue=[root]
        res=[]
        while queue:
            #节点个数
            n=len(queue)
            for _ in range(n):
                if not queue: break
                node=queue.pop(0)
                res.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return res

                

'''
请实现一个函数按照之字形顺序打印二叉树，
即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印
第三行再按照从左到右的顺序打印，其他行以此类推。
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        queue=[root] #存树节点的队列
        res=[]
        level=0
        while queue: 
            n=len(queue)#节点个数 
            temp=[] #每次循环将temp[]置空
            for _ in range(n):
                if not queue: break
                node=queue.pop(0)
                temp.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            res.append(temp)
        for i in range(len(res)):
            if not i%2==0:
               res[i].reverse()   
        return res
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

#从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

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
        return res

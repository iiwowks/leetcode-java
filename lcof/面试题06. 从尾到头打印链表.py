# 输入一个链表头节点，从尾到头反过来返回每个结点的值 用数组返回
# Definition for singly-linked list.
from typing import List


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

#递归
class Solution:
    def reversePrint(self, head: ListNode) -> List[int]:
        if head == None:
            return []

        res = []
        self.helper(head, res)
        return res
    
    def helper(self, node, res):
        if node is None:
            return
        # 应该先判断下一个结点是否为空，如果不为空，则递归调用，在回溯的时候，才添加到结果中
        if node.next:
            self.helper(node.next, res)
        # 回溯时添加
        res.append(node.val)

#非递归
class Solution_2:
    def reversePrint(self,head:ListNode)->List[int]:
        p=head
        stack=[]
        while p:
            stack.append(p.val)
            p=p.next
        return stack[::-1]

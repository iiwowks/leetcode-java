'''
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点
'''
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def deleteNode(self, head: ListNode, val: int) -> ListNode:
        dummy = ListNode(0) #伪结点
        dummy.next = head
        if head.val == val:
            return head.next #头结点是要删除的点，直接返回
        while head and head.next:
            if head.next.val==val:  #找到了要删除的结点，删除
                head.next=head.next.next
            head=head.next
        return dummy.next
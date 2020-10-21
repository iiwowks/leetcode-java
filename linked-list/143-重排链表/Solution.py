#
# @lc app=leetcode.cn id=143 lang=python3
#
# [143] 重排链表
# 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        list_1 = list()
        node = head
        # 将所有结点存在list中
        while node:
            list_1.append(node)
            node = node.next
        
        # 双指针
        i, j = 0, len(list_1) - 1
        while i < j:
            list_1[i].next = list_1[j]
            i += 1
            # 这里需要一个判断
            if i == j:
                break
            list_1[j].next = list_1[i]
            j -= 1
        list_1[i].next = None
# @lc code=end


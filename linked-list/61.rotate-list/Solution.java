/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int length = 0;

    public void inital(ListNode head) {
        while (head != null) {
            length++;
            head = head.next;
        }
    }
    
    
    public ListNode rotateRight(ListNode head, int k) {
        inital(head);
        if (length < 2 || head == null) {
            return head;
        }
        return helper2(head, k % length);
    }
    
    
    public ListNode helper2(ListNode head, int k) {
                
        if (k == 0) {
            return head;
        }
        return helper2(helper(head), k - 1);
    }
    
    // 进行一次头尾节点反转
    public ListNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = head;
        
        while (head.next != null && head.next.next != null) {head = head.next;}
        
        // 指向倒数第二个节点
        if (head.next != null && head.next.next == null) {
            ListNode tempHead = head.next;
            tempHead.next = dummyHead;
            head.next = null;
            return tempHead;
        }
        // 指向倒数第一个节点
        return head;
    }
}
// @lc code=end


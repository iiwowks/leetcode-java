/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 * 题意：将两个链表形式表示的正整数相加，返回链表形式的result
 * 解题思路：链表直接转化为long值，相加后，创建result链表。
 * 最后的超长用例过不了。（超过了Long.MAX_VALUE）
 */

// @lc code=start
// 
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

// Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 8 -> 0 -> 7
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0, num2 = 0;
        while (l1 != null) {
            num1 = num1 * 10 + l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 = num2* 10 + l2.val;
            l2 = l2.next;
        }
        // System.out.println(num1);
        // System.out.println(num2);
        return helper(num1 + num2);
    }
    
    // 头插法创建链表
    public ListNode helper(long num) {
        System.out.println(num);

        ListNode temp = new ListNode((int)(num % 10));
        num /= 10;
        
        while (num > 0) {
            ListNode node = new ListNode((int)(num % 10));
            num /= 10;
            node.next = temp;
            temp = node;
        }
        return temp;
    }
}
// @lc code=end


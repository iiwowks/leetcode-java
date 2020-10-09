import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 * 解题思路：哈希表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            // 出现重复值
            if (!set.add(head)) {
                return false;
            }
            head = head.next;
        }
        return false;
    }
}

// @lc code=end


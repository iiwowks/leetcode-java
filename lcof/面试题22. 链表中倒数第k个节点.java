/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return head;
        ListNode temp = head;
        int length = 0;

        while(temp != null) {
            length++;
            temp = temp.next;
        }

        for(int i = 0; i < length - k; i++){
            head = head.next;
        }
        return head;
    }
}

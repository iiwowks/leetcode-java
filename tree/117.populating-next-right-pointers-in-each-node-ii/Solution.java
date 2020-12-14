/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        // 层次遍历的话，使用队列
        while (!queue.isEmpty()) {
            int length = queue.size();
            Node last = null;

            // 对于每一层
            for (int i = 0; i < length; i++) {
                Node temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                if (i != 0) {
                    last.next = temp; // 到最后的时候，queue.poll()是 null
                }
                last = temp;
            }
        }
        return root;
    }
}
// @lc code=end


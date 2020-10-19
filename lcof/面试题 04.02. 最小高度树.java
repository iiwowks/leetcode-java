/* 给定一个有序整数数组，元素各不相同且按升序排列，
编写一个算法，创建一颗高度最小的二叉搜索树 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//思路： 有序数组，取数组中间点为根节点，左边为左子树，右边为右子树，依次递归
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
    //  int mid = left + ((right-left) >> 1) ;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
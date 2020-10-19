// 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
// 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

class Solution{
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum){
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar){
        if( root == null){
            return;
        }
        path.add(root.val);
        tar -= root.val;
        if(tar  == 0 && root.left == null && root.right == null){
            res.add(new LinkedList(path));
        }

        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}


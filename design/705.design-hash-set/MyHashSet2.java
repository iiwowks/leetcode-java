/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 */

// 使用二叉搜索树作为桶
// @lc code=start
class MyHashSet2 {
    private Bucket[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i) {
            this.bucketArray[i] = new Bucket();
        }
    }
    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }
    
    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}

class Bucket {
    private BSTree tree;

    public Bucket() {
        tree = new BSTree();
    }
    
    public void insert(Integer key) {
        this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
    }

    public void delete(Integer key) {
        this.tree.root = this.tree.deleteNode(this.tree.root, key);
    }

    public boolean exists(Integer key) {
        TreeNode node = this.tree.searchBST(this.tree.root, key);
        return (node != null);
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) {
        val = x;
    }
}


class BSTree {
    TreeNode root = null;
    
    // 查找二叉搜索树
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
    // 插入二叉搜索树
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val); // 插入右节点
        }
        else if (val == root.val) {
            return root; // 值相同时，跳过这次插入
        }
        else {
            root.left = insertIntoBST(root.left, val); // 插入左节点
        }
        return root;
    }

    // 一步右，然后到最左下端
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    // 一步左，然后到最右下端
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    // 删除搜索二叉树节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 从右子树中删除
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // 从左子树中删除
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // key == root.val的时候
        else {
            // 叶节点
            if (root.left == null && root.right == null){
                root = null;
            }
            // 非叶节点，并有右孩子
            else if (root.right != null) {
                root.val = successor(root); // 右子树中最左下端节点值，作为
                root.right = deleteNode(root.right, root.val); // 从右子树中删除
            }
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end


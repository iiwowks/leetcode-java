/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 * 解题思路： 使用并查集，看有多少个孤立的集合
 * 1. n --> 各自独立的集合
 * 2. 遍历矩阵： M[i][j] --> 合并
 */

// @lc code=start
class Solution {
    class UnionFind {
        private int count = 0; // 集合size
        private int[] parent;

        // 初始化parent[i] = i, 自己指向自己
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) { // 集合领头元素：parent[i] == i
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p); // 找到两个领头元素
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            parent[rootP] = rootQ;
            count--; // 独立的集合减少了一个
        }

        public int count() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count();
    }
}
// @lc code=end


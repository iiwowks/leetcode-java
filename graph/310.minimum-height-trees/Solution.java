/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
// 0 ~ n - 1标号的节点中：找到所有头节点，使得以这个节点为root的树，高度最小。
// 相当于把一个图，从外向里，每次循环 ‘剥去一层’
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // base case
        if (n < 2) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        // 用一个 list<set<>> 建立保存表示一个图
        List<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        // 对第一层 叶子节点
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 每个set中存放的Integer序号，相当于无向图中中该节点的neighbor
            if (neighbors.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // 
        int remainNodes = n;
        while (remainNodes > 2) {
            remainNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            
            // 
            for (Integer leaf : leaves) {
                // 获取这个叶子节点的邻居
                for (Integer neighbor : neighbors.get(leaf)) {
                    // 删除该邻居节点与 leaf相连的边
                    neighbors.get(neighbor).remove(leaf);
                    if (neighbors.get(neighbor).size() == 1) {
                        newLeaves.add(neighbor);
                    }
                }   
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
// @lc code=end


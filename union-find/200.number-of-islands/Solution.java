/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 * 解题思路：DFS
 * 1. 将数组看成无向图的邻接矩阵
 * 2. 扫描整个二维网格。如果一个位置为 1，则以其为起始节点开始进行深度优先搜索。
 * 3. 在深度优先搜索的过程中，每个搜索到的 1 都会被重新标记为 0。
 * 4. 最终岛屿的数量就是我们进行深度优先搜索的次数。
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    ++res;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
// @lc code=end


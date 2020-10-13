/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 * 解题思路： DFS
 * 选择一个节点，访问任一相邻的节点。然后再访问这一节点的任一相邻节点。
 * 这样不断遍历到没有未访问的相邻节点时，回溯到之前的节点进行访问。
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    /**
     * 
     * @param M
     * @param visited visited[i] 表示第 i 个元素是否被深度优先搜索访问过
     * @param i
     */
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
// @lc code=end

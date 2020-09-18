import java.util.Queue;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 * 解题思路： BFS
 * 从任一个节点开始广搜，使用 visitedvisited 数组记录是否被访问过。
 * 增加 countcount 变量当一个连通块已经访问完但是还有节点没有被访问的时候
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // M.length个节点
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while(!queue.isEmpty()) {
                    int s = queue.poll();
                    visited[s] = 1;
                    // 子节点入队
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
// 深度优先遍历：
// 4 * 3 的数组a[4][3] : a.length == 3, a[0].length == 4;
class Solution {
    int n, m;
    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        // x 方向上的遍历
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m -1);
        }
        // y 方向上的遍历
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        // 对整个数组遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // 深度优先遍历: 将所有与边缘相连的'O'标记为'A'
    public void dfs(char[][] board, int x, int y) {
        // dfs出口：是'X'就返回，是'O'就标记为'A'
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';    // 遍历过的位置做标记
        dfs(board, x + 1, y); // 向右
        dfs(board, x - 1, y); // 向左
        dfs(board, x, y + 1); // 向上
        dfs(board, x, y - 1); // 向下
    }
}

// @lc code=end


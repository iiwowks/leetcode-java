/**
 * [1588. 矩阵的最大非负积]
 * 
 */
/*
[[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]] 这个用例
*/
class Solution3 {
    int rows = 0;
    int cols = 0;
    long max =Long.MIN_VALUE;

    public int maxProductPath(int[][] grid) {
        int mod = 1000000007;
        this.rows = grid.length;
        this.cols = grid[0].length;
        dfs(grid, 0, 0, 1);
        max %= mod;
        return max < 0 ? -1 : (int)max;
    }

    /**
     * 状态树自顶向下：传入下一层temp result
     * @param gird
     * @param i
     * @param j
     * @param res
     * @return
     */
    private void dfs(int[][] grid, int i, int j, long temp) {
        if (i > rows - 1 || j > cols - 1) {
            return;
        }
        if (temp == 0) {
            max = Math.max(max, 0);
            return;
        }
        if (i == rows - 1 && j == cols - 1) {
            max = Math.max(max, temp * grid[i][j]);
            return;
        }

        dfs(grid, i + 1, j, temp * grid[i][j]);
        dfs(grid, i, j + 1, temp * grid[i][j]);
        return;
    }
}
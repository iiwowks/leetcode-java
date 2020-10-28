/*
 * @lc app=leetcode id=799 lang=java
 *
 * [799] Champagne Tower
 * * 模拟：
 * 对于一个杯子：总共流入 x, 流入下一层 (x - 1.0) / 2.0
 */

// @lc code=start
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = (double) poured;
        for (int i = 0; i <= query_row; ++i) {
            for (int j = 0; j <= i; ++j) {
                double q = (A[i][j] - 1.0) / 2.0;
                if (q > 0) {
                    A[i + 1][j] += q;
                    A[i + 1][j + 1] += q;
                }
            }
        }
        return Math.min(1, A[query_row][query_glass]);
    }
}
// @lc code=end

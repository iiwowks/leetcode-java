/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
// 思路：生成一个n*n的空矩阵
//      1. 定义当前的左右上下边界l, r, t, b, 初始值num = 1, 迭代终止值：tar = n * n
//      2. 当 num <= tar 时，顺时针填入矩阵，同时更新边界

class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1; // 左右上下边界值
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar) {
            for (int i = 1; i <= r; i++) mat[t][i] = num++;
            t++; // 更新边界
            for (int i = t; i <= b; i++) mat[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++;
            l++;
        }
        return mat;
    }
}
// @lc code=end


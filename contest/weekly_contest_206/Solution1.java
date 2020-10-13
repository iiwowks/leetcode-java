/**
 * 5511. 二进制矩阵中的特殊位置
 * https://leetcode-cn.com/problems/special-positions-in-a-binary-matrix/
 */
class Solution1 {
    public int numSpecial(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (check(mat, i, j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    
    private boolean check(int[][] mat, int x, int y) {
        int countZeroX = 0, countZeroY = 0;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][y] == 0) countZeroY++;
        }
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[x][j] == 0) countZeroX++;
        }
        if (countZeroX == mat[0].length - 1 && countZeroY == mat.length - 1) return true;
        return false;
    }
}
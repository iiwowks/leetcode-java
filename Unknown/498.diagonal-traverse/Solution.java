/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start
// border : (0, y) (x, 0)
// border : (M - 1, y) (x, N - 1)
// x + y = 0, 1, 2, ...., M + N - 2
// xiang xia: (x + 1, y - 1)
// xiang shang: (x - 1, y + 1)

class Solution {
    
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[] res = new int[M * N];
        
        int k = 0;
        List<Integer> temp = new ArrayList<>();
        // 从第一行和最后一列开始，遍历所有元素
        for (int index = 0; index < M + N - 1; index++) {
            temp.clear();
            // 在第一行和最后一列的元素是所有斜序列的头
            int x = index < N ? 0 : index - N + 1;
            int y = index < N ? index : N - 1;
            // 斜向左下角遍历
            while (x < M && y > -1) {
                temp.add(matrix[x][y]);
                x++;
                y--;
            }
            // 
            if (index % 2 == 0) {
                Collections.reverse(temp);
            }
            for (int i = 0; i < temp.size(); i++) {
                res[k++] = temp.get(i);
            }
        }
        return res;
    }
}
// @lc code=end


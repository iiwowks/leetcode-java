/**
 * LCP 19. 秋叶收藏集
 * 1. sum[] 数组： 表示[0, x)之间的红叶数量
 * 2. (i - sum[i]) + (n - j - sum[n] + sum[j]) + (sum[j] - sum[i])
 * 3. 整理后得：
 * 4. n - sum[n] + (i - 2 * sum[i]) + (j - 2 * sum[j])    0 < i < j < n
 * 
 */

class Solution3 {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        char[] array = leaves.toCharArray();
        int[] sum = new int[n + 1];

        // 初始化sum[]
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (array[i] == 'r' ? 1 : 0);
        }
        int[] min = new int[n + 1];
        int currentMin = Integer.MAX_VALUE;
        // 初始化min[]
        for (int i = 1; i < n - 1; i++) {
            currentMin = Math.min(currentMin, i - 2 * sum[i]);
            min[i] = currentMin;
        }
        //
        int res = Integer.MAX_VALUE;
        for (int j = n - 1; j > 1; j--) {
            res = Math.min(res, n - sum[n] + min[j - 1] - j + 2 * sum[j]);
        }
        return res;
    }
}

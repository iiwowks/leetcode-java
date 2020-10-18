/**
 * [5527. 大小为 K 的不重叠线段的数目]
 * 
 */

class Solution3 {
    private static long mod = 1000000007;
    private static int MAXN = 1050;
    private long[][] dp;

    public int numberOfSets(int n, int k) {
        this.dp = new long[MAXN][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0] = dp[i][1] = 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                dp[j][0] = (dp[j][0] + dp[j][1]) % mod;
                dp[j][1] = (dp[j - 1][0] + dp[j][1] + dp[j - 1][1]) % mod;
            }
        }
        return (int) ((dp[k][0] + dp[k][1]) % mod);
    }
}


// put solution class below
class Solution1 {
    public int fib(int n) {
        if(n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 5;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i - 3];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    // main test
    public static void main(String[] args) {

        Solution1 solution = new Solution1();
        int res = solution.fib(30);
        // write test case
        System.out.println(res);
    }
}
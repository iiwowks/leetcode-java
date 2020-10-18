/**
 * [5527. 大小为 K 的不重叠线段的数目] 
 * 
 */

#include <iostream>
using namespace std;

#define LL long long
const LL MOD = 1e9 + 7;

const int MAXN = 1000 + 50;
LL dp[MAXN][2];

class Solution
{
public:
    int numberOfSets(int n, int K)
    {
        for (int i = 0; i <= K; i++)
            dp[i][0] = dp[i][1] = 0;
        dp[0][0] = 1;

        for (int i = 1; i < n; i++)
        {
            for (int k = K; k >= 1; k--)
            {
                dp[k][0] = (dp[k][0] + dp[k][1]) % MOD;
                dp[k][1] = (dp[k - 1][0] + dp[k][1] + dp[k - 1][1]) % MOD;
            }
        }

        return (dp[K][0] + dp[K][1]) % MOD;
    }
};
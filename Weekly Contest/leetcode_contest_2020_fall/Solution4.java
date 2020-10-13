/**
 * LCP 20. 快速公交
 */

class Solution4 {
    Map<Long, Long> mp = new HashMap<>();

    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        mp.put(0L, 0L);
        mp.put(1L, (long) inc);
        return (int) (dfs((long) target, inc, dec, jump, cost) % 1000000007);
    }

    public long dfs(long target, int inc, int dec, int[] jump, int[] cost) {
        if (mp.containsKey(target))
            return mp.get(target);
        long ans = (target * inc);

        for (int i = 0; i < jump.length; i++) {
            long temp1 = target - target % jump[i];
            long temp2 = target + jump[i] - target % jump[i];

            if (temp1 > 0) {
                ans = Math.min(ans, dfs(temp1 / jump[i], inc, dec, jump, cost) + cost[i] + inc * (target - temp1));
            }
            if (temp2 < 2 * target) {
                ans = Math.min(ans, dfs(temp2 / jump[i], inc, dec, jump, cost) + cost[i] + dec * (temp2 - target));
            }
        }

        mp.put(target, ans);
        return ans;
    }
}

/**
 * my wrong answer
 */

class Solution {
    int inc, dec;
    int[] jump;
    int[] cost;
    int length;
    int mod = 1000000007;

    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        this.inc = inc;
        this.dec = dec;
        this.jump = jump;
        this.cost = cost;
        this.length = jump.length;

        return dfs(target) % mod;
    }

    private int dfs(int target) {

        int ans = Integer.MAX_VALUE;
        // 出口
        if (target == 1)
            return inc;
        if (target == 0)
            return 0;

        for (int i = 0; i < length; i++) {
            int tempMin1 = Math.min(dfs(target + 1) + dec, dfs(target - 1) + inc);
            int tempMin2 = (target % jump[i] == 0 ? dfs(target / jump[i]) + cost[i] : Integer.MAX_VALUE);
            ans = Math.min(tempMin1, tempMin2);
        }
        return ans;
    }
}
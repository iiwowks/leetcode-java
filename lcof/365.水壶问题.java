/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */
//贝祖定理
//ax+by=z 有解当且仅当 z 是 x,y 的最大公约数的倍数。
//因此我们只需要找到 x,y 的最大公约数并判断 z 是否是它的倍数即可。

// @lc code=start
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == x + y || z == x || z == y || z == 0)
            return true;
        if (x == 0 || y == 0 || z > x + y || z % gcd(x, y) != 0) {
            return false;
        }
        return true;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

// @lc code=end

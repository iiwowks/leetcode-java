// 实现函数double Power(double base, int exponent)，求base的exponent次方。
// 不得使用库函数，同时不需要考虑大数问题。


class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
}
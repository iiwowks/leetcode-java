/**
 * LCP 18. 早餐组合 双指针
 */
class Solution2 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        int j = drinks.length - 1;

        for (int i = 0; i < staple.length; i++) {
            if (j < 0)
                break;
            // 找到j 的位置
            while (j >= 0 && staple[i] + drinks[j] > x) {
                j--;
            }
            res += j + 1;
        }
        return res % 1000000007;
    }
}
// 另外一种写法，本质相同
class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        int i = 0, j = drinks.length - 1;

        while (i < staple.length && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                res = (res + j + 1) % 1000000007;
                i++;
            } else {
                j--;
            }
        }
        return res % 1000000007;
    }
}
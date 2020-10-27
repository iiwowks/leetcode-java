/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    int count = 0;
    public boolean isHappy(int n) {
        if (count++ > 10) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        List<Integer> res = new ArrayList<Integer>();
        while (n != 0) {
            res.add(n % 10);
            n /= 10;
        }
        int temp = 0;
        for (int i = 0; i < res.size(); i++) {
            temp += res.get(i) * res.get(i);
        }
        return isHappy(temp);
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        int temp = 0;
        while (num > 0) {
            temp += num % 10;
            num /= 10;
            if (num == 0 && temp > 9) {
                num = temp;
                temp = 0;
            }
        }
        return temp;
    }
}
// @lc code=end


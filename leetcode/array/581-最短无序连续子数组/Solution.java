/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
// 解题思路： 正向找到第一个逆序对 [左边界, 右边界]。
//　この世界で一番美しい花は何ですか、ひまわりだと思う。
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        // 在向左边循环的过程中，已经动态的更新左边界和右边界
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - 1 < 0 ? 0 : r - l + 1;
    }
}
// @lc code=end


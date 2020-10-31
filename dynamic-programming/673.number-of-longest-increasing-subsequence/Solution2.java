/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 * 动态规划
 * 写法不同
 */

// @lc code=start
class Solution2 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] length = new int[n], count = new int[n];
        //
        for (int i = 0; i < n; i++) {
            length[i] = count[i] = 1;
            // update array
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // case 1
                    if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                    // case 2
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            //
            if (max_len == length[i]) {
                res += count[i];
            }
            if (max_len < length[i]) {
                max_len = length[i];
                res = count[i];
            }
        }
        return res;
    }
}
// @lc code=end


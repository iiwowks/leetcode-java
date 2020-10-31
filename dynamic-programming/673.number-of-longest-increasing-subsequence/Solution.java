/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 * 动态规划
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        // 以nums[j] 结尾的最长增序序列长度
        int[] lengths = new int[N];
        // 以nums[j] 结尾的最长增序序列个数
        int[] counts = new int[N];
        // counts[]初始化为 1
        Arrays.fill(counts, 1);

        // 更新状态数组
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 
                if (nums[j] < nums[i]) {
                    // case1: 增序序列中不跳过一些数，就是连续子序列
                    if (lengths[j] >= lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    }
                    // case2: 增序序列中跳过一些数，断续子序列
                    else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
        }

        int longest = 0, res = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        for (int j = 0; j < N; j++) {
            if (lengths[j] == longest) {
                res += counts[j];
            }
        }
        return res;
    }
}
// @lc code=end


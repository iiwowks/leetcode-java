/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列
 */

// 方法：暴力全排列set去重
// @lc code=start

public class Solution {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] num) {
        dfs(num, 0);
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    
    private void dfs(int[] nums, int cur) {
        if (cur == nums.length) {
            List<Integer> line = new ArrayList<>();
            for (int i : nums) {
                line.add(i);
            }
            set.add(line);
        } else {
            for (int i = cur; i < nums.length; i++) {
                swap(nums, cur, i);
                dfs(nums, cur + 1);
                swap(nums, cur, i);
            }
        }
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 * 问题：给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 解题思路：使用used[]数组记录使用状态，递归遍历
 * 1. 重点去重
 * if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
 *  continue;
 * }
 * 1. 一个数不能重复选
 * 2. 不能产生重复的排列： 排序后， 在同一层的可选项选择一个
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);

        dfs(nums, used, list, res);
        return res;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            // new ArrayList<Integer>(list)只是List<Integer>接口的实现类， 相当于： List<Integer> list = new ArrayList<Integer>();
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 去重：
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

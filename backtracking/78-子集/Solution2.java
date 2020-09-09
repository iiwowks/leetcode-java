/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        // 终止条件
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        // 不选择在index这个数
        dfs(ans, nums, list, index + 1);
        // 选择在index 这个数
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);
        // 状态重置
        list.remove(list.size() - 1);
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 * 方法一： 搜索回溯
 * dfs(target, combine, index)
 *      1. 跳过第index个数， 执行dfs(target, combine, index + 1)
 *      2. 使用第index个数,  执行dfs(target - candidates[index], combine, index)
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;

    }
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, index + 1);
        // 选择当前数
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], ans, combine, index);
            combine.remove(combine.size() - 1);
        }
    }
}
// @lc code=end


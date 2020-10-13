/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 * 问题：给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * 解题思路：搜索回溯法
 * 0. 画出递归树，更加明显
 * 1. 做这种题需要注意，backtrack函数的传入参数
 */

// @lc code=start

class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    /**
     * 
     * @param list      result
     * @param tempList  存储中间结果
     * @param nums
     * @param remain    每一层剩余target目标值
     * @param start     start index
     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) 
            list.add(new ArrayList<>(tempList)); // 添加到结果集
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // 剪枝操作，跳过重复值

                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// @lc code=end


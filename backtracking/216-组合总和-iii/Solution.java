/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 * 问题：找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(new ArrayList<>(), k, n, 1);
        return res;
    }

    /**
     * 
     * @param tempList  存中间结果
     * @param k
     * @param remain    剩余target值
     * @param start     start index
     */
    private void backtrack(List<Integer> tempList, int k, int remain, int start) {
        if (remain < 0 || tempList.size() > k) {
            return;
        } else if (remain == 0 && tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
        } else {
            // i 在 1~9 之间遍历
            for (int i = start; i < 10; i++) {
                tempList.add(i);
                backtrack(tempList, k, remain - i, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// @lc code=end

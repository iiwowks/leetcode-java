import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;
    List<Integer> temp;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int curSum, int cur_index) {
        if (curSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (curSum > target) {
            return;
        }
        for (int i = cur_index; i < candidates.length; i++) {
            if (i > cur_index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            dfs(candidates, target, curSum + candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

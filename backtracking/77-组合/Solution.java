import java.util.ArrayDeque;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();

        dfs(n, k, 1, path, res);
        return res;
    }
    private void dfs(int n, int k , int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 终止条件: path.size() == k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 路径变量中添加一个数
            path.addLast(i);
            // 下一轮搜索，设置搜索起点 + 1
            dfs(n, k, i + 1, path, res);
            // 状态重置
            path.removeLast();
        }
    }
}
// @lc code=end


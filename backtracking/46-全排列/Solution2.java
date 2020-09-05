import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列：给定一个没有重复 数字的序列，返回其所有可能的全排列
 * 
 */

// @lc code=start
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len]; // 初始化时是false
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    /**
     * 
     * @param nums
     * @param len
     * @param depth：表示dfs到了第几层
     * @param path：用stack存储当前的路径
     * @param used：表示nums[]中已经使用了的数字
     * @param res： 在本层将path添加到res中
     */
    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) { // 递归终止条件
            res.add(new ArrayList<>(path)); // 添加path的拷贝
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            // 弄完一个数
            dfs(nums, len, depth + 1, path, used, res);
            // 回到了这一层，状态重置
            path.removeLast();
            used[i] = false;
        }
    }
}
// @lc code=end

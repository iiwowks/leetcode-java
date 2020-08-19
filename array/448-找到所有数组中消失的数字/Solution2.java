/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int[] checked = new int[n + 1];
        for (int i = 0; i <= n; i++) checked[i] = 0;
        for (int i = 0; i < n; i++) {
            if (checked[nums[i]] == 0) {
                checked[nums[i]] = 1; // 标记为检查过了
            }
        }
        for (int i = 1; i <= n; i++) {
            if (checked[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end


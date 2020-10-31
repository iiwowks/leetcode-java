/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        
        for (int i, j = 0; j < nums.length; j++) {
            i = j;
            // 拓展[nums[i], num[j]]的范围
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            if (i == j) {
                summary.add(nums[i] + "");
            } else {
                summary.add(nums[i] + "->" + nums[j]);
            }
        }
        return summary;
    }
}
// @lc code=end


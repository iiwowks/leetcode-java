/*
 * @lc app=leetcode id=1288 lang=java
 *
 * [1288] Remove Covered Intervals
 * 解题思路：枚举
 * 
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int res = n;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (i != j && intervals[j][0] <= intervals[i][0] && intervals[i][1] <= intervals[j][1]) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

import java.util.Comparator;

/*
 * @lc app=leetcode id=1288 lang=java
 *
 * [1288] Remove Covered Intervals
 * 解题思路：greedy
 * 
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // sort by start point
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }            
        });

        int count = 0;
        int end, prev_end = 0;
        for (int[] curr : intervals) {
            end = curr[1];
            if (prev_end < end) {
                ++count;
                prev_end = end;
            }
        }
        return count;
    }
}
// @lc code=end

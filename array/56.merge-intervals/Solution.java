/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
// 题意： 给定一个区间数组，合并区间数组
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[0][0];
        // 以起点 升序排列
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] temp = intervals[i];
            int j = i + 1;
            // 拓展右边界
            while (j < n && intervals[j][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j += 1;
            }
            i = j - 1;
            res.add(temp);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end


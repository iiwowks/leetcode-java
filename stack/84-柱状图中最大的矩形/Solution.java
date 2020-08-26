/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// 方法一：暴力解法
// 依次遍历柱形的高度，对每一个高度向两边扩散，求出当前高度为矩形的最大宽度

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 找到左边最后一个 >= heights[i]的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            // 找到右边最后一个 >= heights[i]的下标
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }            
            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;        
    }
}
// @lc code=end


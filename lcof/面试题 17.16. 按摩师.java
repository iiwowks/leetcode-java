// 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
// 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
// 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。





class Solution {
    public int massage(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        if(len == 1) {
            return nums[1];
        }

        // dp[i]:表示[0,i]里接受预约请求的最大时长
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < len; i++){
            
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);

        }
        return dp[len-1];
    }
}
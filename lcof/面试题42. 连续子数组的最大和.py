"""
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
求所有子数组的和的最大值。要求时间复杂度为O(n)。
 """
# 解题思路
# 我们在原地修改数组，将数组每个位置的值更改为当前位置上的最大和。
# 解题思路
# 动态规划：

# dp[i] = dp[i-1] + p[i]   # if i != 0 and dp[i-1] > 0
# dp[i] = p[i]             # if i == 0 or dp[i-1] < 0

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxnum=nums[0]
        for i in range(1,len(sum)):
            if nums[i-1]>0:
                nums[i]+=nums[i-1]
                maxnum=max(nums[i],maxnum)
        return maxnum

class Solution(object):
    def maxSubArray(self, array):
        max = array[0]
        dp = [0] * (len(array) + 1)
        dp[0] = array[0]
        for i in range(1, len(array)):
            if dp[i-1] < 0:
                dp[i] = array[i]
            else:
                dp[i] = array[i] + dp[i-1]
            if dp[i] > max:
                max = dp[i]
        return max


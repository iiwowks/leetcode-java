#
# @lc app=leetcode.cn id=912 lang=python3
#
# [912] 排序数组
# 插入排序
#

# @lc code=start
from typing import List

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)
        for i in range(1, size):
            temp = nums[i]
            j = i
            while j > 0:
                if nums[j - 1] > temp:
                    nums[j] = nums[j - 1]
                else:
                    break
                j -= 1
            nums[j] = temp
        return nums
# @lc code=end


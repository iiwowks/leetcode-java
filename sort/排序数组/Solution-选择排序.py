#
# @lc app=leetcode.cn id=912 lang=python3
#
# [912] 排序数组
# 选择排序

# @lc code=start
from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)

        for i in range(size - 1):
            min_index = i
            for j in range(i + 1, size):
                if nums[j] < nums[min_index]:
                    min_index = j
            nums[i], nums[min_index] = nums[min_index], nums[i]
        return nums
# @lc code=end

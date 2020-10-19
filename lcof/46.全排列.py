#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列 给定一个没有重复数字的序列，返回其所有可能的全排列。
#

# @lc code=start
# 思路一：库函数
# import itertools
# class Solution:
#     def permute(self, nums: List[int]) -> List[List[int]]:
#         return list(itertools.permutations(nums))

#思路二：回溯
class Solution:
    def permute(self, nums):
        res = []
        def backtrack(nums, tmp):
            if not nums:
                res.append(tmp)
                return 
            for i in range(len(nums)):
                backtrack(nums[:i] + nums[i+1:], tmp + [nums[i]])
        backtrack(nums, [])
        return res


print(Solution().permute([1,2,3]))
# @lc code=end


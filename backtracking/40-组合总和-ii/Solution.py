#
# @lc app=leetcode.cn id=40 lang=python3
#
# [40] 组合总和 II
#

from typing import List

# @lc code=start
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(begin, path, target):
            if target == 0:
                res.append(path[:])
                return
            for index in range(begin, size):
                if candidates[index] > target:
                    break
                if index >begin and candidates[index - 1] == candidates[index]:
                    continue
                path.append(candidates[index])
                dfs(index + 1, path, target - candidates[index])
                path.pop()

        size = len(candidates)
        if size == 0:
            return []
        candidates.sort()
        res = []
        dfs(0, [], target)
        return res

# @lc code=end

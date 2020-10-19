#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
#

# @lc code=start
class Solution_回溯:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[[]]
        n=len(nums)


        def helper(i,tmp):  # i表示路径，tmp表示选择列表
            res.append(tmp)
            for j in range(i,n):
                helper(j+1,tmp+[nums[j]])
        helper(0,[])
        return res

class Solution_迭代:
    def subsets(self,nums: List[int])->List[List[int]]:
        res=[[]]
        for i in nums:
            res=res+[[i]+num for num in res]
        return res
print(Solution_迭代().subsets([1,2,3,4]))
# @lc code=end


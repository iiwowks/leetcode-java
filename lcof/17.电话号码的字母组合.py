#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#

# @lc code=start
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}        
        
        #路径：combination 目前已经产生的组合
        #选择列表：next_digits 接下来要输入的数字
        def backtrack(combination,next_digits):
            # if 满足结束条件:
            #     result.add(路径)
            # return
            if len(next_digits)==0:
                output.append(combination)
            # for 选择 in 选择列表:
            #       做选择
            # backtrack(路径, 选择列表)
            #       撤销选择
            else:
                for letter in phone[next_digits[0]]:
                    backtrack(combination+letter,next_digits[1:])

        output=[]
        if digits:
            backtrack("",digits)
        return output

# @lc code=end

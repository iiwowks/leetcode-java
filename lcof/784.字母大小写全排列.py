#
# @lc app=leetcode.cn id=784 lang=python3
#
# [784] 字母大小写全排列
#
""" 
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

输入: S = "3z4"
输出: ["3z4", "3Z4"]

输入: S = "12345"
输出: ["12345"]
注意：

S 的长度不超过12。
S 仅由数字和字母组成 """

# @lc code=start
# 思路 :从左到右遍历字符，过程中保持ans为已遍历过字符的字母大小全排列
# 如果下一个字符c是字母，就把当前已遍历过的字符串全排列复制两份，第一份末尾添加lowercase(c),第二份末尾添加uppercase(c)


class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        ans = [[]]

        for char in S:
            n = len(ans)
            if char.isalpha():
                for i in range(n):
                    ans.append(ans[i][:])  # 在后面复制数组
                    ans[i].append(char.lower())
                    ans[n+i].append(char.upper())
            else:
                for i in range(n):
                    ans[i].append(char)
        return map("".join, ans)


class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        res = [S]
        for i, c in enumerate(S):
            if c.isalpha():
                # extend() 函数用于在列表末尾一次性追加另一个序列中的多个值（用新列表扩展原来的列表）。
                res.extend([s[:i]+s[i].swapcase()+s[i+1:] for s in res])


# @lc code=end

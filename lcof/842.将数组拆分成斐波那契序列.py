#
# @lc app=leetcode.cn id=842 lang=python3
#
# [842] 将数组拆分成斐波那契序列
#

# 思路：主要是回溯过程中的剪枝优化，减去了值大于2 ** 31 - 1和不符合F[i] + F[i + 1] = F[i + 2]的部分。 还有就是new_value以'0'开头并且长度大于1的部分，需要注意'0'是符合条件的数字。

# @lc code=start
class Solution(object):
    def splitIntoFibonacci(self, S):
        for i in range(min(10, len(S))):
            x = S[:i+1]
            if x != '0' and x.startswith('0'): break
            a = int(x)
            for j in range(i+1, min(i+10, len(S))):
                y = S[i+1: j+1]
                if y != '0' and y.startswith('0'): break
                b = int(y)
                fib = [a, b]
                k = j + 1
                while k < len(S):
                    nxt = fib[-1] + fib[-2]
                    nxtS = str(nxt)
                    if nxt <= 2**31 - 1 and S[k:].startswith(nxtS):
                        k += len(nxtS)
                        fib.append(nxt)
                    else:
                        break
                else:
                    if len(fib) >= 3:
                        return fib
        return []
# @lc code=end

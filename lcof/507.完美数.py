#
# @lc app=leetcode.cn id=507 lang=python3
#
# [507] 完美数
#

# @lc code=start


class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num == 1:
            return False
        sum,i = 1,2
        while i*i<num:
            if num % i == 0:
                sum += i+num/i
            i+=1
        if i*i == num:
            sum += i
        return sum == num

class Solution_original:
    def checkPerfectNumber(self, num: int) -> bool:
        if num <= 1:
            return False

        i, result = 0, [1, ]
        for i in range(2, num//2+1):
            if num % i == 0:
                result.append(i)
                i = i+1
        print(result)
        if num == sum(result):
            return True

# @lc code=end

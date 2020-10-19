#
# @lc app=leetcode.cn id=93 lang=python3
#
# [93] 复原IP地址
#

# @lc code=start
# 暴力解法


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        n = len(s)
        res = []

        def helper(tmp):
            # 判断 非零 二位数及以上不以零开头 不大于255
            if not tmp or (tmp[0] == '0' and len(tmp) > 1) or int(tmp) > 255:
                return False
            return True
        for i in range(3):
            for j in range(i+1, i+4):
                for k in range(j+1, j+4):
                    if i < n and j < n and k < n:
                        tmp1 = s[:i+1]
                        tmp2 = s[i+1:j+1]
                        tmp3 = s[j+1:k+1]
                        tmp4 = s[k+1:]
                        # print(tmp1,tmp2,tmp3,tmp4)
                        if all(map(helper, [tmp1, tmp2, tmp3, tmp4])):
                            res.append(tmp1+'.'+tmp2+'.'+tmp3+'.'+tmp4)
        return res

#回溯法
class Solution:
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def valid(segment):
            """
            Check if the current segment is valid :
            1. less or equal to 255      
            2. the first character could be '0' 
               only if the segment is equal to '0'
            """
            return int(segment) <= 255 if segment[0] != '0' else len(segment) == 1
            
        def update_output(curr_pos):
            """
            Append the current list of segments 
            to the list of solutions
            """
            segment = s[curr_pos + 1:n]
            if valid(segment):
                segments.append(segment)
                output.append('.'.join(segments))
                segments.pop()    
            
        def backtrack(prev_pos = -1, dots = 3):
            """
            prev_pos : the position of the previously placed dot
            dots : number of dots to place
            """
            # The current dot curr_pos could be placed 
            # in a range from prev_pos + 1 to prev_pos + 4.
            # The dot couldn't be placed 
            # after the last character in the string.
            for curr_pos in range(prev_pos + 1, min(n - 1, prev_pos + 4)):
                segment = s[prev_pos + 1:curr_pos + 1]
                if valid(segment):
                    segments.append(segment)  # place dot
                    if dots - 1 == 0:  # if all 3 dots are placed
                        update_output(curr_pos)  # add the solution to output
                    else:
                        backtrack(curr_pos, dots - 1)  # continue to place dots
                    segments.pop()  # remove the last placed dot
        
        n = len(s)
        output, segments = [], []
        backtrack() 
        return output

# @lc code=end
# temp=100
# if not temp:
#     print("True")
# else:
#     print("False")

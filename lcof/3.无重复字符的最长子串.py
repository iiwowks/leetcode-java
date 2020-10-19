#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] 无重复字符的最长子串
#

# @lc code=start


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        L = []
        ans, i, j = 0, 0, 0
        while i < n and j < n:
            if s[j] not in L:
                L.append(s[j])
                j += 1
                ans = max(ans, j-i)
            else:
                L.remove(s[i])
                i += 1
        return ans

class Solution_2:
    def lengthOfLongestSubstring(self,s:str)->int:
        st={}
        i,ans=0,0
        for j in range(len(s)):
            if s[j] in st:
                i=max(st[s[j]],i)
            ans=max(ans,j-i+1)
            st[s[j]]=j+1
        return ans
        
# @lc code=end

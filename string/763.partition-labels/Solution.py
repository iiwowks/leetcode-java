#
# @lc app=leetcode id=763 lang=python3
#
# [763] Partition Labels
#

# @lc code=start
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        last = [0] * 26
        for i, char in enumerate(S):
            last[ord(char) - ord('a')] = i
        partition = list()
        start = end = 0
        for i, char in enumerate(S):
            end = max(end, last[ord(char) - ord('a')])
            if i == end:
                partition.append(end - start + 1)
                start = end + 1
        return partition
# @lc code=end


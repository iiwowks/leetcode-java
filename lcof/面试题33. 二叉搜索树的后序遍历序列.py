'''
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
'''
#思路：二叉搜索树：1.结点值：左<根<右  2.左右子树都是搜索树
# 后根遍历顺序：左->右->根 最后一个数为根节点，
# 通过根节点值切割左右子树，判断左右子树是否二叉搜索树

def helper(sequence):
    if len(sequence) <= 1: return True
    root = sequence[-1]
    for i in range(len(sequence)):
        if sequence[i] > root:
            break
    for j in range(i, len(sequence)-1):
        if sequence[j] < root:
            return False
    return helper(sequence[:i]) and helper(sequence[i:-1])

class Solution(object):
    def verifyPostorder(self, sequence):
        if not sequence: return True
        return helper(sequence)

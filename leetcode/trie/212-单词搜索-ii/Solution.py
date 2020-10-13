#
# @lc app=leetcode.cn id=212 lang=python3
#
# [212] 单词搜索 II
# fuck dog like a pig

# @lc code=start
import collections

class TrieNode():
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.isWord = False        

class Trie():
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root
        for w in word:
            node = node.children[w]
        node.isWord = True
    
    def search(self, word):
        node = self.root
        for w in word:
            node = node.children.get(w)
            if not node:
                return False
        return node.isWord

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        res = []
        trie = Trie()
        node = trie.root
        for w in words:
            trie.insert(w)
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, node, i, j, "", res)
        return res

    def dfs(self, board, node, i, j, path, res):
        if node.isWord:
            res.append(path)
            node.isWord = False
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return
        temp = board[i][j]
        node = node.children.get(temp)
        if not node:
            return
        board[i][j] = "#"
        self.dfs(board, node, i + 1, j, path + temp, res)
        self.dfs(board, node, i - 1, j, path + temp, res)
        self.dfs(board, node, i, j + 1, path + temp, res)
        self.dfs(board, node, i, j - 1, path + temp, res)
        board[i][j] = temp
# @lc code=end

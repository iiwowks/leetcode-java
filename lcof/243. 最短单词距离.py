# 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
class Solution:
    def shortestDistance(self, words: List[str], word1: str, word2: str) -> int:
        p1=-1
        p2=-1
        res=float("inf")
        for idx,word in enumerate(words):
            if word==word1:p1=idx
            if word==word2:p2=idx
            if(p1!=-1 and p2!=-1): res=min(res,abs(p1-p2))
        return res
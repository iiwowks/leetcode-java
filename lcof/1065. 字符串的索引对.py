# 给出 字符串 text 和 字符串列表 words,
# 返回所有的索引对 [i, j] 使得在索引对范围内的子字符串 text[i]...text[j]
# （包括 i 和 j）属于字符串列表 words。


class Solution:
    def indexPairs(self, text: str, words: List[str]) -> List[List[int]]:
        res=[]
        for i in range(len(text)):
            for j in range(i,len(text)):
                if text[i:j+1] in words:
                    res.append([i,j])
        return res


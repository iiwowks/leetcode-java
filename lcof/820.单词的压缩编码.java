/*
 * @lc app=leetcode.cn id=820 lang=java
 *
 * [820] 单词的压缩编码
 */

// @lc code=start

//字典树节点定义
class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}

//定义字典树
class Trie{
    TrieNode root;
    //根节点为空
    public Trie(){
        root = new TrieNode();
    }
    
    public int insert(String word){
        TrieNode cur = root;
        boolean isNew = false;
        //
        for(int i = word.length() - 1; i >= 0; i--){
            // ASCII转换为26个字母中对应的序号
            int c = word.charAt(i) - 'a';
            // 序号对应的
            if(cur.children[c] == null){
                //是新单词
                isNew = true;
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        // 如果是新单词的话编码长度增加新单词的长度+1，否则不变
        return isNew ? word.length() + 1: 0;
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += trie.insert(word);
        }
        return len;
    }
}
// @lc code=end


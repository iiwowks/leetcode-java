/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}



public class Trie {
    private boolean is_string=false;
    private Trie next[]=new Trie[26];

    public Trie(){}

    public void insert(String word){//插入单词
        Trie root=this;
        char w[]=word.toCharArray();
        for(int i=0;i<w.length;++i){
            if(root.next[w[i]-'a']==null)root.next[w[i]-'a']=new Trie();
            root=root.next[w[i]-'a'];
        }
        root.is_string=true;
    }

    public boolean search(String word){//查找单词
        Trie root=this;
        char w[]=word.toCharArray();
        for(int i=0;i<w.length;++i){
            if(root.next[w[i]-'a']==null)return false;
            root=root.next[w[i]-'a'];
        }
        return root.is_string;
    }
    
    public boolean startsWith(String prefix){//查找前缀
        Trie root=this;
        char p[]=prefix.toCharArray();
        for(int i=0;i<p.length;++i){
            if(root.next[p[i]-'a']==null)return false;
            root=root.next[p[i]-'a'];
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end


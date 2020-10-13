import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// 有一两个用例过不了，原因不明
// @lc code=start
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList__) {
        Set<String> wordList = new HashSet<String>(wordList__);
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        int len = 1;
        int strlen = beginWord.length();
        HashSet<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        // 双向BFS
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 始终使用小的那个一set扩散
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            // temp: 相当于queue的一层
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                // 变换字符位
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp; // 相当于进队，扩散完一层
            len++;
        }
        return 0;
    }
}
// @lc code=end

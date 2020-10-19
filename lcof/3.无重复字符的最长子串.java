// 方法一：暴力法
// 题目更新后由于时间限制，会出现 TLE。

// 思路

// 逐个检查所有的子字符串，看它是否不含有重复的字符。


class Solution_1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j))
                    ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

}

/*
 * 方法二：滑动窗口 使用HashSet将字符储存在当前窗口[i,j) 最初j=i
 * 然后向右滑动索引j,如果他不在HashSet中，继续滑动j,直到s[j]已经存在于HashSet中，
 * 这样就找到没有重复字符的最长子字符串，将会以索引i开头，对所有i循环，得到答案。
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range[i,j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                // 选取截断长度j-i与旧ans最大值
                ans = Math.max(ans, j - i);
            } else
                set.remove(s.charAt(i++));
        }
        return ans;
    }
}

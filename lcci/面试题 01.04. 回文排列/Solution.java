import java.util.Set;

/**
 * [面试题 01.04. 回文排列] 
 * 使用哈希表，判断是否是回文排列：
 * * 每个字符出现次数为偶数，或者有且只有一个字符出现次数为奇数
 * 
 */

class Solution {
    public boolean canPermutePalidrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }
}

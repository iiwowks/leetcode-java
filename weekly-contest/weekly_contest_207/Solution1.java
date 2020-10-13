/**
 * [1586. 重新排列单词间的空格]
 * 
 */
class Solution1 {
    public String reorderSpaces(String text) {
        int bc = 0, wc = 0;
        for (int i = 0; i < text.length(); i++) {
            // 计算空格数
            if (text.charAt(i) == ' ')
                bc++;
            // 计算单词数
            if ((i == 0 || text.charAt(i - 1) == ' ') && text.charAt(i) != ' ')
                wc++;
        }
        // 单词间的空格数
        int ec = wc == 1 ? bc : bc / (wc - 1);
        StringBuilder sb = new StringBuilder();
        // 
        for (int i = 0; i < text.length(); i++) {
            // 找到第一个非空格位置
            if (sb.length() == 0 && text.charAt(i) == ' ') {
                continue;
            }
            // 单词第一个字符
            if (text.charAt(i) != ' ')
                sb.append(text.charAt(i));
            // 单词最后一个字符
            else if (text.charAt(i - 1) != ' ' && text.charAt(i) == ' ') {
                // 单词后添加 ec个空格
                for (int j = 0; j < ec; j++) {
                    sb.append(' ');
                }
            }
        }
        while (sb.length() < text.length())
            sb.append(' ');
        // 此处在单词末尾添加过一次ec个多余的空格
        if (sb.length() > text.length())
            sb.delete(text.length(), sb.length());
        return sb.toString();
    }
}

/*
 * 自己写的屎山 class Solution { public String reorderSpaces(String text) { int
 * countBlank = 0; char[] ca = text.toCharArray(); int countWords = 0;
 * 
 * for (char c : ca) { if (c == ' ') { countBlank++; } }
 * 
 * StringBuilder sb = new StringBuilder(); String[] words = text.split("\\s");
 * for (String s : words) { if (s != "") { countWords++; } } String temp = "";
 * for (int i = 0; i < countBlank / (countWords - 1); i++) { temp += " "; } int
 * times = countWords - 1; int i = 0; for (String s : words) { if (s != "" && i
 * < times) { sb.append(s + temp); i++; } }
 * 
 * for (int j = 0; j < countBlank % (countWords - 1); j++) { sb.append(" "); }
 * return sb.toString(); } }
 */
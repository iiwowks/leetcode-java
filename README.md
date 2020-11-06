[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/iiwowks/leetcode-solutions)  [![Gitbook zuoti](https://img.shields.io/badge/Gitbook-code--template-blue)](https://1029871348.gitbook.io/zuoti/) [![Leetcode profile](https://img.shields.io/badge/Leetcode-my--profile-blue)](https://leetcode.com/zhengjunan/)

## 2. Add Two Numbers
* 相加两个以链表形式存储的数字，返回链表形式结果
```java
while (p != null || q != null) {
    int x = (p != null) ? p.val : 0;
    int y = (q != null) ? q.val : 0;
    int sum = carry + x + y;
    carry = sum / 10;
    curr.next = new ListNode(sum % 10);
    curr = curr.next;
    if (p != null) p = p.next;
    if (q != null) q = q.next;
}
if (carry > 0) {
    curr.next = new ListNode(carry);
}
```
## 4. Merge Sorted Array
* 方法一：合并两个数组，直接返回中位数
* 方法二：二分查找
## 6. ZigZag Conversion
* 顺序遍历字符串`s`
  * 填入字符：`res[index] += c`
  * 更新行索引：`index += flag`
  * 到达z字形转折点时，反向：`flag = -flag`
## 8. String to Integer (atoi)
1. 去除前导空格
2. 处理正负号
3. 判断数字，越界处理
## 9. Palindrome Number
* 只判断数字x右半边的反转是否与前半边相同
```java
int rev = 0;
while (x > rev) {
    rev = rev * 10 + x % 10;
    x /= 10;
}
```
## 12. Integer to Roman
* 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
* 按照阿拉伯数字的大小降序排列，贪心选择思想
* `int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};`
* `String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};`
## 18. 4Sum
* k 数之和问题都可以转换成：
  * 两数之和问题（使用双指针）
  * k - 1 数之和问题
## 19. Remove Nth Node From End of List
* 遍历两次
* 方法二：双指针，第一个指针**先走n + 1步**，之后两个指针一起走
## 20. Valid Parentheses
* 
## 22. Generate Parentheses
* 回溯
```java
public void backtrack(List<String> list, String str, int open, int close, int max) {
    if (str.length() == max * 2) {
        list.add(str);
        return;
    }
    if (open < max) {
        backtrack(list, str + "(", open + 1, close, max);
    }
    if (close < open) {
        backtrack(list, str + ")", open, close + 1, max);
    }
}
```
## 23. Merge k Sorted Lists
* 实现小根堆：`Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);`
## 24. Swap Nodes in Pairs
* 递归：
  * `newHead = head.next;`
  * `newHead = swap(head.next.next);`
  * `newHead.next = head;`
## 29. Divide Two Integers
```java
public int divide(int A, int B) {
    if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
    int a = Math.abs(A), b = Math.abs(B), res = 0;

    for (int x = 31; x >= 0; x--) {
        // a 无符号右移x位
        if ((a >>> x) - b >= 0) {
            res += 1 << x;
            a -= b << x;
        }
    }
    return (A > 0) == (B > 0) ? res : -res;
}
```
## 31. Next Permutation
* 自右向左扫描，交换降序序列中的第一个逆序对
```java
    while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
    if(i >= 0) {                           // If not entirely descending
        int j = A.length - 1;              // Start from the end
        while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
        swap(A, i, j);                     // Switch i and j
    }
    reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
```
## 33. Search in Rotated Sorted Array
* 相当于二分查找；如果中间的数小于最右边的数，右半段是有序的；大于最右边的数，左半段是有序的。
## 37. Sudoku Solver
```java
if (board[i][j] != '.') {
    int num = board[i][j] - '1';
    row[i][num] = true;
    col[j][num] = true;
    // blockIndex = i / 3 * 3 + j / 3，取整
    block[i / 3 * 3 + j / 3][num] = true;
}
```
## 48. Rotate Image
* 翻转矩阵、再每一行转置：可以达到顺时针旋转的效果
## 51. N-Queens
* **行、列、对角线** 放置状态存储
* DFS
## 52. N-Queens II
* 主对角线：**行下标 - 列下标 = 定值**
* 副对角线：**行下标 + 列下标 = 定值**
## 106. Construct Binary Tree from Inorder and Postorder Traversal
* 后序遍历序列的`final index`，将中序遍历序列分成左右子树，依次递推
* `helper(int left, int right)`
  * `root.left = helper(index + 1, right)`
  * `root.right = helper(left, index - 1)`
## 109. Convert Sorted List to Binary Search Tree
* 快慢指针，寻找中位数做父节点，递归
## 116. Populating Next Right Pointers in Each Node
* 层次遍历
* 方法二：
  1. 同一父节点的两个结点：`node.left.next = node.right`
  2. 不同父节点的节点之间：`node.right.next = node.next.left`
## 117. Populating Next Right Pointers in Each Node II
* BFS
* 用一个last指针指向队列中的结点 `last.next = front; last = front;`
## 127. Word Ladder
* 双向BFS
## 143. Reorder List
* 将链表结点依次存入list，双指针
## 228. Summary Ranges
* `i，j`拓展数组，连续范围：`nums[j + 1] == nums[j] + 1`
## 310. Minimum Height Trees
* `0 ~ n - 1`标号的节点中：找到所有头节点，使得以这个节点为root的树，高度最小。
* 相当于把一个图，从外向里，每次循环 ‘剥去一层’
## 429. N-ary Tree Level Order Traversal
* BFS
## 501. Find Mode in Binary Search Tree
* 二叉搜索树中序遍历，在递增的序列中，寻找频率最高的元素
* 中序遍历中：使用递归回溯、或者栈实现中序遍历
* **Morris中序遍历**：寻找当前节点的前驱节点，并且 Morris 中序遍历寻找下一个点始终是通过转移到 right 指针指向的位置来完成的。
  * 如果当前节点没有左子树，则遍历这个点，然后跳转到当前节点的右子树。
  * 如果当前节点有左子树，那么它的前驱节点一定在左子树上，我们可以在左子树上一直向右行走，找到当前点的前驱节点。
    * 如果前驱节点没有右子树，就将前驱节点的 right 指针指向当前节点。这一步是为了在遍历完前驱节点后能找到前驱节点的后继，也就是当前节点。
    * 如果前驱节点的右子树为当前节点，说明前驱节点已经被遍历过并被修改了 right 指针，这个时候我们重新将前驱的右孩子设置为空，遍历当前的点，然后跳转到当前节点的右子树。
```java
TreeNode cur = root, pre = null;
while (cur != null) {
    if (cur.left == null) {
        update(cur.val);
        cur = cur.right;
        continue;
    }
    pre = cur.left;
    while (pre.right != null && pre.right != cur) {
        pre = pre.right;
    }
    if (pre.right == null) {
        pre.right = cur;
        cur = cur.left;
    } else {
        pre.right = null;
        update(cur.val);
        cur = cur.right;
    }
}
```
## 530. Minimum Absolute Difference in BST
* 二叉搜索树中序遍历
```java
private void inOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    inOrder(root.left);
    //
    if (preNode != null) {
        res = Math.min(Math.abs(root.val - preNode.val), res);
    }
    preNode = root;
    //
    inOrder(root.right);
}
```
## 538. Convert BST to Greater Tree
* 反序中序遍历，在遍历过程中记录节点值之和
```java
if (root != null) {
    convertBST(root.right);
    sum += root.val;
    root.val = sum;
    convertBST(root.left);
}
```
## 673. Number of Longest Increasing Subsequence
* 假设对于以 `nums[i]` 结尾的序列，我们知道最长序列的长度 `length[i]`，以及具有该长度的序列的 `count[i]`。
* 对于每一个 `i < j` 和一个 `A[i] < A[j]`，我们可以将一个 `A[j]` 附加到以 `A[i]` 结尾的最长子序列上。
* 如果这些序列比 `length[j]` 长，那么我们就知道我们有`count[i]` 个长度为 length 的序列。如果这些序列的长度与 `length[j]` 相等，那么我们就知道现在有 `count[i]` 个额外的序列（即 `count[j]+=count[i]`）
## 763. Partition Labels
1. 遍历字符串，维护当前片段下标`start`, `end`
2. 对于每一个字母 `c`，找到其最后出现的下标`end_c`，`end = max(end, end_c)`
3. 访问到 `end`时，结束当前片段， `start = end + 1`
4. 重复以上步骤，直至遍历完整个字符串
## 799. Champagne Tower
* 模拟
  * 流入一个杯子总共 `x`, 流入下两个杯子各 `(x - 1.0) / 2.0`
  * 两层循环递推
## 925. Long Pressed Name
* 双指针
```java
int i = 0, j = 0;
while (j < typed.length()) {
    if (i < name.length() && name.charAt(i)== typed.charAt(j)) {
        i++;
        j++;
    } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
        j++;
    } else {
        return false;
    }
}
return i == name.length();
```
## 1002. Find Common Characters
* 计数： $minfreq[c]$ 统计每一个字符在每个字符串中出现的最小频次
## 1091. Shortest Path in Binary Matrix
* `A* search`：每次优先走离终点近的点
* 定义优先级：
```python
def heuristic(x, y):
    return max(abs(n - 1 - x), abs(n - 1 - y))
```
## 1288. Remove Covered Intervals
* 方法一：枚举
* 方法二：贪心算法：
  * 对起点进行升序排序，如果起点相同，则对终点进行降序排序。
  * 初始化没有被覆盖的区间数：`count=0`。
  * 迭代排序后的区间并且比较终点大小。
    * 如果当前区间不被前一个区间覆盖 `end > prev_end`，则增加 `count`，指定当前区间为下一步的前一个区间。
    * 否则，当前区间被前一个区间覆盖，不做任何事情。
  * 返回 `count`。
## 1365. How Many Numbers Are Smaller Than the Current Number
* 暴力枚举：O(n ^ 2)
* 计数排序：`count[nums[i]]++`，频次数组
* 快速排序：
## 1592. Rearrange Spaces Between Words
* 字符串分割问题：
* 重点：统计空格数、单词数。遍历字符串，找到一个单词的起始位置、终止位置，在单词后添加空格后，用StringBuilder创建字符串
```java
// 计算单词数
if ((i == 0 || text.charAt(i - 1) == ' ') && text.charAt(i) != ' ')
    wc++;
```
* **DFS**: `dfs(String s, int start, int end, int res)`
* 传入字符串的起始位置、终止位置，用set去重
* 在end位置切分：`dfs(s, end + 1, end + 1, res + 1)`
* end位置不切：`dfs(s, start, end + 1, res)`
## 1594. Maximum Non Negative Product in a Matrix
* **DFS**: `dfs(int[][] grid, int i, int j, long temp)`

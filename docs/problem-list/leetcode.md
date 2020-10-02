# 前500题

## 31. 下一个排列

## 37. 解数独

```java
if (board[i][j] != '.') {
    int num = board[i][j] - '1';
    row[i][num] = true;
    col[j][num] = true;
    // blockIndex = i / 3 * 3 + j / 3，取整
    block[i / 3 * 3 + j / 3][num] = true;
}
```

## 51. N 皇后

* **行、列、对角线** 放置状态存储
* DFS

## 106. 从中序与后序遍历序列构造二叉树

* 后序遍历序列的`final index`，将中序遍历序列分成左右子树，依次递推
* `helper(int left, int right)`
  * `root.left = helper(index + 1, right)`
  * `root.right = helper(left, index - 1)`

## 117. 填充每个节点的下一个右侧节点指针 II

* BFS
* 用一个last指针指向队列中的结点 `last.next = front; last = front;`

# 第500-1000题

## 127. 单词接龙

* 双向BFS

```java

```

## 501. 二叉搜索树中的众数

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

## 538. 把二叉搜索树转换为累加树

* 反序中序遍历，在遍历过程中记录节点值之和

```java
if (root != null) {
    convertBST(root.right);
    sum += root.val;
    root.val = sum;
    convertBST(root.left);
}
```

## 968. 监控二叉树


# 第1000-1500题

## 1091. 二进制矩阵中的最短路径

* `A* search`：每次优先走离终点近的点
* 定义优先级：

```python
def heuristic(x, y):
    return max(abs(n - 1 - x), abs(n - 1 - y))
```

## 1592. 重新排列单词间的空格

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

## 1594. 矩阵的最大非负积

* **DFS**: `dfs(int[][] grid, int i, int j, long temp)`

## 1595. 连通两组点的最小成本


## 1599. 经营摩天轮的最大利润


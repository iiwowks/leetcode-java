可以在gitpod中在线编辑：[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/iiwowks/leetcode-solutions)

# 前500题

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

## 6. Z 字形变换

* 顺序遍历字符串`s`
  * 填入字符：`res[index] += c`
  * 更新行索引：`index += flag`
  * 到达z字形转折点时，反向：`flag = -flag`

## 8. 字符串转换整数 (atoi)

1. 去除前导空格
2. 处理正负号
3. 判断数字，越界处理

## 18. 四数之和

* k 数之和问题都可以转换成：
  * 两数之和问题（使用双指针）
  * k - 1 数之和问题

```java
private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    if (index >= len) {
        return res;
    }
    if (k == 2) {
        int i = index, j = len - 1;
        while (i < j) {
            // find a pair
            if (target - nums[i] == nums[j]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(target - nums[i]);
                res.add(temp);
                // skip duplication
                while (i < j && nums[i] == nums[i + 1])
                    i++;
                while (i < j && nums[j - 1] == nums[j])
                    j--;
                i++;
                j--;
                // move left bound
            } else if (target - nums[i] > nums[j]) {
                i++;
                // move right bound
            } else {
                j--;
            }
        }
    } else {
        for (int i = index; i < len - k + 1; i++) {
            // use current number to reduce ksum into k-1sum
            ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
            if (temp != null) {
                // add previous results
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
            while (i < len - 1 && nums[i] == nums[i + 1]) {
                // skip duplicated numbers
                i++;
            }
        }
    }
    return res;
}
```

## 19. 删除链表的倒数第N个节点

* 遍历两次
* 方法二：双指针，第一个指针先走n + 1步，之后两个指针一起走

## 24. 两两交换链表中的节点

* 递归：
  * `newHead = head.next;`
  * `newHead = swap(head.next.next);`
  * `newHead.next = head;`

## 29. 两数相除



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

## 48. 旋转图像

* 翻转矩阵、再每一行转置：可以达到顺时针旋转的效果

## 51. N 皇后

* **行、列、对角线** 放置状态存储
* DFS

## 106. 从中序与后序遍历序列构造二叉树

* 后序遍历序列的`final index`，将中序遍历序列分成左右子树，依次递推
* `helper(int left, int right)`
  * `root.left = helper(index + 1, right)`
  * `root.right = helper(left, index - 1)`



## 116. 填充每个节点的下一个右侧节点指针

* 层次遍历
* 方法二：
  1. 同一父节点的两个结点：`node.left.next = node.right`
  2. 不同父节点的节点之间：`node.right.next = node.next.left`

## 117. 填充每个节点的下一个右侧节点指针 II

* BFS
* 用一个last指针指向队列中的结点 `last.next = front; last = front;`

## 127. 单词接龙

* 双向BFS




# 第500-1000题

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

## 530. 二叉搜索树的最小绝对差

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

# 第1000-1500题



## 1002. 查找常用字符

* 计数： $minfreq[c]$ 统计每一个字符在每个字符串中出现的最小频次



## 1091. 二进制矩阵中的最短路径

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
  * 初始化没有被覆盖的区间数：count=0。
  * 迭代排序后的区间并且比较终点大小。
    * 如果当前区间不被前一个区间覆盖 end > prev_end，则增加 count，指定当前区间为下一步的前一个区间。
    * 否则，当前区间被前一个区间覆盖，不做任何事情。
  * 返回 count。

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


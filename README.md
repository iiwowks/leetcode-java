## 环境

* `VSCode`编辑器
* `java` ：`java extention pack`插件、`jdk 13.0.2`
* `c++` ：`c++ intellisense`、`c/c++`插件、`mingw64`
* `python` ：`python`插件、`python 3.8.1`
* 插件`leetcode`其中的`setting.json`文件的一部分配置

```json
// 用来配置源代码文件存放目录及文件名
"leetcode.filePath": {
    "default": {
        "folder": "",
        "filename": "${id}.${kebab-case-name}.${ext}"
    },
    "java": {
        "folder": "${tag}\\${id}-${kebab-case-name}",
        "filename": "Solution.${ext}"
    },
    "python3": {
        "folder": "${tag}\\${id}-${kebab-case-name}",
        "filename": "Solution.${ext}"
    },
    "cpp": {
        "folder": "${tag}\\${id}-${kebab-case-name}",
        "filename": "Solution.${ext}"
    }
},
"editor.fontFamily": "Consolas, Fira Code, 'Courier New', monospace",
"editor.fontLigatures": true,
"leetcode.hint.setDefaultLanguage": false,
```

## 说明

这个repo主要是自己<mark>练手用</mark>，几天不做题，就容易手生。

- [x] **一题多解，一题多遍**
- [x] 做题时**注释**很重要，尽量多写注释
- [x] 不要太重视解题代码，**解题的思路才是关键**

## 目标

- [x] <mark>每天提交20次以上</mark>
- [ ] **2020年 solve 500 道题，提交2000次**
- [ ] <mark>每个农名都有一个大厂梦————淦！！！</mark>


> 注意：这个repo是我2020年8月毕业在家记录刷题而创建的，题解和代码大部分都可以在官网上找到。创建repo的目的在于记录

# 算法模板

## 递归模板

* 把自己的状态带到下一层，之后又把改变带回来。环境其它属性、方法不受影响
* 寻找**最近重复子问题**
* **最近重复性**
* 最优重复性
* 数学归纳法思维

```java
public void recur(int level, int param1, ..., paramN) {
    // 1. 递归终止条件
    if (level > MAX_LEVEL) { return; }

    // 2. 处理当前层逻辑
    process(level, param);

    // 3. 下探到下一层（可以剪枝）
    recur(level + 1, newParam, ..., newParamN)

    // 4. 清理当前层（可选）
}
```

## 分治模板

```java
private static int divide_conquer(Problem problem, ) {
  // 1. recursion terminator
  if (problem == NULL) {
    int res = process_last_result();
    return res;
  }

  // 2. process current problem
  subProblems = split_problem(problem)
  
  // 2.5. conquer subproblems
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  
  // 3. merge
  result = process_result(res0, res1); // 组合子结果
  
  // 4. revert the current level status
  return result;
}
```

## 回溯

* 回溯算法是一种遍历算法，以**深度优先遍历**的方式尝试所有可能性，是**有方向地**搜索
* 不断尝试，直到不能尝试为止，回退到上一步，继续尝试。

## DFS模板

![algorithm-dfs](https://i.loli.net/2020/09/09/eRgmIjpVhB5D6qT.png)

```python
visited = set()
# 递归版本
def dfs(node, visited):
    if node in visited: # terminator
        # already visited
        return
    visited.add(node)
    # process current node here.
    ...
    for next_node in node.children():
        if next_node not in visited:
            dfs(next_node, visited)

# 非递归版本
def DFS(self, root):

    if tree.root is None:
    return []
    visited, stack = [], [root]
    while stack:
        node = stack.pop()
        visited.add(node)
        process (node)
        # 生成相关的节点
        nodes = generate_related_nodes(node)
        stack.push(nodes)
    # other processing work
    ...
```

```java
void dfs(TreeNode root) {
    if (root == null) {
        return;
    }
    dfs(root.left);
    dfs(root.right);
}
```

```java
// 状态: 每个结点表示了求解问题的不同阶段
// 回到上一层结点时需**状态重置**
// 通常可以使用以下的**状态变量：**
// 递归到第几层 `depth`  递归路径 `path`  布尔数组 `used`

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if(root == null) {
        return allResults;
    }
    dfs(root, 0, allResults);
    return allResults;
}
private dfs(TreeNode root, int level, List<List<Integer>> results) {
    if(results.size() == level) {
        results.add(new ArrayList<>());
    }
    results.get(level).add(root.val);
    if(root.left != null){
        dfs(root.left, level + 1, results);
    }
    if(root.right != null){
        dfs(root.right, level + 1, results);
    }
}
```

## BFS模板

![algorithm-bfs](https://i.loli.net/2020/09/09/R9o6buwtjcaMfdP.png)

![algorithm-bfs-queue](https://i.loli.net/2020/09/09/n9ZAc62mhibNWkd.gif)

```python
def BFS(root):
    visited = set()
    queue = []
    queue.append([root])

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)

    # other processing work
```

```java
void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
```

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```

## 贪心算法

贪心算法是在每一步选择中都采取在当前状态下最好或最优（最有利）的选择，从而希望导致结果是全局最好或最优的算法。

* **贪心：当下做局部最优判断**
* **回溯：能够回退**
* **动态规划：最优判断 + 回退**

## 二分查找模板

```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
```



## topK 问题

```
给定整数数组arr, 找到其中最小的k个数
```

*求前K大、前K小、第K大、第K小问题，有四种方法：*

1. **O(n): 快速排序**

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // ⚠️注意最后一个参数传入我们要找的下标（第k小的数下标是k-1）
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int low, int high, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, low, high);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, low, j - 1, k): quickSearch(nums, j + 1, high, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int low, int high) {
        int v = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i <= high && nums[i] < v);
            while (--j >= low && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[low] = nums[j];
        nums[j] = v;
        return j;
    }
}
```

2. **O(nlogK): 大根堆（前k小）、小根堆（前k大）**

**`java`中的`PriorityQueue`（默认小根堆）**

```java
// 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
// 1. 若目前堆的大小小于K，将当前数字放入堆中。
// 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大(或等于)，这个数就直接跳过；
//    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }
}
```

3. **O(nlogK): 二叉搜索树**

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num: arr) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大(或等于)，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }

        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
}
```

4. **计数排序 O(n)**

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num: arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }
}
```

## 数学

### 牛顿迭代法求平方根

```java
int mysqrt(int x){
    double tmpx = x;
    double k = 1.0;
    double k0 = 0.0;
    while(abs(k0-k) >= 1){
        k0 = k;
        k = (k + tmpx/k)/2;
    }
    return (int)k;
}
```

### 摩尔投票法

* 遇到符合要求的 `+ 1`；不合要求的` - 1`，看最后剩下的数字
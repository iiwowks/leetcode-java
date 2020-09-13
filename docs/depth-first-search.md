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

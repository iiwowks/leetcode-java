# BFS模板

![algorithm-bfs-queue](../assets/algorithm-bfs-queue.gif)

```
void BFS()
{
    定义队列
    定义备忘录，用于记录已经访问的位置
    判断边界条件，是否能直接返回结果的

    将起始位置加入到队列中，同时更新备忘录
    while (队列不为空) {
        获取当前队列中的元素个数
        for (元素个数) {
            取出一个位置节点
            判断是否到达终点位置
            获取它对应的下一个所有的节点
            条件判断，过滤掉不符合条件的位置
            新位置重新加入队列
        }
    }
}
```

{% tabs %}
{% tab title="Java" %}
```java
// 写法一：
public void bfs(TreeNode root) {
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
// 写法二：
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
{% endtab %}

{% tab title="Python" %}
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
{% endtab %}
{% endtabs %}

## two-ended BFS双向BFS

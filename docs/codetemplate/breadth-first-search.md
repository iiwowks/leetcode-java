# BFS模板

![algorithm-bfs](https://i.loli.net/2020/09/09/R9o6buwtjcaMfdP.png)

![algorithm-bfs-queue](https://i.loli.net/2020/09/09/n9ZAc62mhibNWkd.gif)

{% tabs %}
{% tab title="Java"%}
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
{% endtab %}
{% tab title="Java"%}
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

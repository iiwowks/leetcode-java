# 启发式搜索（A*）模板

* 估价函数：`h(n)`用来评估哪些点是我们最希望的结点

* [1091. 二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/)
* [773. 滑动谜题](https://leetcode-cn.com/problems/sliding-puzzle/)
* 估价函数：`h(current_point) = dist(current_point, destination_point)`
* 

{% tabs %}

{% tab title="Python" %}

```python
def AstarSearch(graph, start, end):
    pq = collections.priority_queue() # 优先级 —> 估价函数
    pq.append([start])
    visited.add(start)

    while pq:
        node = pq.pop() # add more intelligence here
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        unvisited = [node for node in nodes if node not in visited]
        pq.push(unvisited)
```
{% endtab %}

{% tab title="Cpp" %}

```cpp
class Node {
public:
    int x;
    int y;
    bool operator< (const Node &A) {
        // 
    }
};

void generate_related_nodes(Node &node) {
    // 
}

void process(Node &node) {
    // 
}

void AstarSearch(vector<vector<int>>& graph, Node& start, Node& end) {
    vector<vector<bool> > visited(graph.size(), vector<bool>(graph[0].size(), false));
    priority_queue<Node> q;
    q.push(start);

    while (!q.empty()) {
        Node cur = q.top();
        q.pop();
        visited[cur.x][cur.y] = true;

        process(node);
        vector<Node> nodes = generate_related_nodes(node) 
        for (auto node : nodes) {
            if (!visited[node.x][node.y]) q.push(node);
        }
    }

    return ;
}
```

{% endtab %}
{% endtabs %}
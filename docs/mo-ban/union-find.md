# 并查集模板

* `makeSet(s)`: 建立一个新的并查集，其中包含`s`个单元素集合
* `unionSet(x, y)`: 把元素`x`和元素`y`所在的集合**合并**，要求`x`和`y`所在的集合不相交；如果相交则不合并
* `find(x)`: 找到元素`x`所在集合的**代表**，该操作也可以用于判断两个元素是否位于同一个集合，比较各自的代表

{% tabs %}
{% tab title="Java" %}
```java
class UnionFind {
    private int count = 0; // 集合size
    private int[] parent;

    // 初始化parent[i] = i, 自己指向自己
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) { // 集合领头元素：parent[i] == i
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p); // 找到两个领头元素
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        parent[rootP] = rootQ;
        count--; // 独立的集合减少了一个
    }

    boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
```
{% endtab %}

{% tab title="Python" %}
```python
def init(p):
    # for i = 0 .. n: p[i] = i;
    p = [i for i in range(n)]

def union(self, p, i, j):
    p1 = self.parent(p, i)
    p2 = self.parent(p, j)
    p[p1] = p2

def parent(self, p, i):
    root = i
    while p[root] != root:
        root = p[root]
    # 路径压缩：O(1)找到parent
    while p[i] != i:
        x = i
        i = p[i]
        p[x] = root
    return root
```
{% endtab %}
{% endtabs %}


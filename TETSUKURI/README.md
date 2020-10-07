# 0x01 位运算

## a^b

1. `b & 1` :取出b 在二进制表示下的最低位
2. `b >> 1` : 舍去最低位
3. 使用 1，2 就可以遍历b在二进制表示下的所有数位

* $a^b = \prod_{i=0}^{k-1} a^{c_i*2^i}$

```cpp
int ans = 1 % p;
for (; b; b >>= 1) {
    if (b & 1) ans = (long long)ans * a % p;
    a = (long long)a * a % p;
}
```

## 64位整数除法

* **快速幂**，把整数用二进制表示
* $a*b = \sum_{i=0}^{k-1}c_i*a*2^i$

```cpp
long long ans = 0;
for (; b; b >>= 1) {
    if (b & 1) ans = (ans + a) % p;
    a = a * 2 % p;
}
```

## 最短Hamilton路径

* 二进制状态压缩dp
* 使用一个n位二进制数，其中第i位（0 <= i < n）为 1，表示第 i个点已经被访问
* `f[i, j] = min{F[i xor (1 << j), k] + weight(k, j)}`

## 起床困难综合症

* 
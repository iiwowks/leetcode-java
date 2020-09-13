# 数学

## 牛顿迭代法求平方根

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

## 摩尔投票法

* 遇到符合要求的 `+ 1`；不合要求的`- 1`，看最后剩下的数字


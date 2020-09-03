## 环境

* `vscode + leetcode plugin`
* `node.js`
* `IDEA`
* 在该插件`setting.json`文件的一部分配置

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
    }
},
"editor.fontFamily": "Monaco, Consolas, 'Courier New', monospace",
"editor.fontSize": 13,
"leetcode.hint.setDefaultLanguage": false,
```

## 说明

这个repo主要是自己<mark>练手用</mark>，几天不做题，就容易手生。

- [x] **一题多解，一题多遍**
- [x] 做题时**注释**很重要，尽量多写注释
- [x] 不要太重视解题代码，**解题的思路才是关键**
- [ ] **TARGET:** `2020/08 ~ Now`解决300道题，提交1000次
- [ ] <mark>每天提交20次以上</mark>

> 注意：这个repo是我2020年8月毕业在家记录刷题而创建的，题解和代码大部分都可以在官网上找到。创建repo的目的在于记录

# 算法模板

## 递归

* <mark>把自己的状态带到下一层，之后又把改变带回来。环境其它属性、方法不受影响</mark>
* <mark>寻找**最近重复子问题**</mark>
* <mark>数学归纳法思维</mark>

```java
public void recur(int level, int param) {
    // 1. 递归终止条件
    if (level > MAX_LEVEL) { return; }

    // 2. 处理当前层逻辑
    process(level, param);

    // 3. 下探到下一层（可以剪枝）
    recur(level + 1, newParam)

    // 4. 清理当前层（可选）
}
```

## 回溯

* <mark>回溯算法是一种遍历算法，以**深度优先遍历**的方式尝试所有可能性，是**有方向地**搜索</mark>
* <mark>不断尝试，直到不能尝试为止，回退到上一步，继续尝试。</mark>


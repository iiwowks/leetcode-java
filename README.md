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

> 注意：这个repo是我2020年8月毕业在家记录刷题而创建的，题解和代码大部分都可以在官网上找到。创建repo的目的在于记录

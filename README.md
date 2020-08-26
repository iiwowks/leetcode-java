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

这个repo主要是让自己练手，几天不做题，就容易手生。
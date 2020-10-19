"""
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）
[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]
但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
路径不能再次进入这个格子。
 """

""" 
整体思路：
使用深度优先搜索（DFS）和回溯的思想实现。关于判断元素是否使用过，我用了一个二维数组 mark 对使用过的元素做标记。

外层：遍历
首先遍历 board 的所有元素，先找到和 word 第一个字母相同的元素，然后进入递归流程。假设这个元素的坐标为 (i, j)，进入递归流程前，先记得把该元素打上使用过的标记：

mark[i][j] = 1
内层：递归
好了，打完标记了，现在我们进入了递归流程。递归流程主要做了这么几件事：

从 (i, j) 出发，朝它的上下左右试探，看看它周边的这四个元素是否能匹配 word 的下一个字母
如果匹配到了：带着该元素继续进入下一个递归
如果都匹配不到：返回 False
当 word 的所有字母都完成匹配后，整个流程返回 True
几个注意点
递归时元素的坐标是否超过边界
回溯标记 mark[i][j] = 0以及 return 的时机
 """


from typing import List


class Solution:
    #         (x-1,y)
    # (x,y-1) (x,y) (x,y+1)
    #         (x+1,y)

    directions = [(0, -1), (-1, 0), (0, 1), (1, 0)]

    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        if m == 0:
            return False
        n = len(board[0])

        marked = [[False for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                # 对每一个格子都从头开始搜索
                if self.__search_word(board, word, 0, i, j, marked, m, n):
                    return True
        return False

    def __search_word(self, board, word, index,
                      start_x, start_y, marked, m, n):
        # 先写递归终止条件
        if index == len(word) - 1:
            return board[start_x][start_y] == word[index]

        # 中间匹配了，再继续搜索
        if board[start_x][start_y] == word[index]:
            # 先占住这个位置，搜索不成功的话，要释放掉
            marked[start_x][start_y] = True
            for direction in self.directions:
                new_x = start_x + direction[0]
                new_y = start_y + direction[1]
                # 注意：如果这一次 search word 成功的话，就返回
                if 0 <= new_x < m and 0 <= new_y < n and \
                        not marked[new_x][new_y] and \
                        self.__search_word(board, word,
                                           index + 1,
                                           new_x, new_y,
                                           marked, m, n):
                    return True
            marked[start_x][start_y] = False
        return False


    
















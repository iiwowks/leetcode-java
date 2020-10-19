"""
 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
"""
from typing import List

#思路：从‘左下角’或‘右上角’开始找
class Solution:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        
        rows=len(matrix)
        if rows==0:
            return False
            
        cols=len(matrix[0])-1
        if cols==0: 
            return False
        #从右上角开始
        x=0
        y=cols-1
        while x<rows and y>=0:
            if target==matrix[x][y]: return True
            elif target<matrix[x][y]:
                y-=1
            else:
                x+=1
        return False


print(Solution().findNumberIn2DArray([
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
],1))

""" 

matrix=[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
print(len(matrix)) """
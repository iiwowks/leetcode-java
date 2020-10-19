'''
如果一个整数上的每一位数字与其相邻位上的数字的绝对差都是 1，那么这个数就是一个「步进数」。
例如，321 是一个步进数，而 421 不是。
给你两个整数，low 和 high，请你找出在 [low, high] 范围内的所有步进数，并返回 排序后 的结果。
# '''
# 超时了
# class Solution:
    
#     def valid(self,i):
#         string=str(i)
#         for i in range(1,len(string)):
#             if abs(int(string[i])-int(string[i-1]))!=1:
#                 return False
#         return True

#     def countSteppingNumbers(self, low: int, high: int) -> List[int]:
#         res=[]
#         for i in range(low,high+1):
#             if self.valid(i):
#                 res.append(i)
#         return res  



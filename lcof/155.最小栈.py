#
# @lc app=leetcode.cn id=155 lang=python3
#
# [155] 最小栈
#
# @lc code=start
# 设计一个支持 push，pop，top 操作，
# 并能在常数时间内检索到最小元素的栈。



# 辅助栈和数据栈同步
class MinStack:

    def __init__(self):
      #数据栈
      self.data=[]
      self.helper=[]
    
    
    #这个push操作保证了helper辅助栈最后一个元素是最小值，遇到x值比最后一个元素还大的情况，辅助栈复制原来最后一个元素的值，作为新的最后值
    def push(self, x: int) -> None:
        self.data.append(x)
        if len(self.helper)==0 or x<=self.helper[-1]:
            self.helper.append(x)
        else:
            self.helper.append(self.helper[-1])


    def pop(self) -> None:
        if self.data:
            #同步弹出最后一个值
            self.helper.pop()
            return self.data.pop()
            
    def top(self) -> int:
        if self.data:
            return self.data[-1]
        

    def getMin(self) -> int:
        if self.helper:
            return self.helper[-1]

# 方法二：辅助栈和数据栈不同步
# 参考代码 2：

class MinStack:

    # 辅助栈和数据栈不同步
    # 关键 1：辅助栈的元素空的时候，必须放入新进来的数
    # 关键 2：新来的数小于或者等于辅助栈栈顶元素的时候，才放入（特别注意这里等于要考虑进去）
    # 关键 3：出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈，即"出栈保持同步"就可以了

    def __init__(self):
        # 数据栈
        self.data = []
        # 辅助栈
        self.helper = []

    def push(self, x):
        self.data.append(x)
        # 关键 1 和关键 2
        if len(self.helper) == 0 or x <= self.helper[-1]:
            self.helper.append(x)

    def pop(self):
        # 关键 3：【注意】不论怎么样，数据栈都要 pop 出元素
        top = self.data.pop()

        if self.helper and top == self.helper[-1]:
            self.helper.pop()
        return top

    def top(self):
        if self.data:
            return self.data[-1]

    def getMin(self):
        if self.helper:
            return self.helper[-1]
# 时间复杂度：O（1）
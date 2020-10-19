""" 
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能
(若队列中没有元素，deleteHead 操作返回 -1 ) 
"""
# 暴力解法


class CQueue:

    def __init__(self):
        self.st1 = []
        self.st2 = []

    def appendTail(self, value: int) -> None:
        self.st1.append(value)

    def deleteHead(self) -> int:
        while self.st1:
            cur = self.st1.pop(-1)
            self.st2.append(cur)
        res = self.st2.pop(-1) if self.st2 else -1
        #储存到st1
        while self.st2:
            cur = self.st2.pop(-1)
            self.st1.append(cur)
        return res


# Your CQueue object will be instantiated and called as such:
# obj = CQueue()
# obj.appendTail(value)
# param_2 = obj.deleteHead()

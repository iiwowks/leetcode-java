class Solution:
    def minArray(self, numbers: List[int]) -> int:
        n=len(numbers)
        if n==0:return 0
        for i in range(1,n):
            if numbers[i]<numbers[i-1]:
                return numbers[i]
        return numbers[0]
""" 
a=2
i=list(range(a-2))
print(i) """
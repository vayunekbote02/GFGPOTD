class Solution:
    def makeBeautiful(self, arr: List[int]) -> List[int]:
        # code here
        l = []
        for i in range(len(arr)):
            if len(l) == 0:
                l.append(arr[i])
            else:
                if self.check(l[-1], arr[i]):
                    l.pop(-1)
                else:
                    l.append(arr[i])
                    
        return l
                    
    def check(self, a, b):
        if (a >= 0 and b < 0) or (a < 0 and b >= 0):
            return True

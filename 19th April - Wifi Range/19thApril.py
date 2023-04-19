# Python solution
class Solution:
    def wifiRange(self, N, S, X): 
        #code here
        count = 0
        for i in S:
            if i == '1':
                count = X
            else:
                count -= 1
                if count < -X:
                    return False
                
        if count < 0:
            return False
        return True

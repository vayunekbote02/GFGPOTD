# Python solution
class Solution:
    def wifiRange(self, N, S, X): 
        #code here
        count = 0
        for i in S:
            if i == '1':
                count = X
            else:
                if count < -X + 1:
                    return False
                count -= 1
                
        if count < 0:
            return False
        return True
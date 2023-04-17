# Python solution
class Solution:
    
    #Function to find the maximum profit and the number of jobs done.
    def JobScheduling(self,arr,n):
        Jobs.sort(key=lambda x:x.profit, reverse=True)
        extra = [0] * max(i.deadline for i in Jobs)
        total_profit, count = 0, 0
        
        for i in Jobs:
            j = i.deadline - 1
            while j >= 0:
                if extra[j] == 0:
                    total_profit += i.profit
                    count += 1
                    extra[j] = 1
                    break
                else:
                    j -= 1
                    
        return [count, total_profit]
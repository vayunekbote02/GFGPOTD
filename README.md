# GFGPOTD (Solution code below ↓)
## GFG Potd - 17th April
### Job Sequencing Problem: 
Given a set of **N** jobs where each job<sub>i</sub> has a deadline and profit associated with it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.

```
// C++ solution

```

```
// Java solution

```

```
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
```

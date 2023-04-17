# GFGPOTD 17th April (Solution code below ↓)
![image](https://user-images.githubusercontent.com/91115665/232490925-c06a00c3-632e-46d9-b77c-0af434efcacf.png)

## GFG Potd - 17th April
### Job Sequencing Problem: 
Given a set of **N** jobs where each **job<sub>i</sub>** has a deadline and profit associated with it. Each job takes ***1*** unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the number of jobs done and the **maximum profit**.

**Note**: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.

![image](https://user-images.githubusercontent.com/91115665/232490112-04ebe08c-9c81-4f89-8413-51454e0982d9.png)

**Your Task** :
You don't need to read input or print anything. Your task is to complete the function **JobScheduling()** which takes an integer **N** and an array of Jobs(Job id, Deadline, Profit) as input and returns an array **ans[ ]** in which **ans[0] contains the count of jobs and ans[1] contains maximum profit**.

**Expected Time Complexity**: O(NlogN)
**Expected Auxilliary Space**: O(N)

**Constraints**:
1 <= N <= 105
1 <= Deadline <= 100
1 <= Profit <= 500

```
// C++ solution
class Solution 
{
    public:
    //Function to find the maximum profit and the number of jobs done.
    vector<int> JobScheduling(Job arr[], int n) 
    { 
        // your code here
         vector<pair<int, int>> v;
        vector<int> res(2,0);
        vector<bool> vis(n,false);
        for(int i=0;i<n;i++){
            v.push_back(make_pair(arr[i].profit,arr[i].dead));
        }
        sort(v.begin(),v.end(),greater<pair<int,int>>() );
        for(auto t: v){
            int profit=t.first,deadline=t.second-1;
            deadline=min(deadline,n);
            if(vis[deadline]) {
                for(int i=deadline;i>=0;i--){
                    if(vis[i]==false) {
                        res[0]++,res[1]+=profit;
                        vis[i]=true;
                        break;
                    }
                }
            }
            else{
                res[0]++,res[1]+=profit;
                vis[deadline]=true;
            }
        }
        return res;
    } 
};
```

```
// Java solution
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int c=0,totalprofit=0;
        Arrays.sort(arr,(x,y)->x.deadline-y.deadline);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(arr[i].deadline>pq.size())pq.add(arr[i].profit);
            else if(arr[i].deadline==pq.size()){
                if(arr[i].profit>pq.peek()){
                    pq.poll();
                    pq.add(arr[i].profit);
                }
            }
        }
        int ans[]=new int[2];
        c=pq.size();
        while(!pq.isEmpty())totalprofit+=pq.poll();
        ans[0]=c;
        ans[1]=totalprofit;
        return ans;
    }
}
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

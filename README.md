# GFGPOTD (Solution code below ↓)
## GFG Potd - 15th April
### Find Total Time Taken: 
You are given an array arr of size n, containing the values in between 1 to n & time of size n, containg time in sec, you are asked to determine the total time taken in order to pick all the array elements from left to right but there is a condition, If from left, previous elments are different it takes 1 Sec to pick & if element got repeated then it will take time[arr[i]].

**NOTE:**
1. It takes 1 sec to move from index i to i+1 (1 <= i < n).
2. 1-based indexing.
![image](https://user-images.githubusercontent.com/91115665/232224951-5285fab8-32e3-4457-94d7-4bfdce94858b.png)

```
// C++ solution
class Solution {
  public:
    int totalTime(int n, vector<int> &arr, vector<int> &time) {
        // code here
        map<int,bool> visited;
        int t=-1;
        for( int i=0; i<n; i++ )
            visited[arr[i]] = false;
        for( int i=0; i<n; i++ ){
            if( !visited[arr[i]] ){
                visited[arr[i]] = true;
                t++;
            }
            else
                t+=time[arr[i]-1];
        }
        return t;
    }
};
```

```
// Java solution
class Solution
{
    public static long totalTime(int n,int arr[],int time[])
    {
        long count=0;
        HashSet<Integer> hs=new HashSet<>();
        hs.add(arr[0]);
        for(int i=1;i<n;i++){
            if(hs.contains(arr[i])){
                count+=time[arr[i]-1];
            }else{
                hs.add(arr[i]);
                count+=1;
            }
        }
        return count;
    }
}
```

```
# Python solution
class Solution:
    def totalTime(self, n : int, arr : List[int], time : List[int]) -> int:
        # code here
        s = set()
        s.add(arr[0])
        
        total_time = 0
        for i in range(1, n):
            if arr[i] not in s:
                total_time += 1
                s.add(arr[i])
            else:
                total_time += time[arr[i]-1]
            
        return total_time
```

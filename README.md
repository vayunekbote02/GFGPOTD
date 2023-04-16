# GFGPOTD (Solution code below ↓)
## GFG Potd - 16th April
### Unequal Arrays: 
You are given two arrays A and B each of length N. You can perform the following operation on array A zero or more times. 

- Select any two indices i and j, 1 <= i , j <= N and i != j
- Set A[i] = A[i] + 2 and A[j] = A[j]-2

Find the minimum number of operations required to make A and B equal.

*Note :*

- Two arrays are said to be equal if the frequency of each element is equal in both of them.
- Arrays may contain duplicate elements.

![image](https://user-images.githubusercontent.com/91115665/232280025-390b9f13-831f-4ee9-8dd3-b8d6e420953f.png)

```
// C++ solution
class Solution {
  public:
    long long solve(int N, vector<int> &A, vector<int> &B) {
        
        vector<int> a[2], b[2];
        
        long long s1=0, s2=0;
        
        for(int i=0; i<N; i++){
            s1+=A[i];
            s2+=B[i];
            
            if(abs(A[i])%2==0)
                a[0].push_back(A[i]);
            else
                a[1].push_back(A[i]);
            
            if(abs(B[i])%2==0)
                b[0].push_back(B[i]);
            else
                b[1].push_back(B[i]);
        }
        
        if(s1!=s2 or (a[0].size()!=b[0].size()))
        {
            return -1;
        }
        
        long long ans = 0;
    
        for(int i = 0; i < 2; i++) 
        {
            sort(a[i].begin(), a[i].end());
            sort(b[i].begin(), b[i].end());
            
            for(int j = 0; j < a[i].size(); j++) 
            {
                ans += abs(a[i][j] - b[i][j]) / 2;
            }
        }
        return ans / 2;
    }
};
```

```
// Java solution
class Solution {
    public static long solve(int N, int[] A, int[] B) {
        Arrays.sort(A); // closer element should remain closer 
        Arrays.sort(B); // Minimum opern
        List<Integer> Aodds = new ArrayList<Integer>();
        List<Integer> Aevens = new ArrayList<Integer>();
        List<Integer> Bodds = new ArrayList<Integer>();
        List<Integer> Bevens = new ArrayList<Integer>();
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += A[i];
            sum2 += B[i];
            if (A[i] % 2 != 0) {
                Aodds.add(A[i]);
            } else {
                Aevens.add(A[i]);
            }
            if (B[i] % 2 != 0) {
                Bodds.add(B[i]);
            } else {
                Bevens.add(B[i]);
            }
        }
        // confirmation that A->B
        if (sum1 != sum2 || Aodds.size() != Bodds.size()) {
            return -1;
        }

        long ans = 0;
        for (int i = 0; i < Aodds.size(); i++) {
            ans += Math.abs(Aodds.get(i) - Bodds.get(i));
        }
        for (int i = 0; i < Aevens.size(); i++) {
            ans += Math.abs(Aevens.get(i) - Bevens.get(i));
        }
        return ans / 4;
    }
}
```

```
# Python solution
from typing import List
class Solution:
    def solve(self, N : int, A : List[int], B : List[int]) -> int:
        # code here
        if sum(A) != sum(B):
            return -1
            
        A.sort()
        B.sort()
        
        ae, ao, be, bo = [], [], [], []
        for i in A:
            if i % 2 == 0:
                ae.append(i)
            else:
                ao.append(i)
                
        for i in B:
            if i % 2 == 0:
                be.append(i)
            else:
                bo.append(i)
        
        if len(bo) != len(ao) or len(be) != len(ae):
            return -1
            
        count = 0
        for i in range(len(ae)):
            if be[i] > ae[i]:
                count += (be[i] - ae[i]) // 2
        for i in range(len(ao)):
            if bo[i] > ao[i]:
                count += (bo[i] - ao[i]) // 2
                
        return count
```

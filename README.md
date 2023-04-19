# GFGPOTD 19th April (C++, Java, Python solution code below ↓)
![image](https://user-images.githubusercontent.com/91115665/232490925-c06a00c3-632e-46d9-b77c-0af434efcacf.png)

## GFG Potd - 19th April
### Wifi Range: 
There are **N** rooms in a straight line in Geekland State University's hostel, you are given a binary string **S** of length **N** where **S[i] = '1'** represents that there is a wifi in i<sup>th</sup> room or **S[i] = '0'** represents no wifi. Each wifi has range **X** i.e. if there is a wifi in ith room then its range will go upto **X** more rooms on its left as well as right. You have to find whether students in all rooms can use wifi.

![image](https://user-images.githubusercontent.com/91115665/232979397-212c402f-d41f-4010-b392-861474ad0e9a.png)

**Expected Time Complexity**: O(N) <br/>
**Expected Auxilliary Space**: O(1)

**Constraints**: <br/>
1 ≤ N ≤ 10<sup>6</sup> <br/>
0 ≤ X ≤ 10<sup>6</sup> <br/>

```
// C++ solution
class Solution{
    public:
    bool wifiRange(int N, string S, int X){
        int l = -1;
        for(int i = 0; i < N; i++)
        {
            if(S[i] == '1')
            {
                if(i-X-1 > l) return false;
                l = i+X;
            }
        }
        if(l < N-1) return false;
        return true;
    }
};
```

```
// Java solution
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        // code here
        int c = 0;
        int i = 0;
        while(i<N){
            if(S.charAt(i)=='0')
                c++;
            else
                c = (-1)*(X);
            i++;
            if(c>X)
                return false;
        }
        if(c>0)
            return false;
        return true;

    }
} 
```

```
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
```

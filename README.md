# GFGPOTD (Solution code below ↓)
## GFG Potd - 14th April
### Remove the balls: 
Imagine an imaginary array of length N containing balls. Given 2 arrays color and radius of length N each, where color[i] represents the color of the ith ball while radius[i] represents the radius of ith ball. If two consecutive balls have the same color and size, both are removed from the array. Geek wants to know the length of the final imaginary array.
![image](https://user-images.githubusercontent.com/91115665/231933669-10c2311c-a2bc-49fe-a96d-e1416f0ee982.png)

```
// C++ solution
class Solution {
  public:
    int finLength(int N, vector<int> color, vector<int> radius) {
        stack<pair<int,int>> st;
        for(int i=0;i<N;i++)
        {
            pair<int,int> p={color[i],radius[i]};
            if(!st.empty() && st.top()==p)
            {
                st.pop();
                continue;
            }
            st.push(p);
        }
        return st.size();
    }
};
```

```
// Java solution
class Solution {
    public static int finLength(int n, int[] color, int[] radius) {
        // code here
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{color[0] , radius[0]});
        
        for(int i = 1; i<n; i++){
            
            if( !stack.isEmpty() && color[i]== stack.peek()[0] && radius[i]== stack.peek()[1]){
                stack.pop();
            }
            else stack.push(new int[]{color[i], radius[i]});
        }
        
        return stack.size();
    }
}
```

```
# Python solution
class Solution:
    def finLength(self, N : int, color : List[int], radius : List[int]) -> int:
        # code here
        stack = []
        for i in range(N):
            if len(stack) != 0 and [color[i], radius[i]] == stack[-1]:
                stack.pop()
                continue
            stack.append([color[i], radius[i]])
            
        return len(stack)
```

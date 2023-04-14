# GFGPOTD
## GFG Potd - 14th April
### Remove the balls: 
Imagine an imaginary array of length N containing balls. Given 2 arrays color and radius of length N each, where color[i] represents the color of the ith ball while radius[i] represents the radius of ith ball. If two consecutive balls have the same color and size, both are removed from the array. Geek wants to know the length of the final imaginary array.
![image](https://user-images.githubusercontent.com/91115665/231933669-10c2311c-a2bc-49fe-a96d-e1416f0ee982.png)

```
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

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
